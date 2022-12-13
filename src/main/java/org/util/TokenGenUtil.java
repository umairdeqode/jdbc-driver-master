package org.util;

import com.skyflow.entities.ResponseToken;

import static org.util.Constants.CREDENTIALS_FILE_NAME;

public class TokenGenUtil {

    private static String bearerToken = null;

    public static String getBearerToken(String filePath) {
        try {
            filePath += CREDENTIALS_FILE_NAME;
            System.out.println("filepath ->" + filePath);
            if (TokenExpiry.isExpiredToken(bearerToken)) {
                ResponseToken response = TokenGenerator.generateBearerToken(filePath);
                bearerToken = response.getAccessToken();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return bearerToken;
    }
}
