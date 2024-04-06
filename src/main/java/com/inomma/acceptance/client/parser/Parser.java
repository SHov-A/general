package com.inomma.acceptance.client.parser;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface Parser {

    JsonNode getJsonData(String path) throws IOException;

}
