package com.example.rent.Mapper.Renter.Update;

import com.example.rent.DTO.Renter.Update.UpdateRenterDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Renter.UpdateRenterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateRenterRequestToDTOMapper extends BaseRequestMapper<UpdateRenterRequest, UpdateRenterDTO> {
}
