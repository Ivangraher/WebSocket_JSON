package com.example.webclient_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebClientDto {

    private Integer id;
    private String title;
    private String body;
    private Integer userId;

}
