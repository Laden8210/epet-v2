package com.example.consumetric.response;

import java.util.List;

public interface RepositoryResponse<T> {
    void onSuccess(T object);
    void onSuccessList(List<T> objectList);
    void onSuccessMessage(String message);
    void onFailure(String message);
}
