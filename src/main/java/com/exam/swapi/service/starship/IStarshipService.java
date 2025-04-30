package com.exam.swapi.service.starship;

import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;

public interface IStarshipService {
    StarshipPageResponseDTO listStarships();

    StarshipDetailDTO getStarshipById(String id);
}
