package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        ListNode l = new ListNode(1);
        l.next = new ListNode(3);
        //  l.next.next = new LinkedList.ListNode(4);
//        head.next.next.next = new LinkedList.ListNode(4);
//        head.next.next.next.next = new LinkedList.ListNode(5);
//        LinkedList.ListNode out = reverseListRecurrsion(head);
//        LinkedList.ListNode out = reverseListIteratively(head);
//        while (out != null) {
//            System.out.println(out.val);
//            out = out.next;
//        }
//        System.out.println(middleNodeBruteForce(head).val);
//        LinkedList.ListNode out = mergeTwoListsInPlace(head,l);
        // LinkedList.ListNode out = removeNthFromEnd(head,2);
//        LinkedList.ListNode out = head;
//        deleteNode(head.next);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        Node out = copyRandomListEfficient(n1);
//        System.out.println(isPalindrome(l));
//        LinkedList.ListNode out = reverseKGroup(head,2);
        while(out != null) {
            System.out.print(out.val+" ");
            out = out.next;
        }
    }

    /*
    A linked list of length n is given such that each node contains an additional random pointer,
    which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list
such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, t
hen for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.
     */

    public static Node copyRandomListUsingMap(Node head) {
        Map<Node,Node> m = new HashMap<>();
        Node temp = head;
        while(temp != null){
            m.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node copy = m.get(temp);
            copy.next = m.get(temp.next);
            copy.random = m.get(temp.random);
            temp = temp.next;
        }
        return m.get(head);
    }

    public static Node copyRandomListEfficient(Node head) {
        if(head == null)
            return null;
        Node temp = head;
        while(temp != null){
            Node Next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = Next;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null && temp.next != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        Node out = new Node(0), first = head, second = head.next.next;
        out.next = first.next;
        while(second != null && second.next != null){
            first.next.next = second.next;
            first.next = second;
            first = second;
            second = second.next.next;
        }
        first.next = null;
        return out.next;
    }

    /*
    Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
     */
    Node flatten(Node root){
        if(root == null || root.next == null)
            return root;
        else
            return merge(root,flatten(root.next));
    }
    Node merge(Node root1, Node root2){
        Node res = new Node(0);
        Node temp = res;
        while(root1 != null && root2 != null){
            if(root1.val < root2.val){
                temp.bottom = root1;
                temp = temp.bottom;
                root1 = root1.bottom;
            }
            else{
                temp.bottom = root2;
                temp = temp.bottom;
                root2 = root2.bottom;
            }
        }
        if(root1 != null)
            temp.bottom = root1;
        else
            temp.bottom = root2;
        return res.bottom;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int l = length(head);
        k %= l;
        if (k == 0)
            return head;
        ListNode second = head, first = head;
        while (k >= 0) {
            second = second.next;
            k--;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        ListNode remain = first.next;
        first.next = null;
        ListNode temp = remain;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head;
        return remain;
    }


    public static ListNode detectCycle(ListNode head) {
        boolean cyclic = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cyclic = true;
                break;
            }
        }
        if (!cyclic)
            return null;
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseByRecurrsion(slow.next);
        if (secondHalf == null)
            return false;
        while (head != null && secondHalf != null) {
            if (head.val != secondHalf.val)
                return false;
            else {
                head = head.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }

    public static ListNode reverseByRecurrsion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode remain = reverseByRecurrsion(head.next);
        head.next = null;
        ListNode temp = remain;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return remain;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int c = 0;
        while (c < k - 1) {
            if (temp == null)
                return head;
            else {
                c++;
                temp = temp.next;
            }
        }
        if (temp == null)
            return head;
        ListNode remain = reverseKGroup(temp.next, k);
        temp.next = null;
        ListNode out = reverse(head);
        ListNode temp2 = out;
        while (temp2.next != null)
            temp2 = temp2.next;
        temp2.next = remain;
        return out;
    }

    public static ListNode reverse(ListNode head) {
        ListNode Prev = null, Curr = head, Next = null;
        while (Curr != null) {
            Next = Curr.next;
            Curr.next = Prev;
            Prev = Curr;
            Curr = Next;
        }
        return Prev;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /*
    Given the heads of two singly linked-lists headA and headB, return the node at
    which the two lists intersect.
    If the two linked lists have no intersection at all, return null
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA), l2 = length(headB);
        if (l1 > l2) {
            int d = l1 - l2;
            while (d != 0) {
                headA = headA.next;
                d--;
            }
        } else {
            int d = l2 - l1;
            while (d != 0) {
                headB = headB.next;
                d--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    static int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself
 */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode out = new ListNode(0);
        ListNode temp = out;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            temp.next = new ListNode(sum % 10);
            c = sum / 10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + c;
            temp.next = new ListNode(sum % 10);
            c = sum / 10;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + c;
            temp.next = new ListNode(sum % 10);
            c = sum / 10;
            temp = temp.next;
            l2 = l2.next;
        }
        if (c > 0)
            temp.next = new ListNode(c);
        return out.next;
    }

    /*
    Write a function to delete a node in a singly-linked list. You will not be
    given access to the head of the list, instead you will be given access to the node to be deleted directly.

    It is guaranteed that the node to be deleted is not a tail node in the list.
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head, s = head;
        int c = 0;
        while (c < n + 1) {
            if (s == null)
                return head.next;
            s = s.next;
            c++;
        }
        while (s != null) {
            f = f.next;
            s = s.next;
        }
        ListNode Next = f.next.next;
        f.next = Next;
        return head;
    }

    public static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null, curr = head, Next = null;
        while (curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    public static ListNode reverseListRecurrsion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode Next = reverseListRecurrsion(head.next);
        ListNode temp = Next;
        while (temp.next != null)
            temp = temp.next;
        head.next = null;
        temp.next = head;
        return Next;
    }

    public static ListNode middleNodeBruteForce(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        temp = head;
        int c = 0;
        int m = (l / 2) + 1;
        while (c < m) {
            c++;
            if (c == m)
                return temp;
            else
                temp = temp.next;
        }
        return temp;
    }

    public static ListNode middleNodeTwoPointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode out = null, same = null, other = null;
        if (l2.val < l1.val) {
            out = l2;
            same = l2.next;
            other = l1;
        } else {
            out = l1;
            same = l1.next;
            other = l2;
        }
        ListNode temp = out;
        while (same != null && other != null) {
            if (same.val < other.val) {
                temp.next = same;
                ListNode Next = same.next;
                if (same != null)
                    same.next = null;
                same = Next;
                temp = temp.next;
            } else {
                temp.next = other;
                ListNode Next = other.next;
                if (other != null)
                    other.next = null;
                other = Next;
                temp = temp.next;
            }
        }
        if (same != null) {
            temp.next = same;
            temp = temp.next;
        } else {
            temp.next = other;
        }
        return out;
    }

    public static ListNode mergeTwoListsUsingSpace(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode temp = out;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        return out.next;
    }

}

class ListNode {
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

class Node
{
    int val;
    Node next;
    Node bottom;
    Node random;

    Node(int d)
    {
        val = d;
        next = null;
        bottom = null;
    }
}


