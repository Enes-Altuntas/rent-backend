package com.example.rent.Mapper.FlatStatus;

import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import com.example.rent.Entity.FlatStatus.FlatStatus;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetFlatStatusDTOFromEntityMapper extends BaseEntityMapper<FlatStatus, GetFlatStatusDTO> {
    @Mapping(source = "id", target = "flatStatusId")
    @Mapping(source = "flatStatusValue", target = "statusValue")
    @Override
    GetFlatStatusDTO fromEntityToDTO(FlatStatus flatStatus);
}
