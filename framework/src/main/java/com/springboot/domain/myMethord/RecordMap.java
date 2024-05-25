package com.springboot.domain.myMethord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordMap {
    private Map<String,Boolean> map;

    public RecordMap(String english, Boolean temb) {
        map = new HashMap<>();
        map.put(english,temb);
    }
}
