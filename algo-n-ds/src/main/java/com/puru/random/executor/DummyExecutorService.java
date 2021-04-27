package com.puru.random.executor;

import java.util.Collection;
import java.util.concurrent.*;

public interface DummyExecutorService extends DummyExecutor {

        void shutdown();

        boolean isShutdown();

        boolean isTerminated();

        boolean awaitTermination(long timeout, TimeUnit unit)
                throws InterruptedException;

        <T> Future<T> submit(Callable<T> task);

        Future<?> submit(Runnable task);

        <T> T invokeAny(Collection<? extends Callable<T>> tasks)
                throws InterruptedException, ExecutionException;

        <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                        long timeout, TimeUnit unit)
                throws InterruptedException, ExecutionException, TimeoutException;
}
