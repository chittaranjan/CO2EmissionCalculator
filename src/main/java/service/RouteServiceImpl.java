package service;

import config.Config;
import model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class RouteServiceImpl implements RouteService {

    private static final String URL_GEOCODE = "https://api.openrouteservice.org/geocode/search";
    private static final String URL_MATRIX = "https://api.openrouteservice.org/v2/matrix/";
    private static final String API_KEY = "api_key";
    private static final String TEXT = "text";
    private static final String SIZE = "size";
    private Config config;

    public RouteServiceImpl() {
        config = Config.getInstance();
    }

    @Override
    public City geoCode(String cityName) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            URIBuilder uriBuilder = new URIBuilder(URL_GEOCODE);
            uriBuilder.addParameter(API_KEY, config.getAPIKey());
            uriBuilder.addParameter(TEXT, cityName);
            uriBuilder.addParameter(SIZE, "1");

            HttpGet httpGet = new HttpGet(uriBuilder.toString());
            httpGet.addHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));

            try (CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet)){
                City city = getFromHttpResponse(closeableHttpResponse);
                return city;
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public double getDistance(City city1, City city2, Profile profile) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = URL_MATRIX.concat(profile.getProfileName());
            URIBuilder uriBuilder = new URIBuilder(url);

        } catch (Exception e) {

        }
        return 0;
    }

    private City getFromHttpResponse(CloseableHttpResponse closeableHttpResponse) throws IOException {
        if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity);

            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("features");
            if (jsonArray == null || jsonArray.isEmpty()) {
                return null;
            }
            JSONObject feature = jsonArray.getJSONObject(0);
            if (feature != null) {
                City.Builder builder = new City.Builder();
                JSONObject geometryJsonObject = feature.getJSONObject("geometry");
                if (geometryJsonObject != null) {
                    builder.geometry(getGeometry(geometryJsonObject));
                }
                JSONArray boundingBoxJsonObject = feature.getJSONArray("bbox");
                if (boundingBoxJsonObject != null && boundingBoxJsonObject.isEmpty() == false) {
                    builder.boundingBox(getBoundingBox(boundingBoxJsonObject));
                }
                JSONObject properties = feature.getJSONObject("properties");
                String name = properties.getString("name");
                builder.name(name);
                return builder.build();
            }
        }
        return null;
    }

    private Geometry getGeometry(JSONObject jsonObject) {
        Geometry.Builder geometryBuilder = new Geometry.Builder();
        String type = jsonObject.getString("type");
        geometryBuilder.geometryType(GeometryType.valueOf(type));

        JSONArray coordinates = jsonObject.getJSONArray("coordinates");
        if (coordinates != null && !coordinates.isEmpty()) {
            double latitude = coordinates.getDouble(0);
            double longitude = coordinates.getDouble(1);
            LocationModel locationModel = new LocationModel(latitude, longitude);
            geometryBuilder.location(locationModel);
        }
        return geometryBuilder.build();
    }

    private BoundingBox getBoundingBox(JSONArray boundingBoxJsonArrayObject) {
        double topLeftLat = boundingBoxJsonArrayObject.getDouble(0);
        double topLeftLong = boundingBoxJsonArrayObject.getDouble(1);
        LocationModel topLeft = new LocationModel(topLeftLat, topLeftLong);

        double bottomRightLat = boundingBoxJsonArrayObject.getDouble(2);
        double bottomRightLong = boundingBoxJsonArrayObject.getDouble(3);
        LocationModel bottomRight = new LocationModel(bottomRightLat, bottomRightLong);
        BoundingBox boundingBox = new BoundingBox(topLeft, bottomRight);
        return boundingBox;
    }

}
