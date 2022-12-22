package com.example.rent.Mapper.Contract.Delete;

import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Contract.Delete.DeleteContractRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeleteContractRequestToDTOMapper extends BaseRequestMapper<DeleteContractRequest, DeleteContractDTO> {
}
