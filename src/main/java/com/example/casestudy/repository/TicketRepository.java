package com.example.casestudy.repository;

import com.example.casestudy.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

 TicketEntity findByTicketNumber(String ticketNumber);

 Optional<TicketEntity> findByTicketIdAndStatus(Long ticketId,String status);
}
