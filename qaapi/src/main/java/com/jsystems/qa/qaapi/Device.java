package com.jsystems.qa.qaapi;

import java.util.List;

public class Device {

    public String type;

    @JsonProperty(value = "device.model", required = true);
    List<Device> device.model;


}
