package com.example.fxdeals.service;

import com.example.fxdeals.dto.FxDealRequestDTO;
import com.example.fxdeals.dto.FxDealResponseDTO;
import com.example.fxdeals.entity.FxDeal;
import com.example.fxdeals.repository.FxDealRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FxDealService {

    private final FxDealRepository fxDealRepository;

    public FxDealService(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    // ===============================
    // CREATE SINGLE DEAL
    // ===============================
    @Transactional
    public FxDealResponseDTO saveDeal(FxDealRequestDTO dto) {

        if (fxDealRepository.existsByDealId(dto.getDealId())) {
            throw new IllegalArgumentException(
                    "FX Deal with dealId [" + dto.getDealId() + "] already exists"
            );
        }

        if (dto.getFromCurrency().equals(dto.getToCurrency())) {
            throw new IllegalArgumentException(
                    "From currency and To currency must be different"
            );
        }

        FxDeal entity = new FxDeal();
        entity.setDealId(dto.getDealId());
        entity.setFromCurrency(dto.getFromCurrency());
        entity.setToCurrency(dto.getToCurrency());
        entity.setAmount(dto.getAmount());
        entity.setDealTimestamp(dto.getDealTimestamp());

        FxDeal saved = fxDealRepository.save(entity);
        return mapToResponse(saved);
    }

    // ===============================
    // GET ALL (NO PAGINATION)
    // ===============================
    public List<FxDealResponseDTO> getAllDeals() {
        return fxDealRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ===============================
    // GET WITH PAGINATION
    // ===============================
    public Page<FxDealResponseDTO> getDeals(Pageable pageable) {
        return fxDealRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    // ===============================
    // CSV IMPORT
    // ===============================
    @Transactional
    public void importCsv(MultipartFile file) {

        try (
                Reader reader = new BufferedReader(
                        new InputStreamReader(file.getInputStream())
                );
                CSVParser csvParser = new CSVParser(
                        reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader()
                )
        ) {
for (CSVRecord record : csvParser) {

    String dealId = record.get("dealId");

    if (fxDealRepository.existsByDealId(dealId)) {
        continue;
    }

    if (record.get("fromCurrency").equals(record.get("toCurrency"))) {
        continue; // skip invalid FX deal
    }

    FxDeal deal = new FxDeal();
    deal.setDealId(dealId);
    deal.setFromCurrency(record.get("fromCurrency"));
    deal.setToCurrency(record.get("toCurrency"));
    deal.setAmount(new BigDecimal(record.get("amount")));
    deal.setDealTimestamp(
            LocalDateTime.parse(record.get("dealTimestamp"))
    );

    fxDealRepository.save(deal);
}



        } catch (Exception e) {
            throw new RuntimeException("Failed to import CSV file", e);
        }
    }

    // ===============================
    // ENTITY → DTO MAPPER
    // ===============================
    private FxDealResponseDTO mapToResponse(FxDeal deal) {
        return new FxDealResponseDTO(
                deal.getId(),
                deal.getDealId(),
                deal.getFromCurrency(),
                deal.getToCurrency(),
                deal.getAmount(),
                deal.getDealTimestamp()
        );
    }
}
