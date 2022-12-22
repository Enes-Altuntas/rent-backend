package com.example.rent.Mapper.Apartment.Create;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Apartment.CreateApartmentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateApartmentRequestToDTOMapper extends BaseRequestMapper<CreateApartmentRequest, CreateApartmentDTO> {
}
