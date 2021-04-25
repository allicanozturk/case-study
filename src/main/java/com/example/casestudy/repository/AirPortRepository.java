package com.example.casestudy.repository;

import com.example.casestudy.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPortRepository extends JpaRepository<AirportEntity, Long> {

  List<AirportEntity> findAllByAirportIdIn(List<Long> airportIds);

  List<AirportEntity> findAllByAirportNameLike(String airportName);

  AirportEntity findByAirportShortCodeAndActive(String shortCode,boolean active);

}
