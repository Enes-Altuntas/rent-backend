package com.example.rent.Mapper.Land.Create;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.Entity.Land.Land;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateLandDTOFromEntityMapper extends BaseEntityMapper<Land, CreateLandDTO> {
}
