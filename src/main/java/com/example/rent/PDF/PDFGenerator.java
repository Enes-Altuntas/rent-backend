package com.example.rent.PDF;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class PDFGenerator {
    private final Map<String, PDFStrategy> strategies;

    public PDFGenerator(@Qualifier("NewContract") PDFStrategy newContractPDFStrategy,
                        @Qualifier("Evacuation") PDFStrategy evacuationStrategy,
                        @Qualifier("ContractTermination") PDFStrategy contractTerminationStrategy,
                        @Qualifier("Turnkey") PDFStrategy turnkeyStrategy,
                        @Qualifier("UnpaidWarning") PDFStrategy unpaidWarningStrategy,
                        @Qualifier("FifthYearWarning") PDFStrategy fifthYearWarningStrategy,
                        @Qualifier("TenthYearWarning") PDFStrategy tenthYearWarningStrategy) {
        this.strategies = Map.of(
                "NewContract", newContractPDFStrategy,
                "Evacuation", evacuationStrategy,
                "ContractTermination", contractTerminationStrategy,
                "Turnkey", turnkeyStrategy,
                "UnpaidWarning", unpaidWarningStrategy,
                "FifthYearWarning", fifthYearWarningStrategy,
                "TenthYearWarning", tenthYearWarningStrategy
        );
    }

    public byte[] generatePdf(String type, Object data) throws IOException {
        PDFStrategy strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("Bilinmeyen döküman tipi: " + type);
        }

        return strategy.generatePdf(data);
    }
}
