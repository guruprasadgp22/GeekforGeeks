/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public void rearrangeEvenOdd(Node head) {
        // code here
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        
        while(odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        
        odd.next = evenHead;
    }
}