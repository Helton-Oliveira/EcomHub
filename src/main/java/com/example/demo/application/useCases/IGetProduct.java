package com.example.demo.application.useCases;

import com.example.demo.adapter.dto.OutputProductDTO;

public interface IGetProduct {
    OutputProductDTO execute(String id, String category);
}
