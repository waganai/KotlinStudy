package collection;

import java.util.HashMap;

public class HashMapTestMain {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "value");
        hashMap.put("key", null);

        System.out.println("hashMap.get(null) = " + hashMap.get(null));
        System.out.println("hashMap.get(value) = " + hashMap.get("value"));

        hashMap.remove(null);
    }
}
