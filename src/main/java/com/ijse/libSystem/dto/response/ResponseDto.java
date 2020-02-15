package com.ijse.libSystem.dto.response;

public class ResponseDto {

    private final Long id;
    private final int status;
    private final String message;

    public ResponseDto(Long id, int status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
