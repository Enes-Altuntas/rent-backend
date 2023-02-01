package com.example.rent.Service.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.Renter.Get.GetRenterEntityToDTOMapper;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.FlatContract.FlatContractRepository;
import com.example.rent.Repository.Renter.RenterRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ContractServiceImpl implements ContractService {

  private final FlatRepository flatRepository;
  private final RenterRepository renterRepository;
  private final FlatContractRepository flatContractRepository;
  private final GetRenterEntityToDTOMapper getRenterEntityToDTOMapper;

  @Override
  public GetRenterDTO createContract(CreateContractDTO createContractDTO) {
    Flat flat = flatRepository.findById(createContractDTO.getFlatId())
        .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

    Renter renter = renterRepository.findById(createContractDTO.getRenterId())
        .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));

    renter.setActive(true);
    renterRepository.saveAndFlush(renter);

    if (!renter.isActive()) {
      throw new RuntimeException("Kiracı aktif değildir!");
    }

    if (Objects.nonNull(flat.getFlatContract())) {
      throw new RuntimeException("Seçtiğiniz daire hali hazırda dolu bir dairedir!");
    }

    FlatContract flatContract = new FlatContract();

    LocalDate endLocalDate = createContractDTO.getStartDate().toInstant()
        .atZone(ZoneId.systemDefault()).toLocalDate().plusYears(1);
    Date endDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    flatContract.setFlat(flat);
    flatContract.setStartDate(createContractDTO.getStartDate());
    flatContract.setEndDate(endDate);
    flatContract.setPaymentDue(createContractDTO.getPaymentDue());
    flatContract.setPayment(new ArrayList<>());
    FlatContract savedContract = flatContractRepository.save(flatContract);

    flat.setFlatContract(savedContract);
    flat.setRenter(renter);
    Flat savedFlat = flatRepository.save(flat);

    setCodeToRenter(renter, savedFlat);
    renterRepository.saveAndFlush(renter);

    return getRenterEntityToDTOMapper.fromEntityToDTO(renter);
  }

  @Override
  public GetRenterDTO deleteContract(DeleteContractDTO deleteContractDTO) {
    Flat flat = flatRepository.findById(deleteContractDTO.getFlatId())
        .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

    Renter renter = flat.getRenter();

    flatContractRepository.delete(flat.getFlatContract());
    flat.setFlatContract(null);
    flat.setRenter(null);
    flatRepository.save(flat);

    renter.setCode(null);
    renterRepository.saveAndFlush(renter);

    return getRenterEntityToDTOMapper.fromEntityToDTO(renter);
  }

  public void setCodeToRenter(Renter renter, Flat flat) {
    String code = flat.getApartment().getState().toUpperCase().substring(0, 2) +
        flat.getApartment().getNeighborhood().toUpperCase().substring(0, 2) +
        flat.getApartment().getStreetName().toUpperCase().substring(0, 2) +
        flat.getApartment().getApartmentName().toUpperCase().substring(0, 2) +
        renter.getTckn().toUpperCase().substring(8, 11);
    renter.setCode(code);
  }
}
