package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @Author pan
 * @Date 2020/4/26 14:09
 * @Description
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        ExecutorService s1 = Executors.newSingleThreadExecutor();
//        ExecutorService s2 = Executors.newCachedThreadPool();
//        Executors.defaultThreadFactory();
//        RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy(); //拒绝策略
//        Runtime.getRuntime().availableProcessors();
//        final  ReentrantLock reentrantLock = new ReentrantLock();
//        Condition condition = reentrantLock.newCondition();
//
//        new Thread(() -> {
//            try {
//                reentrantLock.lock();
//                condition.signalAll();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                reentrantLock.unlock();
//            }
//        });

    }
}
