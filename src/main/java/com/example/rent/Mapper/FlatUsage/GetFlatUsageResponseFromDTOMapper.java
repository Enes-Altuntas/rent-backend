package com.example.rent.Mapper.FlatUsage;

import com.example.rent.DTO.FlatUsage.GetFlatUsageDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.FlatUsage.GetFlatUsageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetFlatUsageResponseFromDTOMapper extends BaseResponseMapper<GetFlatUsageResponse, GetFlatUsageDTO> {
}
