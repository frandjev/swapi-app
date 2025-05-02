package com.exam.swapi.service.film;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
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
class FilmServiceImplTest {

    @Mock
    private ISwapiClient swapiClient;

    @InjectMocks
    private FilmServiceImpl filmService;

    @Test
    @DisplayName("Debe devolver una lista de películas paginada correctamente")
    void testListFilms() {
        FilmPageResponseDTO expectedResponse = new FilmPageResponseDTO();
        expectedResponse.setResult(Collections.singletonList(new FilmDetailDTO.FilmResultDTO()));

        when(swapiClient.getFilms()).thenReturn(expectedResponse);

        FilmPageResponseDTO actualResponse = filmService.listFilms();

        assertNotNull(actualResponse);
        assertEquals(1, actualResponse.getResult().size());
        verify(swapiClient, times(1)).getFilms();
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException cuando no se encuentra una película por ID")
    void testFindFilmById_NotFound() {
        when(swapiClient.getFilmById("999")).thenReturn(null);

        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                filmService.getFilmById("999"));

        assertEquals("No se encontró una película con ID 999", exception.getMessage());
    }

    @Test
    @DisplayName("Debe devolver una película correctamente al buscar por ID")
    void testFindFilmById_Success() {
        FilmDetailDTO response = new FilmDetailDTO();
        FilmDetailDTO.FilmResultDTO result = new FilmDetailDTO.FilmResultDTO();
        response.setResult(result);

        when(swapiClient.getFilmById("1")).thenReturn(response);

        FilmDetailDTO resultDTO = filmService.getFilmById("1");

        assertNotNull(resultDTO);
        assertNotNull(resultDTO.getResult());
        verify(swapiClient, times(1)).getFilmById("1");
    }
}
