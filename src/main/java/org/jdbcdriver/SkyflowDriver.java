package org.jdbcdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

import static org.util.Constants.*;
import static org.util.ErrorMessages.*;

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

        if(properties.getProperty(FILEPATH).isEmpty()) {
            logger.error(FILE_PATH_MISSING);
            throw new SQLException(FILE_PATH_MISSING);
        }

        filePath = properties.getProperty(FILEPATH);
        logger.info(FILE_PATH + filePath);
        Path path = Paths.get(filePath).toAbsolutePath();
        logger.info(PATH + path.toString());

        if (!Files.isDirectory(path)) {
            logger.error(FILE_PATH_ERROR + path);
            throw new SQLException(FILE_PATH_ERROR + path);
        }
        credsPath = filePath;
        logger.info(CREDS_FILE + path.toString() + CREDENTIALS_FILE_NAME);

        String[] parts = s.split(":");

        if (parts.length < 2 || !parts[0].toLowerCase().equals(JDBC) ||
                !parts[1].toLowerCase().equals(SKYFLOW)) return null;

        if (parts.length < 5) {
            logger.error(ISSUE_WITH_VAULT_ID);
            throw new SQLException(ISSUE_WITH_VAULT_ID);
        } else vaultId = parts[4];

        // domain url contains ':' so require parts[2] +":" + parts[3]
        domainUrl = parts[2] +":" + parts[3];
        logger.info(DIRECTORY + domainUrl);
        logger.info(VAULT_ID + vaultId);

        boolean flag = new File(path.toString() + CREDENTIALS_FILE_NAME).isFile();
        if (flag == false) {
            logger.error(CREDS_FILE_MISSING);
            throw new SQLException(CREDS_FILE_MISSING);
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
