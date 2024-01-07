package org.gisela.dacd.businessunit.service;

import org.gisela.dacd.businessunit.entity.TravelEntity;
import org.gisela.dacd.businessunit.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    @Autowired
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public TravelEntity saveTravel(TravelEntity travelEntity) {
        return travelRepository.save(travelEntity);
    }

    public List<TravelEntity> getTravels() {
        return travelRepository.findAll();
    }

    public Optional<TravelEntity> getTravelById(Long id) {
        return travelRepository.findById(id);
    }
}
