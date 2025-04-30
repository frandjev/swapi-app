package com.exam.swapi.service.vehicle;

import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;

public interface IVehicleService {
    VehiclePageResponseDTO listVehicles();

    VehicleDetailDTO getVehicleById(String id);
}
