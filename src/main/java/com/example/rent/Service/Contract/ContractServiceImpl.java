package com.example.rent.Service.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.Contract.Create.CreateContractEntityToDTOMapper;
import com.example.rent.Mapper.Contract.Delete.DeleteContractEntityToDTOMapper;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.FlatContract.FlatContractRepository;
import com.example.rent.Repository.Renter.RenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ContractServiceImpl implements ContractService {

    private final FlatRepository flatRepository;
    private final RenterRepository renterRepository;
    private final FlatContractRepository flatContractRepository;
    private final CreateContractEntityToDTOMapper createContractEntityToDTOMapper;
    private final DeleteContractEntityToDTOMapper deleteContractEntityToDTOMapper;

    @Override
    public CreateContractDTO createContract(CreateContractDTO createContractDTO) {
        Flat flat = flatRepository.findById(createContractDTO.getFlatId())
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

        Renter renter = renterRepository.findById(createContractDTO.getRenterId())
                .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));

        if (!renter.isActive()) {
            throw new RuntimeException();
        }

        FlatContract flatContract = new FlatContract();

        flatContract.setFlat(flat);
        flatContract.setStartDate(createContractDTO.getStartDate());
        flatContract.setEndDate(createContractDTO.getEndDate());
        flatContract.setPaymentDue(createContractDTO.getPaymentDue());
        flatContract.setPayment(new ArrayList<>());
        FlatContract savedContract = flatContractRepository.save(flatContract);

        flat.setFlatContract(savedContract);
        flat.setRenter(renter);
        Flat savedFlat = flatRepository.save(flat);

        setCodeToRenter(renter, savedFlat);
        renterRepository.save(renter);

        return createContractEntityToDTOMapper.fromEntityToDTO(savedFlat);
    }

    @Override
    public DeleteContractDTO deleteContract(DeleteContractDTO deleteContractDTO) {
        Flat flat = flatRepository.findById(deleteContractDTO.getFlatId())
                .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));

        flatContractRepository.delete(flat.getFlatContract());
        flat.setFlatContract(null);

        Renter renter = flat.getRenter();
        renter.setCode(null);
        renterRepository.save(renter);

        flat.setRenter(null);
        Flat savedFlat = flatRepository.save(flat);

        return deleteContractEntityToDTOMapper.fromEntityToDTO(savedFlat);
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
