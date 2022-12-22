package com.example.rent.Mapper.Contract.Delete;

import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Contract.Delete.DeleteContractResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeleteContractDTOToResponseMapper extends BaseResponseMapper<DeleteContractResponse, DeleteContractDTO> {
}
