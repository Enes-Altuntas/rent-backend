package com.example.rent.Service.Apartment;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Mapper.Apartment.Get.GetApartmentDTOFromEntityMapper;
import com.example.rent.Repository.Apartment.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final GetApartmentDTOFromEntityMapper getApartmentDTOFromEntityMapper;

    @Override
    public List<GetApartmentDTO> saveApartment(CreateApartmentDTO createApartmentDTO) {
        Apartment apartment = new Apartment();

        apartment.setApartmentName(createApartmentDTO.getApartmentName());
        apartment.setCity(createApartmentDTO.getCity());
        apartment.setNumber(createApartmentDTO.getNumber());
        apartment.setNeighborhood(createApartmentDTO.getNeighborhood());
        apartment.setStreetName(createApartmentDTO.getStreetName());
        apartment.setState(createApartmentDTO.getState());
        apartment.setFlatList(new ArrayList<>());
        apartmentRepository.save(apartment);

        return getAllApartments();
    }

    @Override
    public List<GetApartmentDTO> deleteApartment(Integer id) {
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Apartman bulunamadı!"));

        apartmentRepository.delete(apartment);

        return getAllApartments();
    }


    @Override
    public List<GetApartmentDTO> getAllApartments() {
        List<Apartment> apartment = apartmentRepository.findAll();

        return getApartmentDTOFromEntityMapper.fromEntityListToDTOList(apartment);
    }

    @Override
    public List<GetApartmentDTO> updateApartment(UpdateApartmentDTO updateApartmentDTO) {
        Apartment apartment = apartmentRepository.findById(updateApartmentDTO.getApartmentId())
                .orElseThrow(() -> new NoSuchElementException("Apartman bulunamadı!"));

        apartment.setApartmentName(updateApartmentDTO.getApartmentName());
        apartment.setCity(updateApartmentDTO.getCity());
        apartment.setNumber(updateApartmentDTO.getNumber());
        apartment.setNeighborhood(updateApartmentDTO.getNeighborhood());
        apartment.setState(updateApartmentDTO.getState());
        apartment.setStreetName(updateApartmentDTO.getStreetName());
        apartmentRepository.save(apartment);

        return getAllApartments();
    }


}
