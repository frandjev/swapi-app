package com.exam.swapi.service.starship;


import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.starship.StarshipDTO;
import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StarshipServiceImplTest {

    @Mock
    private ISwapiClient swapiClient;

    @InjectMocks
    private StarshipServiceImpl service;


    @Test
    @DisplayName("Debe devolver una lista de naves correctamente")
    void testListStarships() {
        StarshipPageResponseDTO response = new StarshipPageResponseDTO();
        response.setResults(Collections.singletonList(new StarshipDTO()));

        when(swapiClient.getStarships()).thenReturn(response);

        StarshipPageResponseDTO result = service.listStarships();

        assertNotNull(result);
        assertEquals(1, result.getResults().size());
        verify(swapiClient, times(1)).getStarships();
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException si la nave no existe por ID")
    void testFindStarshipById_NotFound() {
        when(swapiClient.getStarshipById("999")).thenReturn(null);

        NotFoundException ex = assertThrows(NotFoundException.class, () ->
                service.getStarshipById("999"));
        assertEquals("No se encontró una nave con ID 999", ex.getMessage());
    }

    @Test
    @DisplayName("Debe devolver la nave encontrada por ID")
    void testFindStarshipById_Success() {
        StarshipDetailDTO dto = new StarshipDetailDTO();
        dto.setResult(new StarshipDetailDTO.StarshipResultDTO());

        when(swapiClient.getStarshipById("1")).thenReturn(dto);

        StarshipDetailDTO result = service.getStarshipById("1");

        assertNotNull(result);
        assertNotNull(result.getResult());
    }
}
