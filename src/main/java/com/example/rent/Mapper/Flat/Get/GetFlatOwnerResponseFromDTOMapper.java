package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatOwnerDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Flat.Get.GetFlatOwnerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetFlatOwnerResponseFromDTOMapper extends BaseResponseMapper<GetFlatOwnerResponse, GetFlatOwnerDTO> {
}
