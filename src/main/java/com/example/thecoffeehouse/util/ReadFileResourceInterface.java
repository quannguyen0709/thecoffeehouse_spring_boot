package com.example.thecoffeehouse.util;

public interface ReadFileResourceInterface {

    public static ReadFileResourceInterface getInstance() {
        return  ReadFileResource.getInstance();
    }

    public String getFileUseResourceLoader(String pathName);

    public String getFileUseClassPathResource(String pathName);
}
