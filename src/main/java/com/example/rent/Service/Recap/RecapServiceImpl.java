package com.example.rent.Service.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Mapper.Recap.GetrRecapDTOFromEntityMapper;
import com.example.rent.Repository.Flat.FlatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecapServiceImpl implements RecapService {
    private final FlatRepository flatRepository;
    private final GetrRecapDTOFromEntityMapper getrRecapDTOFromEntityMapper;

    @Override
    public List<GetRecapDTO> getRecap() {
        List<Flat> flatList = flatRepository.findAll();

        return getrRecapDTOFromEntityMapper.fromEntityListToDTOList(flatList);
    }
}
