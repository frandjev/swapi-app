package com.exam.swapi.service.vehicle;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.vehicle.VehicleDTO;
import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;
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
class VehicleServiceImplTest {
    @Mock
    private ISwapiClient swapiClient;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("Debe listar vehículos correctamente")
    void testListVehicles() {
        VehiclePageResponseDTO response = new VehiclePageResponseDTO();
        response.setResults(Collections.singletonList(new VehicleDTO()));

        when(swapiClient.getVehicles()).thenReturn(response);

        VehiclePageResponseDTO result = vehicleService.listVehicles();

        assertNotNull(result);
        assertEquals(1, result.getResults().size());
        verify(swapiClient, times(1)).getVehicles();
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException si el vehículo no existe")
    void testFindVehicleById_NotFound() {
        when(swapiClient.getVehicleById("999")).thenReturn(null);

        NotFoundException ex = assertThrows(NotFoundException.class, () ->
                vehicleService.getVehicleById("999"));
        assertEquals("No se encontró un vehículo con ID 999", ex.getMessage());
    }

    @Test
    @DisplayName("Debe devolver un vehículo correctamente al buscar por ID")
    void testFindVehicleById_Success() {
        VehicleDetailDTO dto = new VehicleDetailDTO();
        dto.setResult(new VehicleDetailDTO.VehicleResultDTO());

        when(swapiClient.getVehicleById("1")).thenReturn(dto);

        VehicleDetailDTO result = vehicleService.getVehicleById("1");

        assertNotNull(result);
        assertNotNull(result.getResult());
    }
}
