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

    public JSONArray SendPost(String query, String vaultId, String filePath, String domainUrl) throws Exception {

        String token = null;
        try {
            token = TokenGenerationUtil.getSkyflowBearerToken(filePath);
        } catch (Exception e) {
            logger.error("Issue in credentials.json file " + e);
            throw new SQLException("There is some issue in credentials.json file, not able to generate token");
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
        logger.info("POST Response Code :: " + responseCode);

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
                logger.error("Failed : HTTP error code : " + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            int responseCode = conn.getResponseCode();
            logger.info("POST Response Code :: " + responseCode);

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
            logger.error("MalformedURLException : " + e);
            e.printStackTrace();

        } catch (IOException e) {
            logger.error("IOException : " + e);
            e.printStackTrace();
        }

        return null;
    }
  
  
   public JSONArray SendGet() {
	   
	   try {

			URL url = new URL("https://manage.skyflowapis.dev/v1/vaults/u4882705de68469d92b5aa1d9ada9740");
			String token1="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2MiOiJmNzk0ZmY4NmZiYzgxMWVhYmQ2YzNhOTExNDNlM2Q0MiIsImF1ZCI6Imh0dHBzOi8vbWFuYWdlLnNreWZsb3dhcGlzLmRldiIsImV4cCI6MTY3Mjk5MDI5OCwiaWF0IjoxNjcwMzk4Mjk4LCJpc3MiOiJzYS1hdXRoQG1hbmFnZS5za3lmbG93YXBpcy5kZXYiLCJqdGkiOiJkYjZjYTYxMjVmNTU0ZGJiOTc2ZjI3Y2RmZmM1OGZhNCIsInN1YiI6ImUzZWQ2YmE5OWY1NjQ1YzNiZjZmZGRhYmJiYmYzYzYyIn0.K4kbBOyUKGyZzcpPyQ3_4d1XTHJsGgsYrlfyC_QC8KmgJhwuW0jdJ7RALI1FvSkPQ723J--kAeDhKNCazSWPjvbDhwCIkdxFASd17XASgjOri692Glhwqh1qwXVxrTRI8yCCv5x1ty29MjF7mfD3VQmUgtJ9Fjct6bVGWYXD0rW388znz14QYBeGzg0ErnqbJBqc079gl3ow35Xc6EoE9CumZrSw2-aC4_0RGtRUTttHleEJ-HWGFFZbB9O4tvxWvDfUuysKeuw8P64kMKL-FbhIW6--JpQYZR8zMS-Ui2e7FvWREhqxZ5AU_yQzIdFb79oM93k_mSjLuEytyZYiZw";
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        String authString = "Bearer " + token1;
	        conn.setRequestProperty("Authorization", authString);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			int responseCode = conn.getResponseCode();
	        System.out.println("POST Response Code GET:: " + responseCode);
	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        StringBuilder sb = new StringBuilder();
	        for (int c; (c = in.read()) >= 0;)
	            sb.append((char)c);
	        String responsePost = sb.toString();
	       
	        JSONObject obj = new JSONObject(responsePost.toString());
	        JSONArray arr = obj.getJSONObject("vault").getJSONArray("schemas");
	        Iterator<Object> iterator = arr.iterator();
	        JSONObject obj1 = (JSONObject) iterator.next();
	        JSONArray arr1= obj1.getJSONArray("fields");
	       
			conn.disconnect();
			 return arr1;

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	   
	   return null;
   }
}
