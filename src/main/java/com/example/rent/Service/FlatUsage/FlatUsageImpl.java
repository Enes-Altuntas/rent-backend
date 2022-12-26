package com.example.rent.Service.FlatUsage;

import com.example.rent.DTO.FlatUsage.FlatUsageDTO;
import com.example.rent.Entity.FlatUsage.FlatUsage;
import com.example.rent.Mapper.FlatUsage.FlatUsageDTOFromEntityMapper;
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

    private final FlatUsageDTOFromEntityMapper flatUsageDTOFromEntityMapper;

    @Override
    public List<FlatUsageDTO> getAll() {
        List<FlatUsage> flatUsages = flatUsageRepository.findAll();

        List<FlatUsageDTO> flatUsageDTOList = flatUsageDTOFromEntityMapper.fromEntityListToDTOList(flatUsages);

        return flatUsageDTOList;
    }
}
