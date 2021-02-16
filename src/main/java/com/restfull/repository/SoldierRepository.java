package com.restfull.repository;

import com.restfull.entitys.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {

}
