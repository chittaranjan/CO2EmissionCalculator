package service;

import config.Config;
import exception.InvalidApiKeyException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

public class APIKeyServiceImpl implements APIKeyService{
    private Config config;
    private boolean isValidKey;
    private static final String URL_GEOCODE = "https://api.openrouteservice.org/geocode/search";
    private static final String API_KEY = "api_key";
    private static final String TEXT = "text";


    public APIKeyServiceImpl() {
        config = Config.getInstance();
        isValidKey = false;
        validateKey();
    }

    private void validateKey() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            URIBuilder uriBuilder = new URIBuilder(URL_GEOCODE);
            uriBuilder.addParameter(API_KEY, config.getAPIKey());
            uriBuilder.addParameter(TEXT, "Berlin");

            HttpGet httpGet = new HttpGet(uriBuilder.toString());
            try (CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet)){
                int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
                if (responseCode != 401 && responseCode != 403) {
                    isValidKey = true;
                }
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValidApiKeyPresent() {
        return isValidKey;
    }

    @Override
    public String getApiKey() throws InvalidApiKeyException {
        if (isValidApiKeyPresent() == false) {
            throw new InvalidApiKeyException();
        }
        return config.getAPIKey();
    }
}
