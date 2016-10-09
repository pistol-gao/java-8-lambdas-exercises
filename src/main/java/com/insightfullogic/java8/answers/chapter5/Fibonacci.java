package com.insightfullogic.java8.answers.chapter5;

import java.util.HashMap;
import java.util.Map;

/*
 * Q:使用Map 的computeIfAbsent 方法高效计算斐波那契数列。这里的“高效”是指避免将那些较小的序列重复计算多次。
 * note:by the way ,not a good practice,using too much space complexity.
 */
public class Fibonacci {

    private final Map<Integer, Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n - 1) + fibonacci(n - 2));
    }

}
