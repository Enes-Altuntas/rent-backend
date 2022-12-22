package com.example.rent.Mapper.FlatType;

import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.FlatType.GetFlatTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetFlatTypeDTOToResponseMapper extends BaseResponseMapper<GetFlatTypeResponse, GetFlatTypeDTO> {

    @Override
    GetFlatTypeResponse fromDTOToResponse(GetFlatTypeDTO getFlatTypeDTO);
}
