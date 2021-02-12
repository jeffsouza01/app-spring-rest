package com.restfull.controller;

import com.restfull.dto.Soldier;
import com.restfull.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/soldiers")
public class SoldierController {

    @Autowired
    private SoldierService soldierService;


    @GetMapping
    public ResponseEntity<List<Soldier>> showSoldiers() {
        List<Soldier> soldiers = soldierService.showAllSoldiers();

        return ResponseEntity.ok(soldiers);
    }

    
    @PostMapping("/new")
    public ResponseEntity<Soldier> createSoldier(@RequestBody Soldier soldier)  {

        soldierService.createNewSoldier(soldier);

        return ResponseEntity.status(HttpStatus.CREATED).body(soldier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soldier> updateSoldier(@PathVariable Integer id)  {

        soldierService.update(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoldier(@PathVariable Integer id)  {

        soldierService.delete(id);


    }
    
}
