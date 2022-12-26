package com.example.rent.Mapper.FlatUsage;

import com.example.rent.DTO.FlatUsage.FlatUsageDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.FlatUsage.FlatUsageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlatUsageResponseFromDTOMapper extends BaseResponseMapper<FlatUsageResponse, FlatUsageDTO> {
}
