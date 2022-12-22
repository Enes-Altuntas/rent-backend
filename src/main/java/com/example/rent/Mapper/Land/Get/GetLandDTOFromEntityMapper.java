package com.example.rent.Mapper.Land.Get;

import com.example.rent.DTO.Land.Get.GetLandDTO;
import com.example.rent.Entity.Land.Land;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {GetLandOwnerDTOFromEntityMapper.class})
public interface GetLandDTOFromEntityMapper extends BaseEntityMapper<Land , GetLandDTO> {

}
