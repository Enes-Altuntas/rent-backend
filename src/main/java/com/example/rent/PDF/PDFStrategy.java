package com.example.rent.PDF;

import java.io.IOException;

public interface PDFStrategy {

    String getType();

    byte[] generatePdf(Object data) throws IOException;

}
