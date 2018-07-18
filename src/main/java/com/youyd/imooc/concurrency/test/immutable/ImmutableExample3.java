package com.youyd.imooc.concurrency.test.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class ImmutableExample3 {
	public static ImmutableList<Integer> list=ImmutableList.of(1,2,3);
	
	public static ImmutableSet set=ImmutableSet.copyOf(list);
	
	public static ImmutableMap<Integer,Integer> map=ImmutableMap.of(1,2,3,4,5,6);
	public static ImmutableMap<Integer,Integer> map2=ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).put(5, 6).build();
	
	public static void main(String[] args) {
		map.put(1,2);
	}
}
