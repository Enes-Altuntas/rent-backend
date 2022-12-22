package com.example.rent.Mapper.Contract.Create;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.Mapper.Apartment.Get.GetApartmentRenterResponseFromDTOMapper;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Contract.Create.CreateContractResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetApartmentRenterResponseFromDTOMapper.class})
public interface CreateContractDTOToResponseMapper extends BaseResponseMapper<CreateContractResponse, CreateContractDTO> {
}
