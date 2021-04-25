package com.example.casestudy.service.impl;


import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.dto.request.TicketUpdateRequest;
import com.example.casestudy.dto.model.Ticket;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.entity.PassengerEntity;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.exception.ResourceNotFoundException;
import com.example.casestudy.mapper.PassengerEntityMapper;
import com.example.casestudy.mapper.TicketEntityMapper;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.repository.PassengerRepository;
import com.example.casestudy.repository.TicketRepository;
import com.example.casestudy.service.ITicketService;
import com.example.casestudy.util.ErrorMessages;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TicketServiceImpl implements ITicketService {


  @Autowired
  private FlightRepository flightRepository;
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private PassengerRepository passengerRepository;

  @Override
  @Transactional
  public Ticket create(TicketCreationRequest request) {
    PassengerEntity passengerEntity = PassengerEntityMapper.INSTANCE.toPassengerEntity(request);
    PassengerEntity savedPassenger = passengerRepository.save(passengerEntity);
    Optional<FlightEntity> flightEntity = flightRepository.findById(request.getFlightId());
    TicketEntity ticketEntity = new TicketEntity();
    ticketEntity.setFlight(flightEntity.get());
    ticketEntity.setPassenger(savedPassenger);
    ticketEntity.setTicketNumber(this.createTicketNumber());
    ticketEntity.setPrice(flightEntity.get().getSalePrice());
    ticketEntity.setStatus(GeneralEnumerationDefinition.TicketStatus.PENDING.name());
    TicketEntity savedTicket = ticketRepository.save(ticketEntity);

    return TicketEntityMapper.INSTANCE.toTicketResponse(savedTicket);
  }

  @Override
  @Transactional(readOnly = true)
  public Ticket fetch(String ticketNumber) {
    TicketEntity ticketEntity = ticketRepository.findByTicketNumber(ticketNumber);
    return ticketEntity != null ? TicketEntityMapper.INSTANCE.toTicketResponse(ticketEntity) : null;
  }

  @Override
  @Transactional
  public Ticket cancel(TicketUpdateRequest request) {
    Optional<TicketEntity> ticketEntity = ticketRepository.findByTicketIdAndStatus(request.getTicketId(),
        GeneralEnumerationDefinition.TicketStatus.APPROVED.name());

    return ticketEntity.filter(Objects::nonNull)
        .map(
            ticket -> {
              ticket.setStatus(GeneralEnumerationDefinition.TicketStatus.CANCEL.name());
              TicketEntity savedEntity = ticketRepository.save(ticket);
              return TicketEntityMapper.INSTANCE.toTicketResponse(savedEntity);
            }
        ).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.TICKET_NOT_FOUND));
  }

  private String createTicketNumber() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }

}
