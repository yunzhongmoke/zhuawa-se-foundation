package com.w.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author blue
 * @version 1.0
 */
public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "q");
        map.put("2", "w");
        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object obj : set) {
            //System.out.println(obj.getClass());
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey());
        }

        Set set1 = map.keySet();

        Collection values = map.values();
        System.out.println(map.get("1"));
    }
}
