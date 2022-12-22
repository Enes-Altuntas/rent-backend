package com.example.rent.Mapper.Contract.Create;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Contract.Create.CreateContractRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateContractRequestToDTOMapper extends BaseRequestMapper<CreateContractRequest, CreateContractDTO> {
}
