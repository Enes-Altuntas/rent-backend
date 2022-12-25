package com.example.rent.Controller.File;

import com.example.rent.Entity.File.File;
import com.example.rent.Repository.File.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RequestMapping("/api/v1/files")
@RestController
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FileController {
    private final FileRepository fileRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Dosya bulunamadı!"));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }
}
