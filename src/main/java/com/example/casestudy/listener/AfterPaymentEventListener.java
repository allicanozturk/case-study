package com.example.casestudy.listener;


import com.example.casestudy.dto.event.AfterPaymentEvent;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.repository.TicketRepository;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Component
public class AfterPaymentEventListener implements ApplicationListener<AfterPaymentEvent> {

  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private FlightRepository flightRepository;

  @Override
  @Transactional
  public void onApplicationEvent(AfterPaymentEvent paymentCompleteEvent) {
    Optional<TicketEntity> ticketEntity = ticketRepository.findById(paymentCompleteEvent.getTicketId());
    ticketEntity.get().setStatus(GeneralEnumerationDefinition.TicketStatus.APPROVED.name());

    Optional<FlightEntity> flight = flightRepository.findById(ticketEntity.get().getFlight().getFlightId());
    flight.get().setAvailableSeat(flight.get().getAvailableSeat() - 1);
    flight.get().setSalePrice(this.calculateFlightPrice(flight.get()));
    FlightEntity savedFlight = flightRepository.save(flight.get());

    ticketEntity.get().setFlight(savedFlight);
    ticketRepository.save(ticketEntity.get());
  }

  private BigDecimal calculateFlightPrice(FlightEntity flightEntity) {
    BigDecimal basePrice =flightEntity.getBasePrice();
    BigDecimal salePrice = flightEntity.getSalePrice();

    float temp = flightEntity.getTotalSeat() / 10;
    int roundedDivision = Math.round(temp);

    if(flightEntity.getAvailableSeat() % roundedDivision ==0){
      BigDecimal addition = basePrice.divide(new BigDecimal(10));
      BigDecimal result = salePrice.add(addition);
      return result;
    }else {
      return flightEntity.getSalePrice();
    }
  }

}
