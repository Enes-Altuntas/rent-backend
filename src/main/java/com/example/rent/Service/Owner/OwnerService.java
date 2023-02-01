package com.example.rent.Service.Owner;

import com.example.rent.DTO.Flat.Get.GetFlatOwnerDTO;
import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;

import java.util.List;

public interface OwnerService {
    CreateOwnerDTO saveOwner(CreateOwnerDTO createOwnerDTO);

    List<GetFlatOwnerDTO> getOwnerAsDropdown();
}
