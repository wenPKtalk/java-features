package com.seventeen.feature;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ForkJoinValidation {

    static ThreadLocal<String> localCache = new ThreadLocal<>();
    private List<String> strings;

    class ThreadOne implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1 * 1000);
                    List<String> collect = strings.parallelStream()
                            .map((s) -> {
                                try {
                                    Thread.sleep(2 * 100);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                localCache.set(s);
                                System.out.println("+++++++  :"+s);
                                return s + Thread.currentThread()
                                        .getName();
                            })
                            .toList();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class ThreadTwo implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1 * 1000);
                    List<CompletableFuture<String>> completableFutureStream = strings.stream()
                            .map((s) -> {
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                return CompletableFuture.supplyAsync(() -> {
                                                    String local = localCache.get();
                                                    System.out.println("------------" + local);
                                                    return local;
                                                }
                                        );
                                    }
                            )
                            .toList();
                    List<String> collect = completableFutureStream.stream()
                            .map(CompletableFuture::join)
                            .toList();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void execute() {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }


    public static void main(String[] args) {
        ForkJoinValidation test = new ForkJoinValidation();
        ArrayList<String> objects = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            objects.add(String.valueOf(i));
        }
        test.strings = objects;
        test.execute();
    }
}
