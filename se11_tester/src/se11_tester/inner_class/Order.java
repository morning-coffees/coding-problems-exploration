package se11_tester.inner_class;

import java.util.HashSet;
import java.util.Set;

// class inside a class
public class Order<T> {
	
	private Set<Item> items = new HashSet<>();
	public void addItem(String name, Integer quantity) {
		Item item = new Item(name, quantity);
		items.add(item); 
	}
	
	public Set<Item> getItems() {
		return items;
	}
	
	private void privateUpper() {
		
	}
	
	public void toOverride(String name) {
		
	}
	
	public void lambda(T name, FunctionalSample fs) {
		fs.move(name);
	}
	
	class Item {
		private String name;
		private Integer quantity;
		
		private Item(String name, Integer quantity) {
			this.name = name;
			this.quantity = quantity;
		}
		// class inside a method
		private void something() {			
			class InsideMethodClass {
				public void something() {
					items.add(new Item("name3", 1));
					privateUpper();
				}
			}			

			InsideMethodClass im = new InsideMethodClass();
			im.something();
		}
	}

}
