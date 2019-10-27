package com.djh.core.wrapper;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HttpServletRequest 包装类，用于保存body
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    /**
     * 用于将流保存下来
     */
    private byte[] requestBody = null;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            requestBody = StreamUtils.copyToByteArray(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() {
        if (requestBody == null) {
            requestBody = new byte[0];
        }
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}
