package com.sergiubarsa.mybank.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorDto {

    private String errorMessage;
    private final List<String> failedFields = new ArrayList<String>();

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getFailedFields() {
        return Collections.unmodifiableList(failedFields);
    }

    public void addFailedField(String failedField) {
        failedFields.add(failedField);
    }


}
