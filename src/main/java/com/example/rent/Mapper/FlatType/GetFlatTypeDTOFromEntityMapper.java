package com.example.rent.Mapper.FlatType;

import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import com.example.rent.Entity.FlatType.FlatType;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetFlatTypeDTOFromEntityMapper extends BaseEntityMapper<FlatType, GetFlatTypeDTO> {
    @Mapping(source = "id", target = "flatTypeId")
    @Mapping(source = "flatTypeValue", target = "flatTypeValue")
    @Override
    GetFlatTypeDTO fromEntityToDTO(FlatType flatType);
}
