package com.example.rent.Service.Apartment;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;

import java.util.List;

public interface ApartmentService {
    List<GetApartmentDTO> saveApartment(CreateApartmentDTO createApartmentDTO);

    List<GetApartmentDTO> deleteApartment(Integer id);

    List<GetApartmentDTO> getAllApartments();

    List<GetApartmentDTO> updateApartment(UpdateApartmentDTO updateApartmentDTO);

}
