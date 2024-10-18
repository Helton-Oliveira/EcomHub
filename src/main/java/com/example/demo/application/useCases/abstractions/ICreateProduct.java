package com.example.demo.application.useCases.abstractions;

import java.util.Map;

public interface ICreateProduct {
    void execute(Map<String, String> attributes);
}
