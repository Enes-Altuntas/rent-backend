package com.example.rent.Mapper.Flat.Update;

import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Flat.Update.UpdateFlatResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateFlatDTOToResponse extends BaseResponseMapper<UpdateFlatResponse, UpdateFlatDTO> {
}
