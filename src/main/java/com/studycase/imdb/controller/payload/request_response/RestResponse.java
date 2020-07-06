package com.studycase.imdb.controller.payload.request_response;

import com.studycase.imdb.controller.payload.PlayerMoviesDto;
import com.studycase.imdb.controller.payload.message.UIMessage;
import com.studycase.imdb.util.ImdbEnums.Severity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;

    private List<UIMessage> messages = new ArrayList<>();

    public RestResponse(T data) {
        this.data = data;
    }

    public static <T> RestResponse<T> ofWarn(T t, UIMessage message) {
        RestResponse<T> restResponse = new RestResponse<>(t);
        message.setSeverity(Severity.WARN);
        restResponse.getMessages().add(message);
        return restResponse;
    }

    public static <T> RestResponse<T> of(T t) {
        UIMessage uiMessage = new UIMessage(null, null, Severity.INFO);
        RestResponse<T> restResponse = new RestResponse<>(t);
        restResponse.getMessages().add(uiMessage);
        return restResponse;
    }

    public static <T> RestResponse<T>  ofSuccess(T t, String code, String message) {
        UIMessage uiMessage = new UIMessage(code, message, Severity.SUCCESS);
        RestResponse<T> restResponse = new RestResponse<>(t);
        restResponse.getMessages().add(uiMessage);
        return restResponse;
    }

    public static <T> RestResponse<T> ofInfo(T t, String code, String message) {
        UIMessage uiMessage = new UIMessage(code, message, Severity.INFO);
        RestResponse<T> restResponse = new RestResponse<>(t);
        restResponse.getMessages().add(uiMessage);
        return restResponse;
    }

    public static <T> RestResponse<T> ofError(T t, UIMessage message) {
        RestResponse<T> restResponse = new RestResponse<>(t);
        message.setSeverity(Severity.ERROR);
        restResponse.getMessages().add(message);
        return restResponse;
    }

    public static <T> RestResponse<T> ofErrors(T t, List<UIMessage> messages) {
        RestResponse<T> restResponse = new RestResponse<>(t);
        restResponse.getMessages().addAll(messages);
        return restResponse;
    }


}
