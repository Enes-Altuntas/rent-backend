package com.example.rent.Service.Flat;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatApartmentDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;

public interface FlatService {
    GetFlatApartmentDTO saveFlat(CreateFlatDTO createFlatDTO);

    GetFlatApartmentDTO deleteFlat(Integer id);

    GetFlatApartmentDTO updateFlat(UpdateFlatDTO updateFlatDTO);

}
