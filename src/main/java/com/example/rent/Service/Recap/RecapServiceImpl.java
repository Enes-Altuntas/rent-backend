package com.example.rent.Service.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.Recap.GetRecapRentDTOFromEntityMapper;
import com.example.rent.Repository.Renter.RenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecapServiceImpl implements RecapService {
    private final RenterRepository renterRepository;
    private final GetRecapRentDTOFromEntityMapper getRecapRentDTOFromEntityMapper;

    @Override
    public List<GetRecapDTO> getRecap() {
        List<Renter> renterList = renterRepository.findAllByActiveIsTrue();
        List<GetRecapDTO> getRecapDTOList = getRecapRentDTOFromEntityMapper.fromEntityListToDTOList(renterList);
        return getRecapDTOList;
    }
}
