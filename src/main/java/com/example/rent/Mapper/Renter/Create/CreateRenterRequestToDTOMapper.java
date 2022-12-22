package com.example.rent.Mapper.Renter.Create;

import com.example.rent.DTO.Renter.Create.CreateRenterDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Renter.CreateRenterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateRenterRequestToDTOMapper extends BaseRequestMapper<CreateRenterRequest, CreateRenterDTO> {
}
