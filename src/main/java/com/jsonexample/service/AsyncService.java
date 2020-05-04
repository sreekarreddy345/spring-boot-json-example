package com.jsonexample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.StampedLock;
@Service
public class AsyncService {

    @Async
    public void asyncMethod(){
   /*     StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.writeLock();
        stampedLock.unlock(stamp);

        long readStamp = stampedLock.readLock();
        stampedLock.unlock(readStamp);*/

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("This is from - " + Thread.currentThread().getName());
        }

    }
}

