package ru.csu.iit.backend.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class TestBase {
    protected Properties properties;

    public TestBase() {
        properties = new Properties();

        String propertiesFileName = System.getProperty("PROPERTIES_FILE");

        if (propertiesFileName == null)
            propertiesFileName = "ru.csu.iit.backend/app.properties";

        try (InputStream in = TestBase.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            properties.load(in);
        } catch (IOException e) {
            throw new AssertionError("Test run blocked. Cannot read properties: " + propertiesFileName, e);
        }
    }
}
