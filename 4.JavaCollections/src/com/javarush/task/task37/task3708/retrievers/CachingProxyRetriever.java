package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache lruCache = new LRUCache(100);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object retrieved = lruCache.find(id);
        if (retrieved == null) {
            retrieved = originalRetriever.retrieve(id);
            lruCache.set(id, retrieved);
        }
        return retrieved;
    }
}
