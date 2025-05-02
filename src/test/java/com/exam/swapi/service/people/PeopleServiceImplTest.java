package com.exam.swapi.service.people;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleServiceImplTest {

    @Mock
    private ISwapiClient swapiClient;

    @InjectMocks
    private PeopleServiceImpl peopleService;

    @Test
    @DisplayName("Debe devolver la lista de personas para una página válida")
    void testListPeopleReturnsData() {
        PeoplePageResponseDTO mockResponse = new PeoplePageResponseDTO();
        when(swapiClient.getPeople(1)).thenReturn(mockResponse);

        PeoplePageResponseDTO result = peopleService.listPeople(1);

        assertNotNull(result);
        verify(swapiClient).getPeople(1);
    }

    @Test
    @DisplayName("Debe devolver detalle de persona cuando el ID es válido")
    void testFindPersonByIdValid() {
        PersonDetailDTO mockResponse = new PersonDetailDTO();
        PersonDetailDTO.PersonResultDTO resultDTO = new PersonDetailDTO.PersonResultDTO();
        mockResponse.setResult(resultDTO);

        when(swapiClient.getPersonById("123")).thenReturn(mockResponse);

        PersonDetailDTO result = peopleService.findPersonById("123");

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException cuando no se encuentra una persona por ID")
    void testFindPersonByIdNotFound() {
        when(swapiClient.getPersonById("999")).thenReturn(null);

        assertThrows(NotFoundException.class, () -> peopleService.findPersonById("999"));
    }

    @Test
    @DisplayName("Debe devolver personas cuando se encuentra coincidencia por nombre")
    void testFindPersonByNameValid() {
        PeopleSearchResponseDTO mockResponse = new PeopleSearchResponseDTO();
        mockResponse.setResult(Collections.singletonList(new PersonDetailDTO.PersonResultDTO()));
        when(swapiClient.getPersonByName("Luke")).thenReturn(mockResponse);

        PeopleSearchResponseDTO result = peopleService.findPersonByName("Luke");

        assertNotNull(result);
        assertFalse(result.getResult().isEmpty());
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException cuando no hay coincidencias por nombre")
    void testFindPersonByNameNotFound() {
        PeopleSearchResponseDTO emptyResponse = new PeopleSearchResponseDTO();
        emptyResponse.setResult(Collections.emptyList());
        when(swapiClient.getPersonByName("NoExiste")).thenReturn(emptyResponse);

        assertThrows(NotFoundException.class, () -> peopleService.findPersonByName("NoExiste"));
    }
}
