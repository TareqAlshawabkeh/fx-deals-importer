package com.example.fxdeals.repository;

import com.example.fxdeals.entity.FxDeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FxDealRepository extends JpaRepository<FxDeal, Long> {

    Optional<FxDeal> findByDealId(String dealId);

    boolean existsByDealId(String dealId);
}
