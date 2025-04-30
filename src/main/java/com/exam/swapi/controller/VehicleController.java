package com.exam.swapi.controller;

import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;
import com.exam.swapi.service.vehicle.IVehicleService;
import com.exam.swapi.utils.ValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<VehiclePageResponseDTO> listVehicles() {
        return ResponseEntity.ok(vehicleService.listVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetailDTO> getVehicleById(@PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
}
