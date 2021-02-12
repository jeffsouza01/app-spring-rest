package com.restfull.service;

import com.restfull.dto.Soldier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldierService {

    List<Soldier> soldierList = new ArrayList<>();

    Soldier soldier = new Soldier(1,"Legolas", "Elf", "Archery" );

    Soldier soldier2 = new Soldier(2, "Saruman", "Mage", "Staff");

//    List soldiers = Arrays.asList(soldier, soldier2);


    public List<Soldier> getSoldierList() {
        this.soldierList = List.of(soldier, soldier2);
        return soldierList;
    }

    public void setSoldierList(List<Soldier> soldierList) {
        this.soldierList.add((Soldier) soldierList);
    }

    public List<Soldier> showAllSoldiers() {

        return this.soldierList;
    }
    public Soldier createNewSoldier(Soldier newSoldier) {
        this.soldierList.add(newSoldier);

        return newSoldier;
    }

    public void delete(Integer id) {
        List<Soldier> soldierFiltered = this.soldierList.stream().filter(soldierID -> soldierID.equals(id)).collect(Collectors.toList());

//        int indexSoldier = soldierList.indexOf(soldierFiltered);

        soldierList.remove(soldierFiltered);
    }

    public Soldier update(Integer id) {
        List<Soldier> soldierFiltered = this.soldierList.stream().filter(soldierID -> soldierID.equals(id)).collect(Collectors.toList());

        soldierList.add((Soldier) soldierFiltered);

        return soldier;
    }
}
