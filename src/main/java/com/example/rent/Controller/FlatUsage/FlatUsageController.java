package com.example.rent.Controller.FlatUsage;

import com.example.rent.DTO.FlatUsage.GetFlatUsageDTO;
import com.example.rent.Mapper.FlatUsage.GetFlatUsageResponseFromDTOMapper;
import com.example.rent.Response.FlatUsage.GetFlatUsageResponse;
import com.example.rent.Service.FlatUsage.FlatUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flatusage")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FlatUsageController {
    private final FlatUsageService flatUsageService;

    private final GetFlatUsageResponseFromDTOMapper getFlatUsageResponseFromDTOMapper;

    @GetMapping()
    public ResponseEntity<List<GetFlatUsageResponse>> getAll() {
        List<GetFlatUsageDTO> getFlatUsageDTOList = flatUsageService.getAll();

        List<GetFlatUsageResponse> getFlatUsageResponseList = getFlatUsageResponseFromDTOMapper.fromDTOListToResponseList(getFlatUsageDTOList);

        return new ResponseEntity<>(getFlatUsageResponseList, HttpStatus.OK);
    }
}
