package com.amyliascarlet.demo.tokenbucket.config;

import com.amyliascarlet.demo.tokenbucket.constans.Constants;

import java.util.HashMap;

public class BucketManager {
    private static final BucketManager instance = new BucketManager();

    public static volatile HashMap<String, Bucket> buckets = new HashMap(Constants.CAPACITY);

    public static BucketManager getInstance(){
        return instance;
    }

    public void genBucket(String name){
        Bucket bucket = new Bucket(name);
        buckets.put(name,bucket);
    }

    public synchronized HashMap<String, Bucket> getBuckets(){
        return buckets;
    }
    public synchronized Bucket getBucket(String name) throws BucketManagerException {
        if(buckets.containsKey(name)){
            return buckets.get(name);
        }
        throw new BucketManagerException("not contain key: "+ name);
    }

}
