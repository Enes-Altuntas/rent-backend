package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatOwnerDTO;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetFlatOwnerDTOFromEntityMapper extends BaseEntityMapper<Owner, GetFlatOwnerDTO> {
    @Mapping(source = "id", target = "ownerId")
    @Override
    GetFlatOwnerDTO fromEntityToDTO(Owner owner);
}
