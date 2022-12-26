package com.example.rent.Controller.FlatUsage;

import com.example.rent.DTO.FlatUsage.FlatUsageDTO;
import com.example.rent.Mapper.FlatUsage.FlatUsageResponseFromDTOMapper;
import com.example.rent.Response.FlatUsage.FlatUsageResponse;
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
@RequestMapping("/api/v1/flattypeusage")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FlatUsage {
    private final FlatUsageService flatUsageService;

    private final FlatUsageResponseFromDTOMapper flatUsageResponseFromDTOMapper;

    @GetMapping()
    public ResponseEntity<List<FlatUsageResponse>> getAll(){
        List<FlatUsageDTO> flatUsageDTOList = flatUsageService.getAll();
        List<FlatUsageResponse> flatUsageResponseList = flatUsageResponseFromDTOMapper.fromDTOListToResponseList(flatUsageDTOList);

        return new ResponseEntity<>(flatUsageResponseList, HttpStatus.OK);
    }
}
