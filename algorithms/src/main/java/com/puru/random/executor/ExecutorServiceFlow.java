package com.puru.random.executor;

import java.util.concurrent.*;

public class ExecutorServiceFlow {

    private ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Void> call = new Callable<Void>(){

            @Override
            public Void call() throws Exception {
                System.out.println("Purushottam");
                return null;
            }
        };

        Callable<Void> call2 = new Callable<Void>(){

            @Override
            public Void call() throws Exception {
                System.out.println("Purushottam");
                return null;
            }
        };
        ExecutorServiceFlow ser = new ExecutorServiceFlow();
        Future<Void> submit = ser.service.submit(call);
        Void unused = submit.get();
        ser.service.submit(call2);
    }



}
