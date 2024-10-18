package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.MediatorPattern.IMediator;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IMediator mediator;

    public ProductController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createProduct(@RequestBody Map<String, String> attributes) {
        var result = mediator.execute(attributes, "post");
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<?> getProduct(@RequestBody Map<String, String> attributes) {
        var result = mediator.execute(attributes, "get");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{category}")
    public ResponseEntity<?> getAllProducts(@PathVariable Map<String, String> endPoint) {
        var result = mediator.execute(endPoint, "get");
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateActiveOrDeactivateProduct(@PathVariable Map<String, String> id) {
        var result = mediator.execute(id, "put");
        return ResponseEntity.ok(result);
    }

}
