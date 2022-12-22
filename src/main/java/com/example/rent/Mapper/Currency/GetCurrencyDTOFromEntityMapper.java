package com.example.rent.Mapper.Currency;

import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.Entity.Currency.Currency;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetCurrencyDTOFromEntityMapper extends BaseEntityMapper<Currency, GetCurrencyDTO> {
    @Mapping(source = "id", target = "currencyId")
    @Mapping(source = "currencyValue", target = "currencyValue")
    @Override
    GetCurrencyDTO fromEntityToDTO(Currency currency);
}
