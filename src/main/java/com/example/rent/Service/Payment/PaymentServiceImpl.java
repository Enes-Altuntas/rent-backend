package com.example.rent.Service.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Entity.File.File;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.Renter.Get.GetRenterEntityToDTOMapper;
import com.example.rent.Repository.File.FileRepository;
import com.example.rent.Repository.Flat.FlatRepository;
import com.example.rent.Repository.Payment.PaymentRepository;
import com.example.rent.Repository.Renter.RenterRepository;
import java.io.IOException;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;
  private final FlatRepository flatRepository;
  private final FileRepository fileRepository;
  private final RenterRepository renterRepository;
  private final GetRenterEntityToDTOMapper getRenterEntityToDTOMapper;

  @Override
  @Transactional
  public GetRenterDTO createPayment(CreatePaymentDTO createPaymentDTO,
      MultipartFile multipartFile) {

    File savedFile;
    Flat flat = flatRepository.findById(createPaymentDTO.getFlatId())
        .orElseThrow(() -> new NoSuchElementException("Daire bulunamadı!"));
    Renter renter = renterRepository.findById(createPaymentDTO.getRenterId())
        .orElseThrow(() -> new NoSuchElementException("Kiracı bulunamadı!"));

    if (!renter.isActive()) {
      throw new RuntimeException();
    }

    try {
      File file = new File();
      file.setName(multipartFile.getOriginalFilename());
      file.setType(multipartFile.getContentType());
      file.setData(multipartFile.getBytes());
      savedFile = fileRepository.save(file);
    } catch (IOException e) {
      throw new RuntimeException();
    }

    Payment payment = new Payment();
    payment.setFile(savedFile);
    payment.setFlat(flat);
    payment.setRenter(renter);
    paymentRepository.saveAndFlush(payment);

    return getRenterEntityToDTOMapper.fromEntityToDTO(renter);
  }

  @Override
  public GetRenterDTO deletePayment(DeletePaymentDTO deletePaymentDTO) {
    Payment payment = paymentRepository.findById(deletePaymentDTO.getPaymentId())
        .orElseThrow(() -> new NoSuchElementException("Ödeme bulunamadı!"));

    paymentRepository.delete(payment);

    return getRenterEntityToDTOMapper.fromEntityToDTO(payment.getRenter());
  }
}
