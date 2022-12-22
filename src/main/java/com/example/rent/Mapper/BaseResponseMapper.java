package com.example.rent.Mapper;

import java.util.List;

public interface BaseResponseMapper<Response, DTO> {

    Response fromDTOToResponse(DTO dto);

    List<Response> fromDTOListToResponseList(List<DTO> dtoList);

}
