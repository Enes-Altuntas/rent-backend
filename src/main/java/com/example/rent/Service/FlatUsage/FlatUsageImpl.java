package com.example.rent.Service.FlatUsage;

import com.example.rent.DTO.FlatUsage.GetFlatUsageDTO;
import com.example.rent.Entity.FlatUsage.FlatUsage;
import com.example.rent.Mapper.FlatUsage.GetFlatUsageDTOFromEntityMapper;
import com.example.rent.Repository.FlatUsage.FlatUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FlatUsageImpl implements FlatUsageService {
    private final FlatUsageRepository flatUsageRepository;

    private final GetFlatUsageDTOFromEntityMapper getFlatUsageDTOFromEntityMapper;

    @Override
    public List<GetFlatUsageDTO> getAll() {
        List<FlatUsage> flatUsages = flatUsageRepository.findAll();

        List<GetFlatUsageDTO> getFlatUsageDTOList = getFlatUsageDTOFromEntityMapper.fromEntityListToDTOList(flatUsages);

        return getFlatUsageDTOList;
    }
}
