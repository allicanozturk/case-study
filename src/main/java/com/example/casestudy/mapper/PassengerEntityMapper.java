package com.example.casestudy.mapper;

import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.entity.PassengerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PassengerEntityMapper {

  PassengerEntityMapper INSTANCE = Mappers.getMapper(PassengerEntityMapper.class);

  PassengerEntity toPassengerEntity (TicketCreationRequest source);


}
