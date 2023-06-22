package main.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Task1 {

	public static void main(String[] args) {
        Map<String, UserStats> visits = new HashMap<>();

        // Create UserStats objects
        UserStats user1Stats = new UserStats();
        user1Stats.setVisitCount(Optional.of(5L));

        UserStats user2Stats = new UserStats();
        user2Stats.setVisitCount(Optional.of(10L));
        
        UserStats user3Stats = new UserStats();
        user3Stats.setVisitCount(Optional.empty());
        
//        UserStats user4Stats = null;

        // Insert values into the map
        visits.put("1", user1Stats);
        visits.put("2", user2Stats);
        visits.put("3", user3Stats);
//        visits.put("4", user4Stats);
        
        VisitCounter visitCounter = new VisitCounter();
        Map<Long, Long> result = visitCounter.count(visits);
    	for (Map.Entry<Long, Long> entry : result.entrySet()) {

            Long key = entry.getKey();
            Long value = entry.getValue();
            System.out.println("Key: " + key + " Value:" + value);

    	}
		System.out.println("Hello");
	}

}
