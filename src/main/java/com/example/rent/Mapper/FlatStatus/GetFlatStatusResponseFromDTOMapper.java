package com.example.rent.Mapper.FlatStatus;

import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.FlatStatus.GetFlatStatusResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetFlatStatusResponseFromDTOMapper extends BaseResponseMapper<GetFlatStatusResponse, GetFlatStatusDTO> {
}
