package com.example.rent.Service.FlatStatus;

import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import com.example.rent.Entity.FlatStatus.FlatStatus;
import com.example.rent.Mapper.FlatStatus.GetFlatStatusDTOFromEntityMapper;
import com.example.rent.Repository.FlatStatus.FlatStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FlatStatusServiceImpl implements FlatStatusService {
    private final GetFlatStatusDTOFromEntityMapper getFlatStatusDTOFromEntityMapper;
    private final FlatStatusRepository flatStatusRepository;

    @Override
    public List<GetFlatStatusDTO> getFlatStatusAsDropdown() {
        List<FlatStatus> flatStatuses = flatStatusRepository.findAll();

        return getFlatStatusDTOFromEntityMapper.fromEntityListToDTOList(flatStatuses);
    }
}
