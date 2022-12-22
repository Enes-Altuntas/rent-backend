package com.example.rent.Mapper.Contract.Delete;

import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeleteContractEntityToDTOMapper extends BaseEntityMapper<Flat, DeleteContractDTO> {
    @Mapping(source = "apartment.id", target = "apartmentId")
    @Mapping(source = "id", target = "flatId")
    @Override
    DeleteContractDTO fromEntityToDTO(Flat flat);
}
