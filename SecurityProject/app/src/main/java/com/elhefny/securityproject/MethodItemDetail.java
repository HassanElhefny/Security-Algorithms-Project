package com.elhefny.securityproject;

public class MethodItemDetail {
    private String methodName, methodDescription;

    public MethodItemDetail(String methodName, String methodDescription) {
        this.methodName = methodName;
        this.methodDescription = methodDescription;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMethodDescription() {
        return methodDescription;
    }
}
