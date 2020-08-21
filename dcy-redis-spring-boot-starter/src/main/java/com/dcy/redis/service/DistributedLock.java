package com.dcy.redis.service;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2019/9/6 11:13
 */
public interface DistributedLock {

    /**
     * 获取锁：使用默认超时时间设置锁 默认时间30s
     *
     * @param lockKey 锁名字
     * @return
     */
    RLock lock(String lockKey);


    /**
     * 获取锁：为锁设置超时时间
     *
     * @param lockKey   锁名字
     * @param leaseTime 锁自动失效时间 单位:秒
     * @return
     */
    RLock lock(String lockKey, int leaseTime);


    /**
     * 获取锁：为锁设置超时时间
     *
     * @param lockKey   锁名字
     * @param unit      时间单位
     * @param leaseTime 锁自动失效时间
     * @return
     */
    RLock lock(String lockKey, TimeUnit unit, int leaseTime);

    /**
     * 尝试获取锁，在等待时间内获取到锁则返回true,否则返回false,如果获取到锁，在指定超时时间释放锁
     *
     * @param lockKey   锁名字
     * @param waitTime  等到最大时间，强制获取锁
     * @param leaseTime 锁自动失效时间
     * @return
     */
    boolean tryLock(String lockKey, int waitTime, int leaseTime);

    /**
     * 尝试获取锁，在等待时间内获取到锁则返回true,否则返回false,如果获取到锁，在指定超时时间释放锁
     *
     * @param lockKey   锁名字
     * @param unit      时间单位
     * @param waitTime  等到最大时间，强制获取锁
     * @param leaseTime 锁自动失效时间
     * @return
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    /**
     * 释放锁
     *
     * @param lockKey 锁名字
     */
    void unLock(String lockKey);


    /**
     * 释放锁
     *
     * @param lock 锁对象
     */
    void unLock(RLock lock);


}
