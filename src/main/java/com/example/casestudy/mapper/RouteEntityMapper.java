package com.example.casestudy.mapper;


import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.dto.model.Route;
import com.example.casestudy.entity.RouteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RouteEntityMapper {

  RouteEntityMapper INSTANCE = Mappers.getMapper(RouteEntityMapper.class);

  @Mapping(target = "fromAirportId", source = "departureAirportId")
  @Mapping(target = "toAirportId", source = "arrivalAirportId")
  RouteEntity toRouteEntity(RouteCreationRequest source);

  @Mapping(target = "from", source = "from.airportName")
  @Mapping(target = "to", source = "to.airportName")
  Route toRouteCreationResponse(RouteEntity source);
}
