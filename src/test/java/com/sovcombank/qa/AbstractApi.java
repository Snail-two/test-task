package com.sovcombank.qa;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AbstractApi {
    private final static String ROOT_PATH = "src/test/resources";

    public static String getResourceAsString(String path) {
        try {
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            path = ROOT_PATH + path;
            File file = new File(path);
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
