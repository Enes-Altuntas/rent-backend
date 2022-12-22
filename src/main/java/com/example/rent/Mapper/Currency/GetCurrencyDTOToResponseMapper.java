package com.example.rent.Mapper.Currency;

import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Currency.GetCurrencyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetCurrencyDTOToResponseMapper extends BaseResponseMapper<GetCurrencyResponse, GetCurrencyDTO> {
}
