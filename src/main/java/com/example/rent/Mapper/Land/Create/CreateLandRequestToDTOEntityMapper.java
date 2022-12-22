package com.example.rent.Mapper.Land.Create;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Land.CreateLandRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateLandRequestToDTOEntityMapper extends BaseRequestMapper<CreateLandRequest, CreateLandDTO> {
}
