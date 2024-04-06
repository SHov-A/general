package com.inomma.acceptance.client.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.inomma.acceptance.exception.StarTrekException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebGiftsService {

    private static final String SPECIAL = "is_special";
    private static final String BONUS_LABEL = "bonus_label";
    private static final String OFFER_DETAILS = "offer_details";
    private static final String BUNDLE_ID = "bundle_id";
    private static final String VALID_COUNT = "valid_count";

    @Autowired
    private Parser parser;

    @Value("${gifts.jsonPATH}")
    private String path;

    public List<Integer> getValidBundleIdsFromGiftsJson() {
        List<Integer> ids = new ArrayList<>();
        try {
            JsonNode jsonNode = parser.getJsonData(path);
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                final JsonNode next = elements.next();
                int special = next.get(SPECIAL).asInt();
                JsonNode bonus = next.get(BONUS_LABEL);
                JsonNode offer = next.get(OFFER_DETAILS);
                if (bonus == null && special == 0 && !offer.isEmpty() && offer.get(VALID_COUNT).asInt() > 0) {
                    ids.add(next.get(BUNDLE_ID).asInt());
                }
            }
        } catch (Exception e) {
            final String msg = "can't find json file";
            System.err.println(msg);
            throw new StarTrekException(msg, e);
        }
        return ids;
    }

}
