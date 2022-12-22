package com.example.rent.Mapper.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateOwnerDTOFromEntityMapper extends BaseEntityMapper<Owner, CreateOwnerDTO> {
    @Mapping(source = "id",target = "ownerId")
    @Override
    CreateOwnerDTO fromEntityToDTO(Owner owner);
}
