package com.project.blog.service;

public interface SecurityService {
    String createToken(String subject, long ttlMillis);
    String getSubject(String token);
}
