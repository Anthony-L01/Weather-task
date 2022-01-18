package com.lxc.west2.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private String fxDate;
    private String CityID;
    private Integer tempMax;
    private Integer tempMin;
    private String textDay;

}
