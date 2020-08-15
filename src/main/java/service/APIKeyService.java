package service;

import exception.InvalidApiKeyException;

public interface APIKeyService {
    boolean isValidApiKeyPresent();
    String getApiKey() throws InvalidApiKeyException;
}
