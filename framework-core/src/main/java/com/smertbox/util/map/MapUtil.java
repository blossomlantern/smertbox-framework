package com.smertbox.util.map;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {

	public static Map<String, List<?>> sortByKeyASC(Map<String, List<?>> original) {
		if (original == null || original.isEmpty()) {
			return null;
		}
		Map<String, List<?>> sortedMap = new TreeMap<String, List<?>>(new Comparator<String>() {
			public int compare(String key1, String key2) {
				return key2.compareTo(key1);
			}
		});
		sortedMap.putAll(original);
		return sortedMap;
	}

}
