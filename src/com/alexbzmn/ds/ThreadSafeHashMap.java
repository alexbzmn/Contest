package com.alexbzmn.ds;

import java.util.Random;
import java.util.UUID;

public class ThreadSafeHashMap {

    private class Entry {
        private Integer key;
        private String value;
        private Entry next;

        private Entry(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    private Entry[] buckets = new Entry[4];
    private int size;


    private void put(Integer key, String value) {
        int hash = calculateHash(key.hashCode());

        Entry newEntry = new Entry(key, value);

        if (buckets[hash] == null) {
            buckets[hash] = newEntry;
        } else {
            Entry rootNode = buckets[hash];
            while (rootNode.next != null) {
                rootNode = rootNode.next;
            }

            rootNode.next = newEntry;
        }

        size++;
    }


    private int calculateHash(int hash) {
        return Math.abs(hash % buckets.length);
    }

    public static void main(String[] args) {
        final ThreadSafeHashMap map = new ThreadSafeHashMap();
        Runnable task = () -> {

            synchronized (map) {
                int size = map.size;

                Integer key = new Random().nextInt(100);
                String value = UUID.randomUUID().toString();

                map.put(key, value);


                if (size + 1 != map.size) {
                    System.out.println("Assertion Failed " + key);
                } else {
                    System.out.println("Add key=" + key + ", value=" + value);
                }
            }


        };

        for (int i = 0; i < 100; i++) {
            new Thread(task).start();
        }

    }
}
