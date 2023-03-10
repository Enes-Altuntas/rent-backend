package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.Mapper.Apartment.Get.GetApartmentRenterResponseFromDTOMapper;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Mapper.Currency.GetCurrencyDTOToResponseMapper;
import com.example.rent.Mapper.Employee.GetEmployeeResponseFromDTOMapper;
import com.example.rent.Mapper.FlatStatus.GetFlatStatusResponseFromDTOMapper;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOToResponseMapper;
import com.example.rent.Mapper.FlatUsage.GetFlatUsageResponseFromDTOMapper;
import com.example.rent.Response.Flat.Get.GetFlatResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {GetApartmentRenterResponseFromDTOMapper.class,
                GetCurrencyDTOToResponseMapper.class,
                GetFlatTypeDTOToResponseMapper.class,
                GetFlatUsageResponseFromDTOMapper.class,
                GetEmployeeResponseFromDTOMapper.class,
                GetFlatStatusResponseFromDTOMapper.class,
                GetFlatOwnerResponseFromDTOMapper.class,
        })
public interface GetFlatResponseFromDTOMapper extends BaseResponseMapper<GetFlatResponse, GetFlatDTO> {
}
