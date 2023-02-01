package com.example.rent.PDF;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("UnpaidWarning")
public class UnpaidWarningStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "UnpaidWarning";
    }

    @Override
    public byte[] generatePdf(Object data) {
        return new byte[0];
    }
}
