package org.jdbcdriver;

//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonParser;
//import com.google.gson.Gson;
//import com.google.api.client.json.JsonParser;
//import com.google.gson.*;
/*import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.util.TokenGenUtil;
import org.util.TokenGenerationUtil;

import static org.util.Constants.VAULT_URL;
import static org.util.Constants.VERSION;
//import org.util.TokenGenerationUtil;

//import org.json.simple.JSONObject;

public class HttpResponseHandler{

	
	 public HttpResponseHandler() {}
    
    
    public JSONArray SendPost (String s,String vaultId,String filePath) throws Exception {
		String token = null;
        try {
            token = TokenGenerationUtil.getSkyflowBearerToken(filePath);
        } catch (Exception e) {
        throw new SQLException("There is some issue in credentials.json file, not able to generate token");
        }
		System.out.println(token);

		//vaultId = "u4882705de68469d92b5aa1d9ada9740";
		String uri = VAULT_URL + VERSION + "vaults/" + vaultId + "/query";

		URL url = new URL(uri);

        // Post connection request
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        String authString = "Bearer " + token;
        conn.setRequestProperty("Authorization", authString);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String strFinal = "{ \"query\": \"" + s + "\"}";
        		
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = strFinal.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) sb.append((char)c);

		String responsePost = sb.toString();
       
        JSONObject obj = new JSONObject(responsePost.toString());
        JSONArray result = obj.getJSONArray("records");
        

		return result;
    }
}
