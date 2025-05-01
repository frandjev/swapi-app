package com.exam.swapi.controller;

import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;
import com.exam.swapi.service.vehicle.IVehicleService;
import com.exam.swapi.utils.ValidationUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Lista Vehiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado exitoso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehiclePageResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<VehiclePageResponseDTO> listVehicles() {
        return ResponseEntity.ok(vehicleService.listVehicles());
    }

    @Operation(summary = "Buscar Vehiculo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDetailDTO.class))),
            @ApiResponse(responseCode = "404", description = "Vehiculo no encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetailDTO> getVehicleById(
            @Parameter(description = "ID de Vehiculo")
            @PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
}
