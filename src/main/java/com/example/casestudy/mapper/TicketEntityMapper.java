package com.example.casestudy.mapper;


import com.example.casestudy.dto.model.Ticket;
import com.example.casestudy.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketEntityMapper {

  TicketEntityMapper INSTANCE = Mappers.getMapper(TicketEntityMapper.class);

  @Mapping(target = "name", source = "passenger.name")
  @Mapping(target = "surname", source = "passenger.surname")
  @Mapping(target = "email", source = "passenger.email")
  @Mapping(target = "flightId", source = "flight.flightId")
  @Mapping(target = "from", source = "flight.route.from.airportName")
  @Mapping(target = "to", source = "flight.route.to.airportName")
  Ticket toTicketResponse(TicketEntity source);

}
