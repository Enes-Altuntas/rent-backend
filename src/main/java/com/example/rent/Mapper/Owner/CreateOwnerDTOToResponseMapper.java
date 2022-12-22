package com.example.rent.Mapper.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Owner.Create.CreateOwnerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateOwnerDTOToResponseMapper extends BaseResponseMapper<CreateOwnerResponse, CreateOwnerDTO> {
}
