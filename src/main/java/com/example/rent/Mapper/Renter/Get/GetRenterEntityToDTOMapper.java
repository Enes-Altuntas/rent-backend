package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GetRenterFlatEntityToDTOMapper.class, GetRenterPaymentEntityToDTOMapper.class})
public interface GetRenterEntityToDTOMapper extends BaseEntityMapper<Renter, GetRenterDTO> {
    @Mapping(source = "id", target = "renterId")
    @Override
    GetRenterDTO fromEntityToDTO(Renter renter);
}
