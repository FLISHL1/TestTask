package com.testtask.controller;

import com.testtask.entity.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
public interface ApiController<T> {
    public ResponseEntity<List<Product>> getAll();
    public ResponseEntity getEntity(Long entityId);

    public ResponseEntity<String> deleteEntity(Long entityId);
}