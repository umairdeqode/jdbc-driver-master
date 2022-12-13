package org.jdbcdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

import static org.util.Constants.CREDENTIALS_FILE_NAME;

public class SkyflowDriver implements Driver {
    private static final Logger logger = LogManager.getLogger(SkyflowDriver.class);
    private static final Driver INSTANCE = new SkyflowDriver();

    private static boolean registered;

    public SkyflowDriver() {
    }

    @Override
    public Connection connect(String s, Properties properties) throws SQLException {

        String credsPath;
        String domainUrl;
        String vaultId;
        String filePath;

        if(properties.getProperty("filePath").isEmpty()) {
            logger.error("FilePath is not provided.");
            throw new SQLException("FilePath is not provided.");
        }

        filePath = properties.getProperty("filePath");
        logger.info("FilePath : " + filePath);
        Path path = Paths.get(filePath).toAbsolutePath();
        logger.info("Path : " + path.toString());

        if (!Files.isDirectory(path)) {
            logger.error("Given path : '" + path + "' is not a directory");
            throw new SQLException("'" + path + "' is not a directory");
        }
        credsPath = filePath;
        logger.info("credentials file : " + path.toString() + CREDENTIALS_FILE_NAME);

        String[] parts = s.split(":");

        if (parts.length < 2 || !parts[0].toLowerCase().equals("jdbc") ||
                !parts[1].toLowerCase().equals("skyflow")) return null;

        if (parts.length < 5) {
            logger.error("Vault Id is not passed or incorrect");
            throw new SQLException("Vault Id is not passed or incorrect");
        } else vaultId = parts[4];

        // domain url contains ':' so require parts[2] +":" + parts[3]
        domainUrl = parts[2] +":" + parts[3];
        logger.info("directory : " + domainUrl);
        logger.info("vaultId : " + vaultId);

        boolean flag = new File(path.toString() + CREDENTIALS_FILE_NAME).isFile();
        if (flag == false) {
            logger.error("Credentials file does not exists.");
            throw new SQLException("Credentials file does not exists.");
        }

        return new SkyflowConnection(path, vaultId, credsPath,domainUrl);

    }

    @Override
    public boolean acceptsURL(String s) throws SQLException {
        return true;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return true;
    }

    @Override
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public static synchronized Driver load() {
        if (!registered) {
            registered = true;
            try {
                DriverManager.registerDriver(INSTANCE);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return INSTANCE;
    }

    static {
        load();
    }
}
