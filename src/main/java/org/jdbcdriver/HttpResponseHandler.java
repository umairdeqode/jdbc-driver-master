package org.jdbcdriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.util.TokenGenerationUtil;

import static org.util.Constants.*;
import static org.util.ErrorMessages.*;

public class HttpResponseHandler {

    private static final Logger logger = LogManager.getLogger(HttpResponseHandler.class);

    public HttpResponseHandler() {
    }

    public JSONArray SendPost(String query, String vaultId, String filePath, String domainUrl) throws Exception {

        String token = null;
        try {
            token = TokenGenerationUtil.getSkyflowBearerToken(filePath);
        } catch (Exception e) {
            logger.error(CREDS_ISSUE + e);
            throw new SQLException(TOKEN_GENERATION_FAILURE);
        }
        logger.info("Token  : " + token);
        String uri = domainUrl + VERSION + "vaults/" + vaultId + "/query";
        logger.info("Domain url : " + uri);
        URL url = new URL(uri);

        // Post connection request
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(POST);

        String authString = BEARER + token;
        conn.setRequestProperty(AUTHORIZATION, authString);
        conn.setRequestProperty(CONTENT_TYPE, "application/x-www-form-urlencoded");
        conn.setRequestProperty(CONTENT_TYPE, "application/json");
        conn.setDoOutput(true);

        String queryString = "{ \"query\": \"" + query + "\"}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = queryString.getBytes(UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        logger.info(POST_REQUEST_STATUS_CODE + responseCode);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), UTF8));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0; ) sb.append((char) c);

        String responsePost = sb.toString();

        JSONObject obj = new JSONObject(responsePost.toString());
        JSONArray result = obj.getJSONArray("records");

        //Removing fields from json result
        JSONArray finalResponse = new JSONArray();
        for (int i = 0; i < result.length(); i++) {
            JSONObject ob = result.getJSONObject(i);
            finalResponse.put(i, (JSONObject) ob.get("fields"));
        }

        return finalResponse;
    }


    public JSONArray sendGet() {

        try {

            URL url = new URL(DATATYPE_VAULT_URL);
            String token = DATATYPE_VAULT_URL_TOKEN;

            // GET connection request
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String authString = BEARER + token;
            conn.setRequestProperty(AUTHORIZATION, authString);
            conn.setRequestMethod(GET);
            conn.setRequestProperty(ACCEPT, "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() != 200) {
                logger.error(GET_REQUEST_FAILED + conn.getResponseCode());
                throw new RuntimeException(GET_REQUEST_FAILED
                        + conn.getResponseCode());
            }

            int responseCode = conn.getResponseCode();
            logger.info(GET_REQUEST_STATUS_CODE + responseCode);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), UTF8));
            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0; )
                sb.append((char) c);
            String responsePost = sb.toString();

            JSONObject obj = new JSONObject(responsePost.toString());
            JSONArray arr = obj.getJSONObject("vault").getJSONArray("schemas");
            Iterator<Object> iterator = arr.iterator();
            JSONObject obj1 = (JSONObject) iterator.next();
            JSONArray result = obj1.getJSONArray("fields");
            conn.disconnect();

            return result;

        } catch (MalformedURLException e) {
            logger.error(MALFORMED_URL_EXCEPTION + e);
            e.printStackTrace();

        } catch (IOException e) {
            logger.error(IO_EXCEPTION  + e);
            e.printStackTrace();
        }

        return null;
    }
}
