package com.example.casestudy.mapper;

import com.example.casestudy.dto.request.FlightCreationRequest;
import com.example.casestudy.dto.model.Flight;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring",imports = { DateUtil.class, DateTimeFormatter.class})
public interface FlightEntityMapper {

  FlightEntityMapper INSTANCE = Mappers.getMapper(FlightEntityMapper.class);

  @Mapping(target = "availableSeat", source = "totalSeat")
  @Mapping(target = "departureDate", source = "departureDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "arrivalDate", source = "arrivalDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "salePrice", source = "price")
  @Mapping(target = "basePrice", source = "price")
  FlightEntity toFlightEntity (FlightCreationRequest source);

  @Mapping(target = "departureDate", source = "departureDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "arrivalDate", source = "arrivalDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "airlineName", source = "airline.companyName" )
  @Mapping(target = "from", source = "route.from.airportName" )
  @Mapping(target = "to", source = "route.to.airportName" )
  @Mapping(target = "price",source = "salePrice")
  Flight toFlightCreationResponse(FlightEntity source);


  @Mapping(target = "departureDate", source = "departureDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "arrivalDate", source = "arrivalDate",dateFormat =DateUtil.BASIC_FORMAT )
  @Mapping(target = "airlineName", source = "airline.companyName" )
  @Mapping(target = "from", source = "route.from.airportName" )
  @Mapping(target = "to", source = "route.to.airportName" )
  @Mapping(target = "price",source = "salePrice")
  List<Flight> toFlightCreationResponse (List<FlightEntity> source);
}
