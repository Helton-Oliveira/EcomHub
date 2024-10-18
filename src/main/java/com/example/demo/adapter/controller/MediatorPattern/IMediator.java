package com.example.demo.adapter.controller.MediatorPattern;

import java.util.Map;

public interface IMediator {
    <T> T execute(Map<String, String> stringMap, String reqName);
}
