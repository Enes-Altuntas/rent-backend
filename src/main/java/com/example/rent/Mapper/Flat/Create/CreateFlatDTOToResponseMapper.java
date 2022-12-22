package com.example.rent.Mapper.Flat.Create;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Flat.Create.CreateFlatResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CreateFlatDTOToResponseMapper extends BaseResponseMapper<CreateFlatResponse, CreateFlatDTO> {
}
