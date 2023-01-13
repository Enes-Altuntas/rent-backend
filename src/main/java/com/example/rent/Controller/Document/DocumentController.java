package com.example.rent.Controller.Document;

import com.example.rent.Service.Document.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/{type}/{flatId}")
    public ResponseEntity<InputStreamResource> downloadPdf(@PathVariable String type, @PathVariable Integer flatId)
            throws IOException {

        String fileName = "document.pdf";

        if (Objects.equals(type, "NewContract")) {
            fileName = "Kira Sozlesmesi - " + flatId + ".pdf";
        } else if (Objects.equals(type, "Evacuation")) {
            fileName = "Tahliye Taahhutnamesi - " + flatId + ".pdf";
        } else if (Objects.equals(type, "ContractTermination")) {
            fileName = "Kontrat Fesih - " + flatId + ".pdf";
        } else if (Objects.equals(type, "Turnkey")) {
            fileName = "Tasinmaz ve Anahtar Teslim Tutanagi - " + flatId + ".pdf";
        } else if (Objects.equals(type, "UnpaidWarning")) {
            fileName = "Temerrut(Gecmis Kira) İhtarnamesi - " + flatId + ".pdf";
        } else if (Objects.equals(type, "FifthYearWarning")) {
            fileName = "5 Yillik Kiraci Kira Tespit - " + flatId + ".pdf";
        } else if (Objects.equals(type, "TenthYearWarning")) {
            fileName = "10 Yillik Sozlesme Fesih İhtar - " + flatId + ".pdf";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName);
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        byte[] document = documentService.downloadDocument(type, flatId);

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(document));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(document.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
