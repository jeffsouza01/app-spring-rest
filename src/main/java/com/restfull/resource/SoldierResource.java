package com.restfull.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfull.controller.SoldierController;
import com.restfull.controller.response.SoldierListResponse;
import com.restfull.controller.response.SoldierResponse;
import com.restfull.entitys.SoldierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class SoldierResource {
    @Autowired
    private ObjectMapper objectMapper;

    public SoldierListResponse createLink(SoldierEntity soldierEntity) {
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).searchSoldier(soldierEntity.getId())).withSelfRel();
        soldierListResponse.add(link);
        return soldierListResponse;
    }

    public SoldierResponse createLinkDetail(SoldierEntity soldierEntity) {
        SoldierResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        if (soldierEntity.getStatus().equals("dead")) {
            Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
                    .withRel("remove")
                    .withTitle("Soldier Delete")
                    .withType("delete");
            soldierListResponse.add(link);
        } else if (soldierEntity.getStatus().equals("alive")) {
            Link link = linkTo(methodOn(SoldierController.class).frontCastle(soldierEntity.getId()))
                    .withRel("fight")
                    .withTitle("Go to front of castle")
                    .withType("put");
            soldierListResponse.add(link);
        }

        return soldierListResponse;
    }
}
