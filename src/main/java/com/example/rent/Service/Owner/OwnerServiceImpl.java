package com.example.rent.Service.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.DTO.Owner.Get.GetOwnerDTO;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Mapper.Owner.CreateOwnerDTOFromEntityMapper;
import com.example.rent.Repository.Owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final CreateOwnerDTOFromEntityMapper createOwnerDTOFromEntityMapper;

    @Override
    public CreateOwnerDTO saveOwner(CreateOwnerDTO createOwnerDTO) {
        validateTCKN(createOwnerDTO.getTckn());
        Owner owner = new Owner();
        owner.setTckn(createOwnerDTO.getTckn());
        owner.setNameSurname(createOwnerDTO.getNameSurname());
        owner.setPhoneNumber(createOwnerDTO.getPhoneNumber());

        Owner savedOwner = ownerRepository.save(owner);

        return  createOwnerDTOFromEntityMapper.fromEntityToDTO(savedOwner);
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

        if (!Objects.equals((oddsTotal + evensTotal + Integer.parseInt(String.valueOf(tckn.charAt(9)))) % 10, Integer.parseInt(String.valueOf(tckn.charAt(10))))) {
            return false;
        }

        return true;
    }
}
