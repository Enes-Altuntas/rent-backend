package com.example.rent.PDF;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("TenthYearWarning")
public class TenthYearWarningStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "TenthYearWarning";
    }

    @Override
    public byte[] generatePdf(Object data) {
        return new byte[0];
    }
}
