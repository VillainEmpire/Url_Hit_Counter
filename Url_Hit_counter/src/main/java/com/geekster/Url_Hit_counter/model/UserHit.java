package com.geekster.Url_Hit_counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHit {

    private String userName;
    private Integer count;
}
