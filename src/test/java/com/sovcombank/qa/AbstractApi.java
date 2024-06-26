package com.sovcombank.qa;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AbstractApi {
    private final static String ROOT_PATH = "src/test/resources";

    @SneakyThrows
    public static String getResourceAsString(String path) {
        if (!path.startsWith("/")) path = "/" + path;
        path = ROOT_PATH + path;
        return FileUtils.readFileToString(new File(path), UTF_8);
    }
}
