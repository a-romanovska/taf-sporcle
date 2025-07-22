package com.sporcle.enums;

public enum FileExtension {
    PROPERTIES(".properties");

    private final String extension;

    FileExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
