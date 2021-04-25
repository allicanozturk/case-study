package com.example.casestudy.mapper;
import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.model.Airport;
import com.example.casestudy.entity.AirportEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportEntityMapper {

  AirportEntityMapper INSTANCE = Mappers.getMapper(AirportEntityMapper.class);

  AirportEntity toAirportEntity(AirportCreationRequest source);

  Airport toAirportResponse(AirportEntity source);

  List<Airport> toAirportResponse(List<AirportEntity> source);

}
