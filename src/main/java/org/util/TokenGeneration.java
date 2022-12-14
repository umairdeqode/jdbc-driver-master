package org.util;

import com.skyflow.entities.ResponseToken;
import com.skyflow.errors.SkyflowException;
import com.skyflow.serviceaccount.util.Token;

import static org.constants.HTTPConstants.CREDENTIALS_FILE_NAME;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdbcdriver.HttpResponseHandler;

public class TokenGeneration {
	
	private static final Logger logger = LogManager.getLogger(TokenGeneration.class);
    private static String bearerToken = null;

    public static String getSkyflowBearerToken(String filePath) {
        try {

            filePath += CREDENTIALS_FILE_NAME;
            logger.info("File path of credentials.json : " + filePath);
            if (Token.isExpired(bearerToken)) {
                ResponseToken response = Token.generateBearerToken(filePath);
                bearerToken = response.getAccessToken();
            }
        } catch (SkyflowException e) {
            logger.error("Skyflow Exception while generating token :" + e);
            e.printStackTrace();
        }

        return bearerToken;
    }

}
