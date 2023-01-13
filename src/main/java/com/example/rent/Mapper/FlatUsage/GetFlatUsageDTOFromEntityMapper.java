package com.example.rent.Mapper.FlatUsage;

import com.example.rent.DTO.FlatUsage.GetFlatUsageDTO;
import com.example.rent.Entity.FlatUsage.FlatUsage;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetFlatUsageDTOFromEntityMapper extends BaseEntityMapper<FlatUsage, GetFlatUsageDTO> {

    @Override
    @Mapping(source = "id", target = "flatUsageId")
    GetFlatUsageDTO fromEntityToDTO(FlatUsage flatUsage);
}
