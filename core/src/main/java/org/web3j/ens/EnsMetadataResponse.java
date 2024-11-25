package org.web3j.ens;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnsMetadataResponse {
    public boolean is_normalized;
    public String name;
    public String description;
    public Attribute[] attributes;
    public String url;
    public long last_request_date;
    public int version;
    public String background_image;
    public String image;
    public String image_url;

    public static class Attribute {
        public String trait_type;
        public String display_type;
        public Object value;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Error serializing EnsMetadataResponse: " + e.getMessage();
        }
    }
}
