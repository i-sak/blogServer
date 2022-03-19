package com.project.blog.advice;

import com.project.blog.annotation.TokenRequired;
import com.project.blog.service.SecurityServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Aspect
@Component
public class SecurityAspect {

    // JWT인증을 AOP로 적용하기
    // TokenRequired 어노테이션이 필요한 경우의 Advice
    @Before("@annotation(tokenRequired)")
    public void tokenRequiredWithAnnotation(TokenRequired tokenRequired)
            throws Throwable {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // checks for token in request header
        String tokenInheader = request.getHeader("token");
        if(StringUtils.isEmpty(tokenInheader)) {
            throw  new IllegalArgumentException("Empty token");
        }
        Claims claime = Jwts.parser().setSigningKey(DatatypeConverter
                .parseBase64Binary(SecurityServiceImpl.secretKey))
                .parseClaimsJws(tokenInheader).getBody();
        if(claime == null || claime.getSubject() == null) {
            throw new IllegalArgumentException("Token Error : Claim is null");
        }
        if(!claime.getSubject().equalsIgnoreCase("kim")) {
            throw new IllegalArgumentException("Subject doesn't match in the token");
        }
        //System.out.println("Before tokenRequiredWithAnnotation");
    }
}
