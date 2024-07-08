package com.flight.core.repository;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import com.flight.common.exception.LockAcquisitionFailException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class RedisLockManager {

	private final RedissonClient redissonClient;

	public <T> T executeWithLock(String lockKey, long waitTime, long leaseTime, TimeUnit timeUnit, LockCallback<T> callback) throws LockAcquisitionFailException {
		RLock lock = redissonClient.getLock(lockKey);
		try {
			if (lock.tryLock(waitTime, leaseTime, timeUnit)) {
				return callback.doWithLock();
			} else {
				throw new LockAcquisitionFailException(lockKey);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new LockAcquisitionFailException(lockKey);
		} finally {
			if (lock.isLocked()) {
				lock.unlock();
			}
		}
	}

	@FunctionalInterface
	public interface LockCallback<T> {
		T doWithLock();
	}
}
