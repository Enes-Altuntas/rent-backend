package com.example.rent.Service.Flat;


import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatApartmentDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Currency.Currency;
import com.example.rent.Entity.Employee.Employee;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatStatus.FlatStatus;
import com.example.rent.Entity.FlatType.FlatType;
import com.example.rent.Entity.FlatUsage.FlatUsage;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Mapper.Flat.Get.GetFlatApartmentDTOFromEntityMapper;
import com.example.rent.Repository.Apartment.ApartmentRepository;
import com.example.rent.Repository.Currency.CurrencyRepository;
import com.example.rent.Repository.Employee.EmployeeRepository;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.FlatStatus.FlatStatusRepository;
import com.example.rent.Repository.FlatType.FlatTypeRepository;
import com.example.rent.Repository.FlatUsage.FlatUsageRepository;
import com.example.rent.Repository.Owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;
    private final ApartmentRepository apartmentRepository;
    private final GetFlatApartmentDTOFromEntityMapper getFlatApartmentDTOFromEntityMapper;
    private final CurrencyRepository currencyRepository;
    private final FlatTypeRepository flatTypeRepository;
    private final FlatUsageRepository flatUsageRepository;
    private final FlatStatusRepository flatStatusRepository;
    private final EmployeeRepository employeeRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public GetFlatApartmentDTO saveFlat(CreateFlatDTO createFlatDTO) {
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

        List<Owner> owners = ownerRepository.findAllById(createFlatDTO.getOwnerId());
        flat.setFlatOwners(owners);

        FlatUsage flatUsage = flatUsageRepository.findById(createFlatDTO.getFlatUsageId())
                .orElseThrow(() -> new NoSuchElementException("Daire kullanım tipi bulunamadı!"));
        flat.setFlatUsage(flatUsage);

        FlatStatus flatStatus = flatStatusRepository.findById(createFlatDTO.getFlatStatusId())
                .orElseThrow(() -> new NoSuchElementException("Daire durumu bulunamadı!"));
        flat.setFlatStatus(flatStatus);

        Employee employee = employeeRepository.findById(createFlatDTO.getEmployeeId())
                .orElseThrow(() -> new NoSuchElementException("Sorumlu personel bulunamadı!"));
        flat.setEmployee(employee);

        Flat newFlat = flatRepository.saveAndFlush(flat);

        return getFlatApartmentDTOFromEntityMapper.fromEntityToDTO(newFlat.getApartment());
    }

    @Override
    public GetFlatApartmentDTO deleteFlat(Integer id) {
        Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

        flatRepository.delete(flat);

        Apartment apartment = apartmentRepository.findById(flat.getApartment().getId()).orElseThrow();

        return getFlatApartmentDTOFromEntityMapper.fromEntityToDTO(apartment);
    }

    @Override
    public GetFlatApartmentDTO updateFlat(UpdateFlatDTO updateFlatDTO) {
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

        List<Owner> owners = ownerRepository.findAllById(updateFlatDTO.getOwnerId());
        flat.setFlatOwners(owners);

        FlatUsage flatUsage = flatUsageRepository.findById(updateFlatDTO.getFlatUsageId())
                .orElseThrow(() -> new NoSuchElementException("Daire kullanım tipi bulunamadı!"));
        flat.setFlatUsage(flatUsage);

        FlatStatus flatStatus = flatStatusRepository.findById(updateFlatDTO.getFlatStatusId())
                .orElseThrow(() -> new NoSuchElementException("Daire durumu bulunamadı!"));
        flat.setFlatStatus(flatStatus);

        Employee employee = employeeRepository.findById(updateFlatDTO.getEmployeeId())
                .orElseThrow(() -> new NoSuchElementException("Sorumlu personel bulunamadı!"));
        flat.setEmployee(employee);

        Flat updatedFlat = flatRepository.saveAndFlush(flat);

        return getFlatApartmentDTOFromEntityMapper.fromEntityToDTO(updatedFlat.getApartment());
    }
}
