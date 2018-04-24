package com.projeto.controller;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

    @GetMapping(value = "")
    public Pessoa hello() {
        return new Pessoa().setAge(19).setName("Vitinho");
    }

    @Data
    @Accessors(chain = true)
    private class Pessoa {
        private String name;
        private Integer age;
    }
}
