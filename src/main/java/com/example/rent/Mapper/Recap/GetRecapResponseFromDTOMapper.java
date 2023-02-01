package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Mapper.Employee.GetEmployeeResponseFromDTOMapper;
import com.example.rent.Response.Recap.GetRecapResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetEmployeeResponseFromDTOMapper.class})
public interface GetRecapResponseFromDTOMapper extends BaseResponseMapper<GetRecapResponse, GetRecapDTO> {
}
