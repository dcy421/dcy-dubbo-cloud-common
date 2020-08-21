package com.dcy.redis.service.impl;

import com.dcy.redis.service.DistributedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2019/9/6 11:14
 */
@Service
public class DistributedLockImpl implements DistributedLock {
    /**
     * 锁前缀
     */
    private static final String LOCK_TITLE = "redis_lock_";

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        lock.lock();
        return lock;
    }

    @Override
    public RLock lock(String lockKey, int leaseTime) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return lock;
    }

    @Override
    public RLock lock(String lockKey, TimeUnit unit, int leaseTime) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        lock.lock(leaseTime, unit);
        return null;
    }

    @Override
    public boolean tryLock(String lockKey, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public void unLock(String lockKey) {
        RLock lock = redissonClient.getLock(LOCK_TITLE + lockKey);
        lock.unlock();
    }

    @Override
    public void unLock(RLock lock) {
        lock.unlock();
    }
}
