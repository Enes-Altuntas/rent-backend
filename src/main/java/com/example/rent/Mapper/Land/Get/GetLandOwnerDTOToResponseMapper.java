package com.example.rent.Mapper.Land.Get;

import com.example.rent.DTO.Land.Get.GetLandOwnerDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Land.Get.GetLandOwnerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetLandOwnerDTOToResponseMapper extends BaseResponseMapper<GetLandOwnerDTO, GetLandOwnerResponse> {
}
