package com.sguess.process.monitor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class PMonitor {

    public BigDecimal getCurrentPricePercent() {
        return new BigDecimal(10.00);
    }
}
