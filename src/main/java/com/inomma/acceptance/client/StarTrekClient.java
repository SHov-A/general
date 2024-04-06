package com.inomma.acceptance.client;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

public interface StarTrekClient {

    HttpResponse getRequest(String path, Map<String, String> headers) throws IOException;

    HttpResponse postRequest(String path, Map<String, String> headers, Map<String, String> formParams) throws IOException;

}
