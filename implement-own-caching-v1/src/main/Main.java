package main;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static TimeProvider timeProvider = new TimeProvider();
    
	public static void main(String[] args) throws Exception {
		CachingDataStructure cash = new CachingDataStructure(timeProvider, 10);

		cash.put("k1", "val1", 5000);
		cash.put("k2", "val2", 1000);
		cash.put("k3", "val3", 2000);
		cash.put("k4", "val4", 3000);
		cash.put("k5", "val5", 4000);
		cash.put("k6", "val6", 5000);
		cash.put("k7", "val7", 6000);
		cash.put("k8", "val8", 7000);
		cash.put("k9", "val9", 8000);
		cash.put("k10", "val0", 9000);
		cash.put("k11", "val1", 200);
		cash.put("k12", "val2", 200);
		cash.put("k1", "valiii", 4000);
//		Thread.sleep(50);
		System.out.println(cash.get("k11").isPresent());
		System.out.println(cash.get("k1").get());
		System.out.println(cash.size());
	
		
//		cash.put("k1", "val1", 1);
//		Thread.sleep(50);
//		System.out.println(cash.get("k1").isPresent());
//		System.out.println(cash.size()); // 0
//		cash.put("k2", "val2", 5000);
//		System.out.println(cash.size()); // 1
////		Thread.sleep(5001);
//		System.out.println(cash.size()); // 0
//		cash.put("k3", "val1", 4000);
//		cash.put("k4", "val2", 5000);
//		cash.put("k5", "val3", 2000);
////		Thread.sleep(2000);
//		System.out.println(cash.size()); // 2
		
//		System.out.println(timeProvider.getMillis());
//		Date currentDate = new Date();
//		
//		// Getting the time in milliseconds.
//		long milliSeconds = currentDate.getTime();
//		
//		// printing the values
//		System.out.println("Current date : "+currentDate);
//		System.out.println("Current date time in milliseconds : "+milliSeconds);

//	    Queue<Map.Entry<Long, String>> elements = new PriorityQueue<>(Map.Entry.comparingByKey());
//	    elements.add(Map.entry(5l, "val1"));
//	    elements.add(Map.entry(9l, "val3"));
//	    elements.add(Map.entry(7l, "val2"));
//	    elements.add(Map.entry(10l, "val2"));
//
//	    while(!elements.isEmpty()) {
//	    	Map.Entry<Long, String> entry = elements.peek();
//	    	if (entry.getKey() <= 5) {
//	    		elements.poll();
//	    	} else {
//	    		break;
//	    	}
//	    }
//	    while(!elements.isEmpty()) {
//	    	Entry entry = elements.poll();
//			System.out.println(entry.getValue() + " - " + entry.getKey());
//	    }
	    
	}

}

interface TimeProviderI {
//	final Date dateObj = new Date();
//    default long getMillis() {
//		return dateObj.getTime();
//    }
  long getMillis();
}


class TimeProvider implements TimeProviderI {

	@Override
	public long getMillis() {
		final Date dateObj = new Date();
		return dateObj.getTime();
	}
}

class CachingDataStructure {

    private int maxSize;
    private TimeProvider timeProvider;
    private Map<String, String> elements = new HashMap<>();
    private Queue<Entry<String, Long>> keyTtl = new PriorityQueue<>(Map.Entry.comparingByValue());

    CachingDataStructure(TimeProvider timeProvider, int maxSize) {
        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
        
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
    	if(key == null || value == null || isBlank(key) || isBlank(value) || timeToLeaveInMilliseconds <= 0) {
    		throw new IllegalArgumentException("Invalid input for key/value/ttl");
    	}
    	
    	clearExpired();
    	long ttl = timeProvider.getMillis() + timeToLeaveInMilliseconds;
    	Entry<String, Long> lowestTtlEntry = keyTtl.peek();
    	
    	if(elements.containsKey(key)) {
    		Entry<String, Long> entry = getKeyTtl(key);
			if(entry != null && key.equals(entry.getKey()) && ttl < entry.getValue()) {
				elements.put(key, value);
				keyTtl.remove(entry);
				keyTtl.add(new AbstractMap.SimpleImmutableEntry<>(key, ttl));
			} else if (entry != null && key.equals(entry.getKey())){
				elements.put(key, value);
			}
    	} else if(lowestTtlEntry == null || (elements.size() < maxSize && ttl > lowestTtlEntry.getValue())) {
        	elements.put(key, value);
        	keyTtl.add(new AbstractMap.SimpleImmutableEntry<>(key, ttl));
    	} else if (elements.size() == maxSize) {
    		Entry<String, Long> keyTtlEntry = keyTtl.peek();
	    	if (keyTtlEntry.getValue() < ttl) {
	    		elements.remove(keyTtlEntry.getKey());
	    		keyTtl.poll();
	        	elements.put(key, value);
	        	keyTtl.add(new AbstractMap.SimpleImmutableEntry<>(key, ttl));
	    	}
    	}
    }

    public Optional<String> get(String key) {
    	clearExpired();
    	return Optional.ofNullable(elements.get(key));
    }

    public int size() {
    	clearExpired();
    	return elements.size();
    }
    
    /**
     * Use priority queue, get all expired TTL (loop TTL from low to high)
     * Remove data from keyTtl and keyValueStore if expired
     * Basically we have a separate list to track the TTL and another list for simple get and update value
     */
    private void clearExpired() {
    	long currentTimeMilis = timeProvider.getMillis();
    	while(!keyTtl.isEmpty()) {
	    	Entry<String, Long> keyTtlEntry = keyTtl.peek();
	    	if (keyTtlEntry.getValue() <= currentTimeMilis) {
	    		elements.remove(keyTtlEntry.getKey());
	    		keyTtl.poll();
	    	} else {
	    		break;
	    	}
	    }
    }
    
    /**
     * Replacement for str.isBlank since I built the code on java 11 but found out it should be on 8
     * @param str
     * @return
     */
    private boolean isBlank(String str) {
    	return str == null || str.trim().length() == 0;
    }
    
    private Entry<String, Long> getKeyTtl(String key) {
    	
    	for (Entry<String, Long> entry : keyTtl) {
			if (key.equals(entry.getKey())){
				return entry;
			}
		}
    	return null;
    }
}
