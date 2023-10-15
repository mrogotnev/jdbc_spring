package com.mrogotnev.jdbc_jpa_spring.controller;

import com.mrogotnev.jdbc_jpa_spring.services.DeleteAndInitTestDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeleteAndInitTestDataController {
    private DeleteAndInitTestDataService deleteAndInitTestDataService;

    @GetMapping("/deleteAndInitTestData")
    public void deleteAndInitTestData() {
        deleteAndInitTestDataService.deleteAndInitTestData();
    }
}
