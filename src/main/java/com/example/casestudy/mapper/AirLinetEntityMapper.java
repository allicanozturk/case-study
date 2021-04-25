package com.example.casestudy.mapper;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.entity.AirlineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirLinetEntityMapper {

  AirLinetEntityMapper INSTANCE = Mappers.getMapper(AirLinetEntityMapper.class);

  AirlineEntity toAirLineEntity(AirlineCreationRequest source);

  Airline toAirLineResponse(AirlineEntity source);

  List<Airline> toAirLineResponse(List<AirlineEntity> source);
}
