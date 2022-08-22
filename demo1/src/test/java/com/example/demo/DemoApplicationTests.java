package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//@SpringBootTest

class DemoApplicationTests {

    @Test
    void contextLoads() {
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        for (Map.Entry<Object,Object> entry: objectObjectHashMap.entrySet()
             ) {
            Object key = entry.getKey();
            Object value = entry.getValue();
        }
        Set<Object> objects = objectObjectHashMap.keySet();
        for (Object ey: objects
             ) {
            Object o = objectObjectHashMap.get(ey);
        }
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            Object value = next.getValue();
            Object key = next.getKey();
        }
    }

}
