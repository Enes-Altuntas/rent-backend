package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Recap.GetRecapResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetRecapFlatResponseFromDTOMapper.class})
public interface GetRecapRentResponseFromDTOMapper extends BaseResponseMapper<GetRecapResponse, GetRecapDTO> {
}
