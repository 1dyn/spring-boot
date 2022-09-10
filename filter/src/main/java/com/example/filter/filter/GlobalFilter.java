package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
//@Component // Spring에 의해 Bean으로 관리
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리 구간
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request; // filter 단에서는 request / response를 변경시킬 수 있음
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 위의 것은 누구든 한번 읽으면 다시 읽을 수 없어서 api controller에서 body를 읽으려하면 오류 발생
        // 아래는 캐싱을 하기 때문에 한번 읽었더라도 다시 읽을 수 있음
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);


        String url = httpServletRequest.getRequestURI();

        chain.doFilter(httpServletRequest, httpServletResponse); // log를 찍을거면 doFilter 아래에 찍어야 함

        // 후처리 구간

        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse(); // 커서가 아래로 다시 내려갔기 때문에 읽은만큼 복사해준다

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}
