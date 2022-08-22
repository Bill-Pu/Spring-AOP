package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * @Author PYB
 * @Date 2022/5/14 18:16
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("test")
    @Async
    public Student getTest(Student student){
        HashSet<Object> objects = new HashSet<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(localDateTime);
        new ConcurrentHashMap<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
        ArrayList<Object> objects1 = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = stringStringHashMap.entrySet().iterator();
        for (;iterator.hasNext();){
            iterator.next();
        }
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();
        return student;
    }
}
