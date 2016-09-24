package com.halalmeatdepot.web.data;

import java.util.List;

/**
 * Created by vashishta on 9/24/16.
 */
public class JsonResponse {
    private Object payload;
    private List<ErrorMessage> errorMessages;

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
