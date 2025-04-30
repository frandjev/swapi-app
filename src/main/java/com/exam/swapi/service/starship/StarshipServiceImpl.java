package com.exam.swapi.service.starship;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;
import com.exam.swapi.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class StarshipServiceImpl implements IStarshipService{

    private final ISwapiClient swapiClient;

    public StarshipServiceImpl(ISwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public StarshipPageResponseDTO listStarships() {
        StarshipPageResponseDTO response = swapiClient.getStarships();
        if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
            throw new NotFoundException("No se encontraron naves estelares disponibles.");
        }
        return response;
    }

    @Override
    public StarshipDetailDTO getStarshipById(String id) {
        ValidationUtils.requireNotEmpty(id, "id");

        StarshipDetailDTO response = swapiClient.getStarshipById(id);
        if (response == null || response.getResult() == null) {
            throw new NotFoundException("No se encontró una nave con ID " + id);
        }
        return response;
    }
}
