package com.amyliascarlet.demo.tokenbucket.config;

import com.amyliascarlet.demo.tokenbucket.constans.Constants;


public class Bucket {

    private final String name;
    private final int maxCount;

    private int size;
    private final int riseCount;

    public Bucket() {
        maxCount = Constants.CAPACITY;
        riseCount = Constants.RISE_COUNT;
        name = "bucket";
    }
    public Bucket(String name) {
        this.maxCount = Constants.CAPACITY;
        this.riseCount = Constants.RISE_COUNT;
        this.name = name;
    }
    public Bucket(String name, int maxCount, int riseCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.riseCount = riseCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Bucket bucket = (Bucket) obj;
        return bucket.size == size && bucket.riseCount == riseCount && bucket.maxCount == maxCount;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == maxCount;
    }

    public void genTokens() {
        for (int i = 0; i < riseCount; i++)
            genToken();
    }

    void genToken() {
        if (!isFull())
            size++;
    }

    public synchronized int getToken() {
        if (size > -1)
            size--;
        return size;
    }

}