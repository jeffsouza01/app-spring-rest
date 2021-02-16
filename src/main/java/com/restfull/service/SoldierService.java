package com.restfull.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfull.controller.request.SoldierEditRequest;
import com.restfull.controller.response.SoldierListResponse;
import com.restfull.controller.response.SoldierResponse;
import com.restfull.dto.Soldier;
import com.restfull.entitys.SoldierEntity;
import com.restfull.repository.SoldierRepository;
import com.restfull.resource.SoldierResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldierService {

    @Autowired
    private SoldierRepository soldierRepository;
    private ObjectMapper objectMapper;
    private SoldierResource soldierResource;


    public CollectionModel<SoldierListResponse> showAllSoldiers() {
        List<SoldierEntity> allSoldiers = soldierRepository.findAll();
        List<SoldierListResponse> soldiersStream = allSoldiers.stream()
                .map(soldier -> soldierResource.createLink(soldier))
                .collect(Collectors.toList());
        return (CollectionModel<SoldierListResponse>) soldiersStream;
    }
    public SoldierResponse searchSoldier(Long id) {
        SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
        SoldierResponse soldierResponse = soldierResource.createLinkDetail(soldier);
        return soldierResponse;
    }

    public SoldierEntity createNewSoldier(Soldier newSoldier) {
        SoldierEntity soldier = objectMapper.convertValue(newSoldier, SoldierEntity.class);
        soldierRepository.save(soldier);
        return soldier;
    }

    public void delete(Long id) {
        SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldier);
    }

    public void update(Long id, SoldierEditRequest soldierEditRequest) {
        SoldierEntity soldier = objectMapper.convertValue(soldierEditRequest, SoldierEntity.class);
        soldier.setId(id);
        soldierRepository.save(soldier);
    }
}
