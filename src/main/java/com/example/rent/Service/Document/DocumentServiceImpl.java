package com.example.rent.Service.Document;

import com.example.rent.Entity.Flat.Flat;
import com.example.rent.PDF.PDFGenerator;
import com.example.rent.Repository.Flat.FlatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final FlatRepository flatRepository;
    private final PDFGenerator pdfGenerator;

    @Override
    public byte[] downloadDocument(String type, Integer flatId) throws IOException {
        Flat flat = flatRepository.findById(flatId).orElseThrow();

        return pdfGenerator.generatePdf(type, flat);
    }
}
