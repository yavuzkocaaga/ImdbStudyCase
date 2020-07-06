package com.studycase.imdb.controller.payload.message;

import com.studycase.imdb.util.ImdbEnums;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UIMessage {

    private String code;

    private String message;

    private ImdbEnums.Severity severity;

    public UIMessage(String code, String message, ImdbEnums.Severity severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    public void setSeverity(ImdbEnums.Severity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "{" + "code : '" + code + '\'' + ", message:'" + message + '\'' + ", severity : "
                + severity + '}';
    }

}
