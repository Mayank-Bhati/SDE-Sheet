package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointer {
    /*
    You are given a perfect binary tree where all leaves are on the same level,
    and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node out = connectIterate(root);
        Node temp = root;
        while(temp != null){
            System.out.println((temp.next == null)?null:temp.next.val);
            temp = temp.left;
        }
        while(root.right != null){
            System.out.println((root.right.next == null)?null:root.right.next.val);
            root = root.right;
        }
    }

    public static Node connectIterate(Node root) {
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0) {
                Node temp = q.poll();
                if (!q.isEmpty() && size > 0)
                    temp.next = q.peek();
                else
                    temp.next = null;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return root;
    }
        public static Node connectRec(Node root) {
        if(root == null)
            return root;
        else{
            helper(root.left,root.right);
            return root;
        }
    }
    static void helper(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return ;
        else{
            root1.next = root2;
            helper(root1.left,root1.right);
            helper(root1.right,root2.left);
            helper(root2.left,root2.right);
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
