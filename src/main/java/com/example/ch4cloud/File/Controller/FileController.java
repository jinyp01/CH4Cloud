package com.example.ch4cloud.File.Controller;

import com.example.ch4cloud.File.Dto.FileDownloadUrlResponse;
import com.example.ch4cloud.File.Dto.FileUploadResponse;
import com.example.ch4cloud.File.Service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final S3Service s3Service;

    @PostMapping("/files/upload")
    public ResponseEntity<FileUploadResponse> upload(@RequestParam("file") MultipartFile file) {
        String key = s3Service.upload(file); // 업로드를 하면 버킷 안에 저장되는 키를 받아서 리턴
        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    @GetMapping("/files/download-url")
    public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@RequestParam String key) {
        URL url = s3Service.getDownloadUrl(key); // 키를 쿼리스트링으로 넣으면 URL 리턴
        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }
}