package com.sporcle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtils {
    public static String readFile(String filName) {
        String fileContent = "";
        try {
            fileContent = readResourcesFile(filName);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return fileContent;
    }

    public static String readResourcesFile(String filePath) throws IOException {
        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            if (inputStream == null) {
                throw new IOException("Файл не найден: " + filePath);
            }
            scanner.useDelimiter("\\A");  //читаем весь файл целиком
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
