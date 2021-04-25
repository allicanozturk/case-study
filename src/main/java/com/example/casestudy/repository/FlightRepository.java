package com.example.casestudy.repository;

import com.example.casestudy.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

  @Query("select f from FlightEntity f where f.departureDate=:departureDate " +
      "and f.route.from.airportName = :from " +
      "and f.route.to.airportName = :to ")
  List<FlightEntity> findFlightsByDateAndFromAndTo(@Param("departureDate") Date departureDate,
                                                   @Param("from") String from,
                                                   @Param("to") String to);

    FlightEntity findByFlightId(Long flightId);

}
