package com.example.rent.Mapper;

import java.util.List;

public interface BaseRequestMapper<Request, DTO> {

    DTO fromRequestToDTO(Request request);

    List<DTO> fromRequestListToDTOList(List<Request> requestList);

}
