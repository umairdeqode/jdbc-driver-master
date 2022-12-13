package org.util;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TokenExpiry {

    public static boolean isExpiredToken(String token) {

        long expiryTime;
        long currentTime;
        try {
            if (token == null || token.isEmpty()) {
                return true;
            }

            currentTime = new Date().getTime() / 1000;

            String[] split = token.split("\\.");
            byte[] decodedBytes = Base64.decodeBase64(split[1]);
            JSONObject jsn = (JSONObject) (new JSONParser()).parse(new String(decodedBytes, StandardCharsets.UTF_8));

            expiryTime = (long) jsn.get("exp");

        } catch (ParseException e) {
            return true;
        } catch (Exception e) {
            return true;
        }
        return currentTime >= expiryTime;
    }
}
