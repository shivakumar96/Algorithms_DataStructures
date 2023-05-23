package com.shivakumar.algorithms.leetcode;

// Perform insertion sort on linked list defined as follows;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
  }


public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode nextnode, current , tempHead, dummyhead;
        dummyhead = new ListNode();
        current = head;

        while(current != null){
            tempHead =  dummyhead;
            while(tempHead.next != null && tempHead.next.val <= current.val) tempHead = tempHead.next;

            nextnode = current.next;

            current.next = tempHead.next;
            tempHead.next = current ;

            current = nextnode;

        }

        return dummyhead.next;

    }

}
