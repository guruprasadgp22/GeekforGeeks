/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        int count = 0;
        Node curr = head;
        
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        
        int mid = count/2;
        curr = head;
        
        if(mid == 0) {
            return null;
        }
        
        Node prev = curr;
        count = 0;
        
        while(count < mid) {
            count++;
            prev = curr;
            curr = curr.next;
        }
        
        if(curr.next == null) {
            prev.next = null;
        } else {
            prev.next = curr.next;
        }
        
        return head;
    }
}