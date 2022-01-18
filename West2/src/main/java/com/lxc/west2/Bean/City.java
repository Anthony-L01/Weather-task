package com.lxc.west2.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {
    public String name;
    public String id;
    public double latitude;
    public double longitude;


}
