package topic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class A381_RandomizedCollection {

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        System.out.println(randomizedCollection.getRandom());
        randomizedCollection.remove(1);
        System.out.println(randomizedCollection.getRandom());
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static class RandomizedCollection {

        static final String SEPARATOR = "/";

        // O（1）的查找，几乎只有hashMap了
        Map<String, Integer> map;
        // 提供随机查询
        Random rand;
        int size;
        boolean needNewTable;
        Map.Entry[] table;

        public RandomizedCollection() {
            map = new HashMap<>();
            rand = new Random();
            size = 0;
            needNewTable = false;
            table = new Map.Entry[0];
        }

        private void addNum(int val){
            String key = String.valueOf(val);
            int cur = map.getOrDefault(key, 0);
            cur ++;
            map.put(key, cur);
            if(cur > 1){
                String speKey = key + SEPARATOR + cur;
                map.put(speKey, 1);
            }

            size ++;
        }

        private void decriNum(int val){
            String key = String.valueOf(val);
            int cur = map.get(key);
            if(cur == 1){
                map.remove(key);
            } else {
                map.remove(key + SEPARATOR + cur);
                map.put(key, cur - 1);
            }
            size --;
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res = false;
            if(!map.containsKey(String.valueOf(val))){
                res = true;
            }

            addNum(val);
            needNewTable = true;
            return res;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(String.valueOf(val))){
                return false;
            }

            decriNum(val);
            needNewTable = true;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            if(size == 0){
                return 0;
            }

            if(needNewTable){
                table =  map.entrySet().toArray(table);
                needNewTable = false;
            }
            int index = rand.nextInt(size);
            HashMap.Entry<String, Integer> entry = table[index];
            String key = entry.getKey();
            if(key.indexOf(SEPARATOR) < 0){
                return Integer.valueOf(key);
            }

            return Integer.valueOf(key.split(SEPARATOR)[0]);
        }


    }
}
