package s11_tester;

import se11_tester.inner_class.FunctionalSample;
import se11_tester.inner_class.Order;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ClonableTester ct = new ClonableTester();
//		
//		System.out.println(ct.clone());
		
//		CoontinueLabel.run();
		Order order = new Order();
		order.addItem("name", 1);
		order.addItem("name2", 3);
		
		Order order2 = new Order() {
			@Override
			public void toOverride(String n) {
				System.out.println("hello " + n);
			}
		};
		
		order2.toOverride("Chris");
		
		
		order2.lambda("Chris P Bacon", (p) -> System.out.println("Hello " + p));
		
		
		FunctionalSample<String> fs = (name) -> System.out.println("Hi " + name); 
		fs.move("John");
		

		FunctionalSample<String> fs2 = System.out::println; 
		fs.move("Printing Johnny");
	}

}


