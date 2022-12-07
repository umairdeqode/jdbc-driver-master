package org.util;

import com.skyflow.entities.ResponseToken;
//import com.skyflow.errors.SkyflowException;
import com.skyflow.serviceaccount.util.Token;

public class TokenGenUtil {

    private static String bearerToken = null;

    public static String getBearerToken() {
        try {
            System.out.println("Inside Token Gen Util ---------------------->");
            String filePath = "/home/deq/IdeaProjects/jdbc-driver-master/vault/credentials.json";
             if(TokenExpiry.isExpiredToken(bearerToken)) {
                ResponseToken response = TokenGenerator.generateBearerToken(filePath);
                bearerToken = response.getAccessToken();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return bearerToken;
    }
}
