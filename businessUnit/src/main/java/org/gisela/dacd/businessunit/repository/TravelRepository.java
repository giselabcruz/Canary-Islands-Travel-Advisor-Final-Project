package org.gisela.dacd.businessunit.repository;

import org.gisela.dacd.businessunit.entity.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TravelRepository extends JpaRepository<TravelEntity, Long> {
}
