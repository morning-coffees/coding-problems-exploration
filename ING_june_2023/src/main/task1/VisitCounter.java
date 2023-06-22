package main.task1;

import java.util.HashMap;
import java.util.Map;

public class VisitCounter {
	
    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> resultCount = new HashMap<>();
        
        if(visits == null || visits.length == 0) {
        	return resultCount;
        }
    	
        for (Map<String, UserStats> visit : visits) {
        	if(visit == null) {
        		continue;
        	}
        	for (Map.Entry<String, UserStats> entry : visit.entrySet()) {
        		try {

                    Long key = Long.parseLong(entry.getKey());
                    UserStats value = entry.getValue();
                    
                    if(value != null && value.getVisitCount().isPresent()) {
                    	Long currentCount = resultCount.getOrDefault(key, 0l) + value.getVisitCount().get();
                    	resultCount.put(key, currentCount);
                    }
//                    System.out.println("Key: " + key + " UserStats:" + value.getVisitCount() + ", Value: " + value);
				} catch (Exception e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
        	}
		}
        return resultCount;
    }
}
