package com.example.rent.Mapper.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Owner.CreateOwnerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateOwnerRequestToDTOMapper extends BaseRequestMapper<CreateOwnerRequest, CreateOwnerDTO> {

}
