package com.example.rent.Mapper.Flat.Create;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Flat.Create.CreateFlatRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateFlatRequestToDTOEntityMapper extends BaseRequestMapper<CreateFlatRequest, CreateFlatDTO> {
}
