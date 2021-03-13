package collection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTestMain {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "1");
        concurrentHashMap.remove("1");
    }
}
