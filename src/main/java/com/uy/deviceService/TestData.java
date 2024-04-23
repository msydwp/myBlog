package com.uy.deviceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {

    public static List<Map<String,Object>> getTestC02Data(){

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("c02002","沪EP2863");
        map.put("c02003","6001");
        map.put("c02007","G04");
        map.put("c02014","863014541340676");
        data.add(map);

        map = new HashMap<String,Object>();
        map.put("c02002","沪DH0445");
        map.put("c02003","6001");
        map.put("c02007","G04");
        map.put("c02014","863014541340677");
        data.add(map);

        map = new HashMap<String,Object>();
        map.put("c02002","沪EF3688");
        map.put("c02003","6001");
        map.put("c02007","G04");
        map.put("c02014","863014541340698");
        data.add(map);

        map = new HashMap<String,Object>();
        map.put("c02002","沪EF368833");
        map.put("c02003","6001");
        map.put("c02007","G04");
        map.put("c02014","");
        data.add(map);

        return data;
    }

}
