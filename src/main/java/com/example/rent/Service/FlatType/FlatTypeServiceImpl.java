package com.example.rent.Service.FlatType;

import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatType.FlatType;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOFromEntityMapper;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOToResponseMapper;
import com.example.rent.Repository.FlatType.FlatTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FlatTypeServiceImpl implements FlatTypeService {

    private final FlatTypeRepository flatTypeRepository;

    private final GetFlatTypeDTOFromEntityMapper getFlatTypeDTOFromEntityMapper;
    @Override
    public List<GetFlatTypeDTO> getAllFlatType() {
        List<FlatType> flatTypeList = flatTypeRepository.findAll();
        List<GetFlatTypeDTO> flatTypeDTOList = getFlatTypeDTOFromEntityMapper.fromEntityListToDTOList(flatTypeList);
        return flatTypeDTOList;
    }
}
