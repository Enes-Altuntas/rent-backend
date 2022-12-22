package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterFileDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Renter.Get.GetRenterFileResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetRenterFileDTOToResponseMapper extends BaseResponseMapper<GetRenterFileResponse, GetRenterFileDTO> {
}
