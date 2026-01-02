package com.example.fxdeals.controller;

import com.example.fxdeals.service.FxDealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/fx-deals")
public class FxDealCsvController {

    private final FxDealService fxDealService;

    public FxDealCsvController(FxDealService fxDealService) {
        this.fxDealService = fxDealService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file) {
        fxDealService.importCsv(file);
        return ResponseEntity.ok("CSV uploaded successfully");
    }

}
