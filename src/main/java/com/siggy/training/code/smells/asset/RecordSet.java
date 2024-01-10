package com.siggy.training.code.smells.asset;

import java.math.BigDecimal;

public class RecordSet {
    public int getRowCount() {
        return 0;
    }
    public String getItem(int row, String issueName) {
        return null;
    }
    public BigDecimal getDecimal(int row, String marketPrice) {
        return null;
    }
}
