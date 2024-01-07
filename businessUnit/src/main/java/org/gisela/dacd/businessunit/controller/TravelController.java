package org.gisela.dacd.businessunit.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.gisela.dacd.businessunit.entity.TravelEntity;
import org.gisela.dacd.businessunit.exception.TravelNotFoundException;
import org.gisela.dacd.businessunit.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/api/travels")
    @Operation(summary = "Find all travels")
    public List<TravelEntity> getTravels() {
        return travelService.getTravels();
    }


    @GetMapping("/api/travels/{id}")
    @Operation(summary = "Find travel by id")
    public TravelEntity getTravelById(@PathVariable long id) {
        return travelService.getTravelById(id).orElseThrow(() -> new TravelNotFoundException("id-" + id));
    }
}
