package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {GetRecapFlatDTOFromEntityMapper.class})
public interface GetRecapRentDTOFromEntityMapper extends BaseEntityMapper<Renter, GetRecapDTO> {

    @Mapping(source = "nameSurname",target = "renterName")
    @Mapping(source = "code",target = "renterCode")
    @Mapping(source = "id",target = "renterId")
    @Override
    GetRecapDTO fromEntityToDTO(Renter renter);

}
