package com.example.bccom.services;


import com.example.bccom.models.Building;
import com.example.bccom.models.Flat;
import com.example.bccom.repo.FlatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class FlatService {
    private final FlatRepository flatRepository;

    public List<Flat> listFlats(Building building) {
        if (building != null) flatRepository.findByBuilding(building);
        return flatRepository.findAll();
    }

    public void saveFlat (Flat flat){
        log.info("Saving new {}", flat);
        flatRepository.save(flat);
    }

    public void deleteFlat (Long id){
        flatRepository.deleteById(id);
    }

    public Flat getFlatById (Long id){
        return flatRepository.findById(id).orElse(null);
    }

}
