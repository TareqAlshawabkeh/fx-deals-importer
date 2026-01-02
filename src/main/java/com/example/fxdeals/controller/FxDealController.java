package com.example.fxdeals.controller;
import jakarta.validation.Valid;

    import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.example.fxdeals.dto.FxDealRequestDTO;
import com.example.fxdeals.dto.FxDealResponseDTO;
import com.example.fxdeals.service.FxDealService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/fx-deals")
@RequestMapping("/api/v1/fx-deals")

public class FxDealController {

    private final FxDealService fxDealService;

    public FxDealController(FxDealService fxDealService) {
        this.fxDealService = fxDealService;
    }

    @PostMapping
    public ResponseEntity<FxDealResponseDTO> createDeal(
            @Valid @RequestBody FxDealRequestDTO dto
    ) {
        FxDealResponseDTO saved = fxDealService.saveDeal(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAllDeals() {
        return ResponseEntity.ok(fxDealService.getAllDeals());
    }


@GetMapping("/paged")
public ResponseEntity<Page<FxDealResponseDTO>> getDealsPaged(
        @PageableDefault(
                size = 10,
                sort = "dealTimestamp",
                direction = org.springframework.data.domain.Sort.Direction.DESC
        ) Pageable pageable
) {
    return ResponseEntity.ok(fxDealService.getDeals(pageable));
}

}
