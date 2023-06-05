package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SoldierArmyRank {

	public static void main(String[] args) {
		int[] ranks = {1,1,2,2,3,3,1000000001};
		Map<Integer, Integer> soldiers = new HashMap<>();
		int totalCount = 0;

		if (ranks != null && ranks.length >= 2) {
			for (int i = 0; i < ranks.length; i++) {
				if(ranks[i] > 1000000000) {
					throw new IllegalArgumentException("Invalid Soldier Rank!");
				}
				Integer soldierCount = soldiers.get(ranks[i]);
				if (soldierCount == null) {
					soldiers.put(ranks[i], 1);
				} else {
					soldiers.put(ranks[i], soldierCount + 1);
				}
			}
			for (Entry<Integer, Integer> entry : soldiers.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();

				int higherRankKey = key + 1;
				Integer higherRank = soldiers.get(higherRankKey);
				if (higherRank != null) {
					totalCount += value;
				}
			}
		}
		System.out.println(soldiers.toString());
		System.out.println(totalCount);
	}

}
