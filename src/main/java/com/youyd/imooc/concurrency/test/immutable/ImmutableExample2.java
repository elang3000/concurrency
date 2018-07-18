package com.youyd.imooc.concurrency.test.immutable;

import java.util.Collections;
import java.util.Map;

import com.google.common.collect.Maps;

public class ImmutableExample2 {

    private static Map<Integer,Integer> map=Maps.newHashMap();
    
    static {
    	map.put(1, 2);
    	map.put(3, 4);
    	map.put(5, 6);
    	map=Collections.unmodifiableMap(map);
    }
    
    
    public static void main(String[] args) {
//    	a=2;
//    	b="3";
//    	map=Maps.newHashMap();
    	map.put(1, 3);
	}
    
    
    private void test(final int a) {
//    	a=1;
    }

}
