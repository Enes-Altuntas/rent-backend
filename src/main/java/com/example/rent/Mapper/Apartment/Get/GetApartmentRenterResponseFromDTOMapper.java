package com.example.rent.Mapper.Apartment.Get;

import com.example.rent.DTO.Apartment.Get.GetApartmentRenterDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Apartment.GetApartmentRenterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetApartmentRenterResponseFromDTOMapper extends BaseResponseMapper<GetApartmentRenterResponse, GetApartmentRenterDTO> {

    @Override
    GetApartmentRenterResponse fromDTOToResponse(GetApartmentRenterDTO getApartmentRenterDTO);
}
