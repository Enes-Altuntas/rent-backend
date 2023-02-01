package com.example.rent.Service.Document;

import java.io.IOException;

public interface DocumentService {

    byte[] downloadDocument(String type, Integer flatId) throws IOException;

}
