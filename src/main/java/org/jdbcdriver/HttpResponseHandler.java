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

public class HttpResponseHandler {

    private static final Logger logger = LogManager.getLogger(HttpResponseHandler.class);

    public HttpResponseHandler() {
    }

    public JSONArray SendPost(String s, String vaultId, String filePath) throws Exception {

        String token = null;
        try {
            token = TokenGenerationUtil.getSkyflowBearerToken(filePath);
        } catch (Exception e) {
            logger.error("Issue in credentials.json file " + e);
            throw new SQLException("There is some issue in credentials.json file, not able to generate token");
        }
        logger.info("Token  : " + token);
        //vaultId = "u4882705de68469d92b5aa1d9ada9740";
        String uri = VAULT_URL + VERSION + "vaults/" + vaultId + "/query";
        URL url = new URL(uri);

        // Post connection request
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(POST);

        String authString = "Bearer " + token;
        conn.setRequestProperty("Authorization", authString);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String queryString = "{ \"query\": \"" + s + "\"}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = queryString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        logger.info("POST Response Code :: " + responseCode);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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

            URL url = new URL("https://manage.skyflowapis.dev/v1/vaults/h54b9fa800cc4916974fdc7407463783");
            String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2MiOiJmNzk0ZmY4NmZiYzgxMWVhYmQ2YzNhOTExNDNlM2Q0MiIsImF1ZCI6Imh0dHBzOi8vbWFuYWdlLnNreWZsb3dhcGlzLmRldiIsImV4cCI6MTY3MTI2MjQ0MywiaWF0IjoxNjY4NjcwNDQzLCJpc3MiOiJzYS1hdXRoQG1hbmFnZS5za3lmbG93YXBpcy5kZXYiLCJqdGkiOiJyODc1ZmU0NjZhODM0MGZkYjBjNjVjMjU4MTIxOTdmMiIsInN1YiI6ImUzZWQ2YmE5OWY1NjQ1YzNiZjZmZGRhYmJiYmYzYzYyIn0.FtIfLDxcslq2fu-fMJLTGaSXlkKDd2Y6n0gUqwHbrAosYSAdSd1vEpaMaetor4rpEIpweFp6KhscEQ0sAITppG0O_sUFMpfuzW-MTmqQL3m4IxrN50ryCghrnKroDAXP6Z0ZehYF27y4fhlYwQBw3gaA-YqygzpF3nkNutB2mWdAWuIBjvu5omUqk1aVHdWFC-d2KkQt2YJLuWbbaXb162K6JBavo03yQtAzqhQdppwZnUxZ6lUndWXo5-1rav8J-AdqbXxt9774yKcC7wVBu69XqGN7vosgFW9B7vyT8cz_lZmurbgsKOq-YukBfWlBqqUy3mhpQyh4ZTmth1n4kw";

            // GET connection request
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String authString = "Bearer " + token;
            conn.setRequestProperty("Authorization", authString);
            conn.setRequestMethod(GET);
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() != 200) {
                logger.error("Failed : HTTP error code : " + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            int responseCode = conn.getResponseCode();
            logger.info("POST Response Code :: " + responseCode);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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
            logger.error("MalformedURLException : " + e);
            e.printStackTrace();

        } catch (IOException e) {
            logger.error("IOException : " + e);
            e.printStackTrace();
        }

        return null;
    }
}
