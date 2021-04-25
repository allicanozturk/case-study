package com.example.casestudy.repository;

import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

  List<AirlineEntity> findAllByCompanyNameLike(String companyName);

  AirlineEntity findByCompanyShortCodeAndActive(String shortCode, boolean active);

}
