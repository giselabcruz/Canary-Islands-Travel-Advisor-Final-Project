package org.gisela.dacd.businessunit;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TravelController {

    @Autowired
    private TravelRepository travelRepository;

    @GetMapping("/api/travels")
    @Operation(summary = "Find travels")
    public List<Travel> getTravels() {
        return travelRepository.getTravels();
    }

//    @GetMapping("/api/travels/{id}")
//    @Operation(summary = "Find travels by id")
//    public Travel getTravelsById(@PathVariable long id) {
//        Optional<Travel> travel = travelRepository.findById(id);
//        if (travel.isEmpty())
//            throw new TravelNotFoundException("id-" + id);
//
//        return travel.get();
//    }
}
