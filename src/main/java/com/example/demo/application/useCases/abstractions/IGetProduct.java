package com.example.demo.application.useCases.abstractions;

import com.example.demo.adapter.dto.OutputProductDTO;

public interface IGetProduct {
    OutputProductDTO execute(String id, String category);
}
