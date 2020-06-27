package com.ppyuan.club.notice;

public class ThreadLocalMTest {

    private  static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {

            return Integer.valueOf(2000);
        }
    };

    private  static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {

            return Integer.valueOf(3000);
        }
    };

    public static void main(String[] args)  {






    }




}
