package com.alfredo.nba.NBASports.allEums;

public enum ApiKeyEnum {
    TARGET_URL("https://api.balldontlie.io"),
    API_KEY("80c447d7-c3bd-4e00-96a3-0b4aec53026e");

    private final String value;

    private ApiKeyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
