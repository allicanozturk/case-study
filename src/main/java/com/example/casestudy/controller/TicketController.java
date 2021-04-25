package com.example.casestudy.controller;

import com.example.casestudy.dto.model.Ticket;
import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.dto.request.TicketUpdateRequest;
import com.example.casestudy.dto.response.GenericResponse;
import com.example.casestudy.service.ITicketService;
import com.example.casestudy.util.RequestPath;
import com.example.casestudy.validation.RequestValidation;
import com.example.casestudy.validation.validator.ValidatorPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RequestPath.TICKET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

  private final ITicketService ticketService;

  @Autowired
  public TicketController(ITicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping()
  @RequestValidation(validatorPath = ValidatorPath.TICKET_VALIDATOR)
  public ResponseEntity<GenericResponse<Ticket>> createTicket(@Validated @RequestBody TicketCreationRequest request) {
    GenericResponse response = GenericResponse.createSuccessfulResponse(ticketService.create(request));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/{ticketNumber}")
  public ResponseEntity<?> fetchTicket(@PathVariable String ticketNumber) {
    Ticket ticket = ticketService.fetch(ticketNumber);
    return ticket == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(ticket, HttpStatus.OK);
  }

  @PatchMapping("/cancel")
  public ResponseEntity<?> updateTicket(@Validated @RequestBody TicketUpdateRequest request) {
    GenericResponse response = GenericResponse.createSuccessfulResponse(ticketService.cancel(request));
    return ResponseEntity.ok(response);
  }

}
