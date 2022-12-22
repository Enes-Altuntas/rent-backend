package com.example.rent.Controller.FlatType;

import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOToResponseMapper;
import com.example.rent.Response.FlatType.GetFlatTypeResponse;
import com.example.rent.Service.FlatType.FlatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/flattype")
@RequiredArgsConstructor
public class FlatTypeController {

    private final FlatTypeService flatTypeService;
    private final GetFlatTypeDTOToResponseMapper getFlatTypeDTOToResponseMapper;

    @GetMapping
    public ResponseEntity<List<GetFlatTypeResponse>> getAllFlatType() {
        List<GetFlatTypeDTO> getFlatTypeDTOList = flatTypeService.getAllFlatType();

        List<GetFlatTypeResponse> getFlatTypeResponseList = getFlatTypeDTOToResponseMapper.fromDTOListToResponseList(getFlatTypeDTOList);

        return new ResponseEntity<>(getFlatTypeResponseList, HttpStatus.OK);
    }

}
