package cn.chenhuanming.leet.code;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenhuanming
 * Created at 2018/12/27
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Unsafe.getUnsafe().compareAndSwapInt(new Object(),1,0,1);
    }

}

