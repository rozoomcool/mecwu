package ru.mecwu.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus httpsStatus;
    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, HttpStatus httpsStatus) {
        super(msg);
        this.httpsStatus = httpsStatus;
    }

    public HttpStatus getHttpsStatus() {
        return httpsStatus;
    }

    public void setHttpsStatus(HttpStatus httpsStatus) {
        this.httpsStatus = httpsStatus;
    }
}
