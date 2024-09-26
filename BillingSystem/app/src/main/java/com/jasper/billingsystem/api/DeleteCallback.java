package com.jasper.billingsystem.api;

public interface DeleteCallback {
    void onDeleteSuccess(String response);
    void onDeleteFail(String error);
}
