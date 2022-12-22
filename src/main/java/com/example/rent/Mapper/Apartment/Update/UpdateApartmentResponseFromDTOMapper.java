package com.example.rent.Mapper.Apartment.Update;

import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatResponseFromDTOMapper;
import com.example.rent.Response.Apartment.UpdateApartmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetFlatResponseFromDTOMapper.class})
public interface UpdateApartmentResponseFromDTOMapper extends BaseResponseMapper<UpdateApartmentResponse, UpdateApartmentDTO> {
    @Override
    UpdateApartmentResponse fromDTOToResponse(UpdateApartmentDTO updateApartmentDTO);
}
