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

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/{type}/{flatId}")
    public ResponseEntity<InputStreamResource> downloadPdf(@PathVariable String type, @PathVariable Integer flatId)
            throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=document.pdf");
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
