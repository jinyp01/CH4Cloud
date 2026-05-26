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

        // 회원 존재 확인 (검증용)
        Member member = memberService.findMember(memberId);

        try {
            String key = "profile/" + memberId + "/"
                    + UUID.randomUUID() + "_"
                    + file.getOriginalFilename();

            s3Template.upload(bucket, key, file.getInputStream());

            return key;

        } catch (IOException e) {
            throw new FileUploadFailException();
        }
    }

    /**
     * Presigned URL 생성 (7일)
     */
    public URL getDownloadUrl(Long memberId, String key) {

        memberService.findMember(memberId);

        return s3Template.createSignedGetURL(
                bucket,
                key,
                PRESIGNED_URL_EXPIRATION
        );
    }
}