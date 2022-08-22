package com.example.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author PYB
 * @Date 2022/8/9 21:46
 * @Version 1.0
 */
public class Test {
//    @org.junit.jupiter.api.Test
//    public void test1(){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime plus = localDateTime.plus(1, ChronoUnit.MICROS);
////        localDateTime.with(TemporalAdjusters.)
//        LocalDateTime plus1 = localDateTime.with(T);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = dateTimeFormatter.format(localDateTime);
//        System.out.println(dateTimeFormatter.format(plus));
//        System.out.println(dateTimeFormatter.format(plus1));
//        System.out.println(
//                format
//        );
//    }
    @org.junit.jupiter.api.Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        AtomicInteger atomicInteger = new AtomicInteger(500);
        ReentrantLock lock = new ReentrantLock();
        for (int i= 0;i<250;i++){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                atomicInteger.incrementAndGet();
                lock.unlock();
            }
        });
        }
        for (int i= 0;i<250;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    atomicInteger.decrementAndGet();
                    lock.unlock();
                }
            });
        }
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0;i<5;i++) {
            Future<?> submit = executorService.submit(new Callable<Object>() {

                @Override
                public Integer call() throws Exception {

                    return atomicInteger.get();
                }
            });
            futures.add(submit);
        }


        ExecutorService executorService2 = Executors.newFixedThreadPool(4);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService4 = Executors.newScheduledThreadPool(5);

//        Object o = submit.get();
//        System.out.println(o);

        System.out.println(atomicInteger.toString());
    }
    @org.junit.jupiter.api.Test
    public void test4(){
        Integer i =0;

        Unsafe U = getaVoid();
        U.compareAndSwapInt(i,12l,i,3);
        System.out.println(i);

    }
    @org.junit.jupiter.api.Test
    public void test3(){
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        Integer i =0;

        Unsafe U = getaVoid();
        long aoffset = 0l;
        try {
             aoffset = U.objectFieldOffset(Integer.class.getDeclaredField("value"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(aoffset);

        boolean b = U.compareAndSwapInt(i, 12l, i, 2);
        System.out.println(i);

        for (int j = 0;j<250 ;j++) {
            executorService.execute(()->{
                Integer integer =i+1;
                U.compareAndSwapInt(i,12l,i,integer);
                System.out.println();
            });
        }
        for (int j = 0;j<250 ;j++) {
            executorService.execute(()->{
                Integer integer =i-1;
                U.compareAndSwapInt(i,12l,i,integer);
                System.out.println();
            });
        }
        System.out.println(i);
        try {
            executorService.awaitTermination(5,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Unsafe getaVoid() {
//        BlockingQueue<Object> objects = new BlockingQueue<>();
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
