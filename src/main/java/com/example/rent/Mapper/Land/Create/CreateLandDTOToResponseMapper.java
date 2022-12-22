package com.example.rent.Mapper.Land.Create;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Land.Create.CreateLandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateLandDTOToResponseMapper extends BaseResponseMapper<CreateLandResponse, CreateLandDTO> {
}
