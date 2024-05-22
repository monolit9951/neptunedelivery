package com.neptunes.dto.order.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientInfo implements Serializable {
    private String phoneNumber;
    private String name;
}
