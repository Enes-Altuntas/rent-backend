package com.example.rent.Service.Land;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.DTO.Land.Get.GetLandDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Land.Land;
import com.example.rent.Entity.Owner.Owner;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.Land.Create.CreateLandDTOFromEntityMapper;
import com.example.rent.Mapper.Land.Get.GetLandDTOFromEntityMapper;
import com.example.rent.Repository.Land.LandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LandServiceImpl implements LandService {
    private final LandRepository landRepository;
    private final CreateLandDTOFromEntityMapper createLandDTOFromEntityMapper;
    private final GetLandDTOFromEntityMapper getLandDTOFromEntityMapper;

    @Override
    public CreateLandDTO saveLand(CreateLandDTO createLandDTO) {
        Land land = new Land();

        land.setNeighbourhood(createLandDTO.getNeighbourhood());
        land.setProvince(createLandDTO.getProvince());
        land.setState(createLandDTO.getState());
        land.setAdaNo(createLandDTO.getAdaNo());
        land.setParselNo(createLandDTO.getParselNo());
        land.setPrice(createLandDTO.getPrice());
        land.setOwners(new ArrayList<>());

        Land savedLand = landRepository.save(land);

        return  createLandDTOFromEntityMapper.fromEntityToDTO(savedLand);
    }

    @Override
    public List<GetLandDTO> getAllLands() {
        List<Land> landList = landRepository.findAll();
        List<GetLandDTO> getLandDTOList = getLandDTOFromEntityMapper.fromEntityListToDTOList(landList);
        return  getLandDTOList;
    }
}
