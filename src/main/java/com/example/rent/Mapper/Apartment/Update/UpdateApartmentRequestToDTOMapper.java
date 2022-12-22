package com.example.rent.Mapper.Apartment.Update;

import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Apartment.UpdateApartmentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateApartmentRequestToDTOMapper extends BaseRequestMapper<UpdateApartmentRequest, UpdateApartmentDTO> {
}
