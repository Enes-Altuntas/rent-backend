package com.example.rent.Mapper.FlatUsage;

import com.example.rent.DTO.FlatUsage.FlatUsageDTO;
import com.example.rent.Entity.FlatUsage.FlatUsage;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlatUsageDTOFromEntityMapper extends BaseEntityMapper<FlatUsage, FlatUsageDTO> {

    @Override
    @Mapping(source = "id",target = "flatUsageId")
    FlatUsageDTO fromEntityToDTO(FlatUsage flatUsage);
}
