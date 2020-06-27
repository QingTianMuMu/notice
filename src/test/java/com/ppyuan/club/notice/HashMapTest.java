package com.ppyuan.club.notice;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i < 10; i++) {
            String name = "a" + i;
            map.put(new Apple(name),"ab");
        }
        map.put(new Apple("aa"),"aa");
    }


    public static class Apple{
        private String name;

        public Apple(String name){
            this.name = name;
        }

        @Override
        public int hashCode(){
            return 111111111;
        };
    }
}
