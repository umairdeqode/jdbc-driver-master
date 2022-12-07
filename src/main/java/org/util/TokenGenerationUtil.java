package org.util;
import com.skyflow.errors.SkyflowException;
import com.skyflow.serviceaccount.util.Token;
import com.skyflow.entities.ResponseToken;

public class TokenGenerationUtil { private static String bearerToken = null;

    public static String getSkyflowBearerToken() {
        try {
            String filePath = "/home/deq/IdeaProjects/jdbc-driver-master/vault/credentials.json";
            if(Token.isExpired(bearerToken)) {
                ResponseToken response = Token.generateBearerToken(filePath);
                bearerToken = response.getAccessToken();
            }
        } catch (SkyflowException e) {
            e.printStackTrace();
        }

        return bearerToken;
    }
}
