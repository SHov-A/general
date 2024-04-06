package com.inomma.acceptance.client;

import com.inomma.acceptance.exception.StarTrekException;
import com.inomma.acceptance.pages.StorePage;
import org.apache.http.*;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class StarTrekService {

    private static final String PATH_TO_GIFTS = "/api/v1/offers/gifts";
    private static final String PATH_TO_GIFTS_CLAIM = "/api/v1/offers/gifts/claim";
    private static final String TOKEN = "authorization";
    private static final String BUNDLE_ID = "bundleId";
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> formParams = new HashMap<>();

    @Autowired
    private StorePage storePage;

    @Autowired
    private StarTrekClient starTrekClient;

    @Value("${gifts.baseURL}")
    private String path;

    @Value("${gifts.jsonPATH}")
    private String jsonPath;

    public void getGifts(String accessToken) {
        headers.put(TOKEN, storePage.getCookieValue(accessToken, true));
        try {
            HttpResponse response = starTrekClient.getRequest(path + PATH_TO_GIFTS, headers);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                File outputFile = Paths.get(jsonPath).toFile();
                InputStream inputStream = entity.getContent();
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                int read;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, read);
                }
                fileOutputStream.close();
            } else {
                throw new StarTrekException("Download fail from " + jsonPath);
            }
        } catch (IOException e) {
            final String msg = "error when calling star trek server";
            System.err.println(msg + ":" + e);
            throw new StarTrekException(msg, e);
        }
    }

    public int getStatusCode(String accessToken, String bundleId) {
        headers.put(TOKEN, storePage.getCookieValue(accessToken, true));
        formParams.put(BUNDLE_ID, bundleId);
        HttpResponse response = null;
        try {
            response = starTrekClient.postRequest(path + PATH_TO_GIFTS_CLAIM, headers, formParams);
        } catch (IOException e) {
            final String msg = "error when calling star trek server";
            System.err.println(msg);
            response = new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 500, "server error"));
        }
        return response.getStatusLine().getStatusCode();
    }

}
