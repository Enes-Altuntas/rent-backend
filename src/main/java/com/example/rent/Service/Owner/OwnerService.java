package com.example.rent.Service.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.DTO.Owner.Get.GetOwnerDTO;

public interface OwnerService {
    CreateOwnerDTO saveOwner(CreateOwnerDTO createOwnerDTO);
}
