package com.yyl.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/7/29.
 */
public class Lock {
    static ReentrantLock lock=new ReentrantLock(true);

    public static void main(String[] args){
        try {
            Condition condition=lock.newCondition();
            lock.tryLock(5000, TimeUnit.MILLISECONDS);
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
