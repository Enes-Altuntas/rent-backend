package com.example.rent.Mapper.Land.Get;

import com.example.rent.DTO.Land.Get.GetLandDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Land.Get.GetLandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {GetLandOwnerDTOToResponseMapper.class})
public interface GetLandDTOToResponseMapper extends BaseResponseMapper<GetLandResponse, GetLandDTO> {
}
