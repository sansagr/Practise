package org.example.ratelimitingalgos;

public class TokenBucket {
    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    TokenBucket(long maxBucketSize, long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        currentBucketSize = maxBucketSize;
        lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens){
        refill();

        if (currentBucketSize > tokens){
            currentBucketSize --;
            return true;
        }
        return false;

    }

    public void refill(){
        long now = System.nanoTime();
        double tokenToAdd = (now - lastRefillTimestamp) * refillRate / 1e9;
        currentBucketSize = Math.min(currentBucketSize + tokenToAdd, maxBucketSize);
        lastRefillTimestamp = now;
    }
}
