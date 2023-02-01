package com.example.rent.Controller.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Mapper.Payment.CreatePaymentRequestToDTOMapper;
import com.example.rent.Mapper.Payment.DeletePaymentRequestToDTOMapper;
import com.example.rent.Mapper.Renter.Get.GetRenterDTOToResponseMapper;
import com.example.rent.Request.Payment.CreatePaymentRequest;
import com.example.rent.Request.Payment.DeletePaymentRequest;
import com.example.rent.Response.Renter.Get.GetRenterResponse;
import com.example.rent.Service.Payment.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentService paymentService;
  private final CreatePaymentRequestToDTOMapper createPaymentRequestToDTOMapper;
  private final DeletePaymentRequestToDTOMapper deletePaymentRequestToDTOMapper;
  private final GetRenterDTOToResponseMapper getRenterDTOToResponseMapper;

  @PostMapping("/create")
  public ResponseEntity<GetRenterResponse> createPayment(
      @RequestPart(value = "data") String jsonText,
      @RequestPart(value = "file", required = false) MultipartFile file) {

    CreatePaymentRequest createPaymentRequest;
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      createPaymentRequest = objectMapper.readValue(jsonText, CreatePaymentRequest.class);

    } catch (IOException err) {

      throw new RuntimeException();
    }

    CreatePaymentDTO createPaymentDTO = createPaymentRequestToDTOMapper.fromRequestToDTO(
        createPaymentRequest);

    GetRenterDTO getRenterDTO = paymentService.createPayment(createPaymentDTO, file);

    GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(
        getRenterDTO);

    return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity<GetRenterResponse> deletePayment(
      @Valid @RequestBody DeletePaymentRequest deletePaymentRequest) {

    DeletePaymentDTO deletePaymentDTO = deletePaymentRequestToDTOMapper.fromRequestToDTO(
        deletePaymentRequest);

    GetRenterDTO getRenterDTO = paymentService.deletePayment(deletePaymentDTO);

    GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(
        getRenterDTO);

    return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
  }
}
