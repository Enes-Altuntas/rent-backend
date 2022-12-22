package com.example.rent.Mapper.Land.Get;

import com.example.rent.DTO.Land.Get.GetLandOwnerDTO;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetLandOwnerDTOFromEntityMapper extends BaseEntityMapper<Owner, GetLandOwnerDTO> {
    @Mapping(source = "id",target = "ownerId")
    @Override
    GetLandOwnerDTO fromEntityToDTO(Owner owner);
}
