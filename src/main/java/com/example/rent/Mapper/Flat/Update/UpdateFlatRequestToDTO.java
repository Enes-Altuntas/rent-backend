package com.example.rent.Mapper.Flat.Update;

import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Flat.Update.UpdateFlatRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateFlatRequestToDTO extends BaseRequestMapper<UpdateFlatRequest, UpdateFlatDTO> {
}
