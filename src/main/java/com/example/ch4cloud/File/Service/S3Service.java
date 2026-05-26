package com.example.ch4cloud.File.Service;

import com.example.ch4cloud.Member.Entity.Member;
import com.example.ch4cloud.Member.Service.MemberService;
import com.example.ch4cloud.exception.FileUploadFailException;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);

    private final S3Template s3Template;
    private final MemberService memberService;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(Long memberId, MultipartFile file) {

        // 1. member 존재 확인
        Member member = memberService.findMember(memberId);

        // 2. 파일 검증 (추가 안전장치)
        if (file == null || file.isEmpty()) {
            throw new FileUploadFailException();
        }

        try {
            String key = "uploads/" + memberId + "/"
                    + UUID.randomUUID() + "_"
                    + file.getOriginalFilename();

            s3Template.upload(bucket, key, file.getInputStream());

            return key;

        } catch (IOException e) {
            throw new FileUploadFailException();
        }
    }

    // ✅ Presigned URL 생성
    public URL getDownloadUrl(Long memberId, String key) {

        // member 존재 검증
        memberService.findMember(memberId);

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("S3 key가 없습니다.");
        }

        return s3Template.createSignedGetURL(
                bucket,
                key,
                PRESIGNED_URL_EXPIRATION
        );
    }
}