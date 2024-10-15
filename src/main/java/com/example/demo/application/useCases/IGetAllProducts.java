package com.example.demo.application.useCases;

import com.example.demo.adapter.dto.OutputProductDTO;

import java.util.List;

public interface IGetAllProducts {
    List<OutputProductDTO> execute(String category);
}
