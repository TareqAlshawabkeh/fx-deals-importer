package com.example.fxdeals.dto;

public class FxDealImportResultDTO {

    private int totalRows;
    private int saved;
    private int skipped;

    public FxDealImportResultDTO(int totalRows, int saved, int skipped) {
        this.totalRows = totalRows;
        this.saved = saved;
        this.skipped = skipped;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getSaved() {
        return saved;
    }

    public int getSkipped() {
        return skipped;
    }
}
