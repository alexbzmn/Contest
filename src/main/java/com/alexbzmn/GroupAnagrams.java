package com.alexbzmn;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> g = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }

            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String res = new String(c);
            if (g.containsKey(res)) {
                g.get(res).add(strs[i]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                g.put(res, list);
            }
        }

        return new ArrayList<>(g.values());
    }
}
