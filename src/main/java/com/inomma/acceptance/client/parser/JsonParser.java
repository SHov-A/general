package com.inomma.acceptance.client.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Paths;

public class JsonParser implements Parser {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public JsonNode getJsonData(String path) throws IOException {
        return objectMapper.readTree(Paths.get(path).toFile());
    }

}
