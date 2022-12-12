package org.util;
//
//import com.skyflow.common.utils.Helpers;
//import com.skyflow.common.utils.LogUtil;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyflow.common.utils.Helpers;
import com.skyflow.common.utils.HttpUtility;
import com.skyflow.entities.ResponseToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Date;

public class TokenGenerator {

    public static ResponseToken generateBearerToken(String filepath) {
        // LogUtil.printInfoLog(InfoLogs.GenerateBearerTokenCalled.getLog());
        JSONParser parser = new JSONParser();
        ResponseToken responseToken = null;
        Path path = null;
        try {
            if (filepath == null || filepath.isEmpty()) {
                //  LogUtil.printErrorLog(ErrorLogs.EmptyFilePath.getLog());
                // throw new SkyflowException(ErrorCode.EmptyFilePath);
            }
            path = Paths.get((filepath));
            Object obj = parser.parse(new FileReader(String.valueOf(path)));
            JSONObject saCreds = (JSONObject) obj;

            responseToken = getSATokenFromCredsFile(saCreds);

        } catch (FileNotFoundException e) {
            //  LogUtil.printErrorLog(Helpers.parameterizedString(ErrorLogs.InvalidCredentialsPath.getLog(), String.valueOf(path)));
            // throw new SkyflowException(ErrorCode.InvalidCredentialsPath.getCode(), Helpers.parameterizedString(ErrorCode.InvalidCredentialsPath.getDescription(), String.valueOf(path)), e);
        } catch (IOException e) {
            // LogUtil.printErrorLog(Helpers.parameterizedString(ErrorLogs.InvalidCredentialsPath.getLog(), String.valueOf(path)));
            // throw new SkyflowException(ErrorCode.InvalidCredentialsPath.getCode(), Helpers.parameterizedString(ErrorCode.InvalidCredentialsPath.getDescription(), String.valueOf(path)), e);
        } catch (ParseException e) {
            // LogUtil.printErrorLog(Helpers.parameterizedString(ErrorLogs.InvalidJsonFormat.getLog(), String.valueOf(path)));
            // throw new SkyflowException(ErrorCode.InvalidJsonFormat.getCode(), Helpers.parameterizedString(ErrorCode.InvalidJsonFormat.getDescription(), String.valueOf(path)), e);
        }

        return responseToken;
    }

    private static ResponseToken getSATokenFromCredsFile(JSONObject creds) {
        ResponseToken responseToken = null;
        try {
            String clientID = (String) creds.get("clientID");
            if (clientID == null) {
//                LogUtil.printErrorLog(ErrorLogs.InvalidClientID.getLog());
//                throw new SkyflowException(ErrorCode.InvalidClientID);
            }
            String keyID = (String) creds.get("keyID");
            if (keyID == null) {
//                LogUtil.printErrorLog(ErrorLogs.InvalidKeyID.getLog());
//                throw new SkyflowException(ErrorCode.InvalidKeyID);
            }
            String tokenURI = (String) creds.get("tokenURI");
            if (tokenURI == null) {
//                LogUtil.printErrorLog(ErrorLogs.InvalidTokenURI.getLog());
//                throw new SkyflowException(ErrorCode.InvalidTokenURI);
            }

            PrivateKey pvtKey = Helpers.getPrivateKeyFromPem((String) creds.get("privateKey"));

            String signedUserJWT = getSignedUserToken(clientID, keyID, tokenURI, pvtKey);

            JSONObject parameters = new JSONObject();
            parameters.put("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
            parameters.put("assertion", signedUserJWT);

            String response = HttpUtility.sendRequest("POST", new URL(tokenURI), parameters, null);

            responseToken = new ObjectMapper().readValue(response, ResponseToken.class);

        } catch (Exception e) {
//            LogUtil.printErrorLog(ErrorLogs.UnableToReadResponse.getLog());
//            throw new SkyflowException(ErrorCode.UnableToReadResponse, e);
        }
        return responseToken;
    }

    private static String getSignedUserToken(String clientID, String keyID, String tokenURI, PrivateKey pvtKey) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + (3600 * 1000));
        String signedToken = Jwts.builder()
                .claim("iss", clientID)
                .claim("key", keyID)
                .claim("aud", tokenURI)
                .claim("sub", clientID)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.RS256, pvtKey)
                .compact();

        return signedToken;
    }
}
