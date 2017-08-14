package com.yunseul.api.controller.model;

public class ApiResponse<T> {
    //Common
    public static final Integer OK = 200;

    public static final Integer BAD_REQUEST = 1001;
    public static final Integer FORBIDDEN = 1002;
    public static final Integer UNSUPPORTED_MEDIA_TYPE = 1003;
    public static final Integer SERVER_ERROR = 1004;

    public static final Integer NOT_FOUND_RECOMMENDATION = 2001;

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Integer code;
    private T result;

    public ApiResponse() {
        code = OK;
    }

    public ApiResponse(Integer code) {
        this.code = code;
    }

    public ApiResponse(T result) {
        code = OK;
        this.result = result;
    }

    public ApiResponse(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public T getResult() {
        return result;
    }

    public static ApiResponse badRequest() {
        return new ApiResponse(BAD_REQUEST);
    }

    public static ApiResponse forbidden() {
        return new ApiResponse(FORBIDDEN);
    }

    public static ApiResponse unsupportedMediaType() {
        return new ApiResponse(UNSUPPORTED_MEDIA_TYPE);
    }

    public static ApiResponse serverError() {
        return new ApiResponse(SERVER_ERROR);
    }

    public static ApiResponse notFound() {
        return new ApiResponse(NOT_FOUND_RECOMMENDATION);
    }
}
