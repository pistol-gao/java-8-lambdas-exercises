package com.insightfullogic.java8.answers.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Q:找出名字最长的艺术家，分别使用收集器和第3 章介绍过的reduce 高阶函数实现。然后对比二者的异同：哪一种方式写起来更简单，哪一种方式读起来更简单
 */
public class LongestName {

    private static Comparator<Artist> byNameLength = comparing(artist -> artist.getName().length());

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                // auto implements BinaryOperator method R apply(T t, U u) ;
                .reduce((acc, artist) -> {
                    return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
                }).orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                // collect receive Collector
                .collect(Collectors.maxBy(byNameLength)).orElseThrow(RuntimeException::new);
    }

}
