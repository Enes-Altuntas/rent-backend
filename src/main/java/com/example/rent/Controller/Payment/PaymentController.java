package com.example.rent.Controller.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.DTO.Payment.GetPaymentDTO;
import com.example.rent.Mapper.Payment.CreatePaymentRequestToDTOMapper;
import com.example.rent.Mapper.Payment.DeletePaymentRequestToDTOMapper;
import com.example.rent.Mapper.Payment.GetPaymentDTOToResponseMapper;
import com.example.rent.Request.Payment.CreatePaymentRequest;
import com.example.rent.Request.Payment.DeletePaymentRequest;
import com.example.rent.Response.Payment.GetPaymentResponse;
import com.example.rent.Service.Payment.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final CreatePaymentRequestToDTOMapper createPaymentRequestToDTOMapper;
    private final GetPaymentDTOToResponseMapper getPaymentDTOToResponseMapper;
    private final DeletePaymentRequestToDTOMapper deletePaymentRequestToDTOMapper;

    @PostMapping("/create")
    public ResponseEntity<GetPaymentResponse> createPayment(
            @RequestPart(value = "data") String jsonText,
            @RequestPart(value = "file", required = false) MultipartFile file) {

        CreatePaymentRequest createPaymentRequest;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            createPaymentRequest = objectMapper.readValue(jsonText, CreatePaymentRequest.class);

        } catch (IOException err) {

            throw new RuntimeException();
        }

        CreatePaymentDTO createPaymentDTO = createPaymentRequestToDTOMapper.fromRequestToDTO(createPaymentRequest);

        GetPaymentDTO getPaymentDTO = paymentService.createPayment(createPaymentDTO, file);

        GetPaymentResponse getPaymentResponse = getPaymentDTOToResponseMapper.fromDTOToResponse(getPaymentDTO);

        return new ResponseEntity<>(getPaymentResponse, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<Integer> deletePayment(@Valid @RequestBody DeletePaymentRequest deletePaymentRequest) {

        DeletePaymentDTO deletePaymentDTO = deletePaymentRequestToDTOMapper.fromRequestToDTO(deletePaymentRequest);

        paymentService.deletePayment(deletePaymentDTO);

        return new ResponseEntity<>(deletePaymentRequest.getPaymentId(), HttpStatus.NO_CONTENT);
    }
}
