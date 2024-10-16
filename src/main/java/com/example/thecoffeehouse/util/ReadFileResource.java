package com.example.thecoffeehouse.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class ReadFileResource implements ReadFileResourceInterface{

    private static ReadFileResource INSTANCE;

    private ReadFileResource() {;
    }

    public static ReadFileResource getInstance() {
        if(INSTANCE == null) {
            return new ReadFileResource();
        }
        return INSTANCE;
    }

    @Override
    public String getFileUseResourceLoader(String pathName) {
        String readText = "";
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        try {
            InputStream inputStream = resourceLoader.getResource("classpath:" + pathName).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            readText = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            bufferedReader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return readText;
    }


    @Override
    public String getFileUseClassPathResource(String pathName) {
        String employees = "";
        try {
            File resource = new ClassPathResource(pathName).getFile();
             employees = new String(
                    Files.readAllBytes(resource.toPath()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
