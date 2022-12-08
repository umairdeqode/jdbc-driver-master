package org.util;
import com.skyflow.errors.SkyflowException;
import com.skyflow.serviceaccount.util.Token;
import com.skyflow.entities.ResponseToken;
import org.jdbcdriver.SkyflowDriver;

import static org.util.Constants.CREDENTIALS_FILE_NAME;

public class TokenGenerationUtil { private static String bearerToken = null;

    public static String getSkyflowBearerToken(String filePath) {
        try {
            //String fileDir = SkyflowDriver.credsPath;
            filePath+=CREDENTIALS_FILE_NAME;
            //String filePath = fileDir + CREDENTIALS_FILE_NAME;
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
