package com.example.rent.Service.Renter;

import com.example.rent.DTO.Renter.Create.CreateRenterDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.DTO.Renter.Update.UpdateRenterDTO;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Exception.CustomInvalidFieldException;
import com.example.rent.Mapper.Renter.Get.GetRenterEntityToDTOMapper;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.Renter.RenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class RenterServiceImpl implements RenterService {

    private final RenterRepository renterRepository;
    private final FlatRepository flatRepository;
    private final GetRenterEntityToDTOMapper getRenterEntityToDTOMapper;

    @Override
    public GetRenterDTO saveRenter(CreateRenterDTO createRenterDTO) {
        if (!validateTCKN(createRenterDTO.getTckn())) {
            throw new CustomInvalidFieldException("Hatalı T.C. kimlik no!");
        }

        Renter renter = new Renter();
        renter.setCode(null);
        renter.setEmail(createRenterDTO.getEmail());
        renter.setTckn(createRenterDTO.getTckn());
        renter.setNameSurname(createRenterDTO.getNameSurname());
        renter.setPhoneNumber(createRenterDTO.getPhoneNumber());
        renter.setFlatList(new ArrayList<>());
        renter.setPayments(new ArrayList<>());

        Renter savedRenter = renterRepository.save(renter);
        return getRenterEntityToDTOMapper.fromEntityToDTO(savedRenter);
    }

    @Override
    public GetRenterDTO updateRenter(UpdateRenterDTO updateRenterDTO) {
        Renter renter = renterRepository.findById(updateRenterDTO.getRenterId())
                .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));

        renter.setTckn(updateRenterDTO.getTckn());
        renter.setEmail(updateRenterDTO.getEmail());
        renter.setPhoneNumber(updateRenterDTO.getPhoneNumber());
        renter.setNameSurname(updateRenterDTO.getNameSurname());

        Renter updatedRenter = renterRepository.save(renter);
        return getRenterEntityToDTOMapper.fromEntityToDTO(updatedRenter);
    }

    @Override
    public GetRenterDTO getRenter(Integer id) {
        Renter renter = renterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));
        return getRenterEntityToDTOMapper.fromEntityToDTO(renter);
    }

    @Override
    public List<GetRenterDTO> getAllRenters() {
        List<Renter> renters = renterRepository.findAll();
        return getRenterEntityToDTOMapper.fromEntityListToDTOList(renters);
    }

    @Override
    public void deleteRenter(Integer id) {
        Renter renter = renterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));
        renter.getFlatList().forEach(flat -> {
            flat.setRenter(null);
            flatRepository.save(flat);
        });
        renter.setActive(false);
        renter.setCode(null);
        renterRepository.save(renter);
    }

    public boolean validateTCKN(String tckn) {
        if (tckn.length() != 11) {
            return false;
        }

        String firstDigitString = String.valueOf(tckn.charAt(0));
        if (Objects.equals(Integer.parseInt(firstDigitString), 0)) {
            return false;
        }

        int[] odds = new int[5];
        odds[0] = Integer.parseInt(String.valueOf(tckn.charAt(0)));
        odds[1] = Integer.parseInt(String.valueOf(tckn.charAt(2)));
        odds[2] = Integer.parseInt(String.valueOf(tckn.charAt(4)));
        odds[3] = Integer.parseInt(String.valueOf(tckn.charAt(6)));
        odds[4] = Integer.parseInt(String.valueOf(tckn.charAt(8)));

        int[] evens = new int[4];
        evens[0] = Integer.parseInt(String.valueOf(tckn.charAt(1)));
        evens[1] = Integer.parseInt(String.valueOf(tckn.charAt(3)));
        evens[2] = Integer.parseInt(String.valueOf(tckn.charAt(5)));
        evens[3] = Integer.parseInt(String.valueOf(tckn.charAt(7)));

        int oddsTotal = Arrays.stream(odds).sum();
        int evensTotal = Arrays.stream(evens).sum();

        if (!Objects.equals(((oddsTotal * 7) - evensTotal) % 10, Integer.parseInt(String.valueOf(tckn.charAt(9))))) {
            return false;
        }

        return Objects.equals((oddsTotal + evensTotal + Integer.parseInt(String.valueOf(tckn.charAt(9)))) % 10, Integer.parseInt(String.valueOf(tckn.charAt(10))));
    }
}
