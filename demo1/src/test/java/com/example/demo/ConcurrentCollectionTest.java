package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author PYB
 * @Date 2022/8/21 18:33
 * @Version 1.0
 */
public class ConcurrentCollectionTest {
    @Test
    public void test(){
        ConcurrentSkipListMap<Object, Object> objectObjectConcurrentSkipListMap = new ConcurrentSkipListMap<>();
        ConcurrentLinkedDeque<Object> objects = new ConcurrentLinkedDeque<>();
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantLock lock = new ReentrantLock();
    }
}
