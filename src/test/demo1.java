package test;

import java.util.HashMap;

/**
 * @description：TODO
 */
public class demo1 {
    static HashMap<Integer,Integer> mp = new HashMap<>();
    static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for(int i = 1; i <= 10000; i ++) {
                synchronized (lock) {
                    for (int j = 1; j <= 100; j++) {
                        mp.put(i, mp.getOrDefault(i, 0) + 1);
                    }
                }
            }
        }).start();

        new Thread(()->{
            for(int i = 1; i <= 10000; i ++) {
                synchronized (lock) {
                    for(int j = 1; j <= 100; j ++) {
                        mp.put(i, mp.getOrDefault(i, 0) + 1);
                    }
                }

            }
        }).start();
        Thread.sleep(2000); // 防止主线程直接输出
        for(int i = 1; i <= 30; i ++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 1; i <= 30; i ++) {
            System.out.print(mp.getOrDefault(i, 0) + " ");
        }

        for(int i = 1; i <= 10000; i ++) {
            if(mp.getOrDefault(i, 0) != 200) {
                System.out.println(i);
            }
        }
    }

}
