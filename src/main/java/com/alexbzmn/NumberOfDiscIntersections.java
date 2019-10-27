package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int j = A.length - 1 - i;

            map.put(i, A[i]);
            map.put(j, A[j]);

            Map<Integer, Integer> newMap = new HashMap<>();
            boolean change = false;
            for (Integer key : map.keySet()) {
                if (key != i && key != j && map.containsKey(key)) {
                    int residual = map.get(key) - 1;
                    if (residual != 0) {
                        newMap.put(key, residual);
                        change = true;
                    }
                    sum++;
                }
            }

            if (change) {
                map = newMap;
            }
        }

        return sum;
    }
}
