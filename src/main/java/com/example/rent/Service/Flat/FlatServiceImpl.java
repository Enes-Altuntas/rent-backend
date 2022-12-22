package com.example.rent.Service.Flat;


import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Currency.Currency;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatType.FlatType;
import com.example.rent.Mapper.Flat.Get.GetFlatDTOFromEntityMapper;
import com.example.rent.Repository.Apartment.ApartmentRepository;
import com.example.rent.Repository.Currency.CurrencyRepository;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.FlatType.FlatTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;
    private final ApartmentRepository apartmentRepository;
    private final GetFlatDTOFromEntityMapper getFlatDTOFromEntityMapper;
    private final CurrencyRepository currencyRepository;
    private final FlatTypeRepository flatTypeRepository;

    @Override
    public GetFlatDTO saveFlat(CreateFlatDTO createFlatDTO) {
        Flat flat = new Flat();

        flat.setFlatNumber(createFlatDTO.getFlatNumber());
        flat.setFlatArea(createFlatDTO.getFlatArea());
        flat.setFlatPrice(createFlatDTO.getFlatPrice());

        Currency currency = currencyRepository.findById(createFlatDTO.getCurrencyId())
                .orElseThrow(() -> new NoSuchElementException("Para birimi bulunamadı!"));
        flat.setCurrency(currency);

        FlatType flatType = flatTypeRepository.findById(createFlatDTO.getFlatTypeId())
                .orElseThrow(() -> new NoSuchElementException("Daire tipi bulunamadı!"));
        flat.setFlatType(flatType);

        Apartment apartment = apartmentRepository.findById(createFlatDTO.getApartmentId())
                .orElseThrow(() -> new NoSuchElementException("Apartman bulunamadı!"));
        flat.setApartment(apartment);

        Flat savedFlat = flatRepository.save(flat);

        return getFlatDTOFromEntityMapper.fromEntityToDTO(savedFlat);
    }

    @Override
    public void deleteFlat(Integer id) {
        Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));
        flatRepository.delete(flat);
    }

    @Override
    public GetFlatDTO updateFlat(UpdateFlatDTO updateFlatDTO) {
        Flat flat = flatRepository.findById(updateFlatDTO.getFlatId())
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

        flat.setFlatNumber(updateFlatDTO.getFlatNumber());
        flat.setFlatArea(updateFlatDTO.getFlatArea());
        flat.setFlatPrice(updateFlatDTO.getFlatPrice());

        Currency currency = currencyRepository.findById(updateFlatDTO.getCurrencyId())
                .orElseThrow(() -> new NoSuchElementException("Para birimi bulunamadı!"));
        flat.setCurrency(currency);

        FlatType flatType = flatTypeRepository.findById(updateFlatDTO.getFlatTypeId())
                .orElseThrow(() -> new NoSuchElementException("Daire tipi bulunamadı!"));
        flat.setFlatType(flatType);

        Flat updatedFlat = flatRepository.save(flat);

        return getFlatDTOFromEntityMapper.fromEntityToDTO(updatedFlat);
    }

    @Override
    public List<GetFlatDTO> getAllFlat() {
        List<Flat> flats = flatRepository.findAll();
        return getFlatDTOFromEntityMapper.fromEntityListToDTOList(flats);
    }

    @Override
    public GetFlatDTO getFlat(Integer id) {
        Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));
        return getFlatDTOFromEntityMapper.fromEntityToDTO(flat);
    }
}
