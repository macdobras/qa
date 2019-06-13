package com.jsystems.qa.qaapi;

public class DeviceModel {

    @JsonProperty(required = true);
    public String produce;

    @JsonProperty(value = "screen.size", required = true);
    public int screenSize;
}
