package com.restfull.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfull.controller.request.SoldierEditRequest;
import com.restfull.controller.response.SoldierListResponse;
import com.restfull.controller.response.SoldierResponse;
import com.restfull.dto.Soldier;
import com.restfull.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/soldiers")
public class SoldierController {

    @Autowired
    private SoldierService soldierService;
    private ObjectMapper objectMapper;


    @GetMapping("/{id}")
    public ResponseEntity<SoldierResponse> searchSoldier(@PathVariable()Long id ) {
        SoldierResponse soldadoResponse = soldierService.searchSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<SoldierListResponse>> showSoldiers() {
        CollectionModel<SoldierListResponse> soldierListResponses = soldierService.showAllSoldiers();

        return ResponseEntity.status(HttpStatus.OK).body(soldierListResponses);
    }

    
    @PostMapping("/new")
    public ResponseEntity createSoldier(@RequestBody Soldier soldier)  {
        System.out.println("Entered on post");
        soldierService.createNewSoldier(soldier);

        return ResponseEntity.status(HttpStatus.CREATED).body(soldier);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSoldier(@PathVariable Long id,
                                        @RequestBody SoldierEditRequest soldierEditRequest)  {
        soldierService.update(id, soldierEditRequest);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteSoldier(@PathVariable Long id)  {
        soldierService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/front-castle/{id}")
    public ResponseEntity frontCastle(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }
    
}
