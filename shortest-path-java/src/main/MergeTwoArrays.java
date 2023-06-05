package main;

public class MergeTwoArrays {

	public static void main(String[] args) {
//		LinkedList<Integer> l1 = new LinkedList<>();
//		LinkedList<Integer> l2 = new LinkedList<>();
//		mergeTwoLists(l1, l2);
		ListNode c1 = new ListNode(5);
		ListNode c2 = new ListNode(7);
		c1.next = c2;
		ListNode c3 = new ListNode(8);
		c2.next = c3;
		ListNode c4 = new ListNode(11);
		c3.next = c4;
		ListNode c5 = new ListNode(11);
		c4.next = c5;
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(7);
		b1.next = b2;
		ListNode b3 = new ListNode(9);
		b2.next = b3;
		ListNode b4 = new ListNode(10);
		b3.next = b4;
		ListNode b5 = new ListNode(11);
		b4.next = b5;
		
		ListNode  res = mergeTwo(b1, c1);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static ListNode mergeTwo(ListNode list1, ListNode list2) {

		ListNode head = new ListNode();
		ListNode tmp = head;
		do{
			if(list2 != null && list1 == null) {
				tmp.val = list2.val;
				list2 = list2.next;
			} else if(list1 != null && list2 == null) {
				tmp.val = list1.val;
				list1 = list1.next;
			} else if(list1.val <= list2.val) {
				tmp.val = list1.val;
				list1 = list1.next;
			} else if(list2.val <= list1.val) {
				tmp.val = list2.val;
				list2 = list2.next;
			}
			if(list1 != null || list2 != null) {
				tmp.next = new ListNode();
				tmp = tmp.next;
			}
		} while(list1 != null || list2 != null);
		
		
		return head;
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

