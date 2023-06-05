package com.toyrobot.blueprints.implementations;

import java.util.HashMap;
import java.util.Map;

import com.toyrobot.Coordinate;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.Table;

public class TableImpl implements Table {
	
	private int yLength;
	private int xLength;
	private Map<String, Robot> tableSlots = new HashMap<>();
	
	public TableImpl(int xLength, int yLength) {
		this.xLength = xLength;
		this.yLength = yLength;
		
		setEmptyTable();
	}
	
	@Override
	public void setEmptyTable() {
		for(Integer y = yLength; y >= 0; y--) {
			for(Integer x = 0; x <= xLength; x++) {
				tableSlots.put(getTableKey(x, y), null);
			}
		}
	}

	public boolean isValidLocation(Integer x, Integer y) {
		Robot value = tableSlots.get(getTableKey(x, y));
		return x <= xLength && y <= yLength && x >= 0 && y >= 0 && value == null;
	}
	
	@Override
	public boolean setOccupant(Coordinate location, Robot occupant) {
		int x = location.getX();
		int y = location.getY();
		boolean success = false;
		if(isValidLocation(x, y)) {
			Robot value = tableSlots.get(getTableKey(x, y));
			if(value == null) {
				tableSlots.put(getTableKey(x, y), occupant);
				success = true;
			}
		}
		return success;
	}

	@Override
	public void removeOccupant(Integer x, Integer y) {
		tableSlots.remove(getTableKey(x, y));
	}
	
	@Override
	public void printTable() {
		StringBuilder header = new StringBuilder();
		for(Integer x = 0; x <= xLength; x++ ) {
			header.append("\t").append(x.toString());
		}

		for(Integer y = yLength; y >= 0; y--) {
			StringBuilder rowOutput = new StringBuilder();
			rowOutput.append(y.toString());
			for(Integer x = 0; x <= xLength; x++) {
				Robot value = tableSlots.get(getTableKey(x, y));
				if(value != null) {
					rowOutput.append("\t").append(value.getName());					
				} else {
					rowOutput.append("\t").append(".");
				}
			}
			System.out.println(rowOutput.toString());
		}
		System.out.println(header.toString());
	}
	
	private String getTableKey(Integer x, Integer y) {
		return new StringBuilder().append(x).append("-").append(y).toString();
	}

	@Override
	public int getyLength() {
		return yLength;
	}

	@Override
	public int getxLength() {
		return xLength;
	}

	@Override
	public Map<String, Robot> getTableSlots() {
		return tableSlots;
	}

	@Override
	public int getRobotCountInTable() {
		int count = 0;
		for (Object value : tableSlots.values()) {
		    if(value != null) {
		    	count++;
		    }
		}
		return count;
	}
}