package com.example.consumetric.repository;

import com.example.consumetric.response.RepositoryResponse;

public interface Repository <T> {
    void selectAll(RepositoryResponse<T> repositoryResponse);
    void selectById(int id, RepositoryResponse<T> repositoryResponse);
    void search(String keyword, RepositoryResponse<T> repositoryResponse);
    void insert(T t, RepositoryResponse<T> repositoryResponse);
    void update(T t, RepositoryResponse<T> repositoryResponse);
    void delete(T t, RepositoryResponse<T> repositoryResponse);
    void deleteAll(RepositoryResponse<T> repositoryResponse);

}
