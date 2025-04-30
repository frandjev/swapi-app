package com.exam.swapi.service.vehicle;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;
import com.exam.swapi.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final ISwapiClient swapiClient;

    public VehicleServiceImpl(ISwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public VehiclePageResponseDTO listVehicles() {
        VehiclePageResponseDTO response = swapiClient.getVehicles();
        if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos disponibles.");
        }
        return response;
    }

    @Override
    public VehicleDetailDTO getVehicleById(String id) {
        ValidationUtils.requireNotEmpty(id, "id");

        VehicleDetailDTO response = swapiClient.getVehicleById(id);
        if (response == null || response.getResult() == null) {
            throw new NotFoundException("No se encontró un vehículo con ID " + id);
        }
        return response;
    }
}
