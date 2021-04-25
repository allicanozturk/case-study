package com.example.casestudy.repository;

import com.example.casestudy.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

  RouteEntity findByFromAirportIdAndToAirportIdAndActive(Long from, Long to,boolean active);

}
