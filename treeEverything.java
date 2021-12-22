import java.util.*;

public class treeEverything {
    public static void main(String[] args) {
       /* Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.right = new Node(8);
        levelTraverse(root);
        System.out.println("\n");
        Node out = insert(root,12);
        levelTraverse(out);*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //  root.left.right.right.right = new Node(6);
        //  root.left.right.right.right.right = new Node(7);


       /* System.out.println("LCA(4, 5) = " + LCA(root,4, 5).data);
        System.out.println("LCA(4, 6) = " + LCA(root,4, 6).data);
        System.out.println("LCA(3, 4) = " + LCA(root,3, 4).data);
        System.out.println("LCA(2, 4) = " + LCA(root,2, 4).data);*/
        //  System.out.println(height(root));
        //  System.out.println(diameter(root));
        //   leftVeiw(root);
        //  mirrorTree(root);
        //rightVeiw(root);
        // levelTraverse(root);
        // topVeiw(root);
            TopVeiwFromLeftToRight(root);
       // TopVeiw(root);
    }

    public static void levelTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static Node insert(Node root, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left == null) {
                temp.left = new Node(x);
                return root;
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(x);
                return root;
            } else
                q.add(temp.right);
        }
        return root;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int max_diameter = Math.max(diameter(root.left), diameter(root.right));
        return Math.max(max_diameter, 1 + height(root.left) + height(root.right));
    }

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node left_LCA = LCA(root.left, n1, n2);
        Node right_LCA = LCA(root.right, n1, n2);
        if (left_LCA != null && right_LCA != null)
            return root;
        return (left_LCA != null) ? left_LCA : right_LCA;
    }

    public static void leftVeiw(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.peek();
            if (temp != null) {
                System.out.print(temp.data + " ");
                while (q.peek() != null) {
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    q.poll();
                    temp = q.peek();
                }
                q.add(null);
            }
            q.poll();
        }
    }

    public static void rightVeiw(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        Node temp = root, next = null;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            if (temp == null) {
                q.poll();
                temp = next;
                next = q.peek();
                if (q.size() >= 1)
                    q.add(null);
            } else {
                if (next == null) {
                    System.out.print(temp.data + " ");
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    q.poll();
                    temp = next;
                    next = q.peek();
                } else {
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    q.poll();
                    temp = next;
                    next = q.peek();
                }
            }
        }
    }

    public static void topVeiw(Node root) {
        Map<Integer, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        root.hd = 0;
        while (!q.isEmpty()) {
            Node temp = q.peek();
            if (m.get(temp.hd) == null) {
                m.put(temp.hd, temp);

                System.out.println(temp.data + " ");
            }
            if (temp.left != null) {
                q.add(temp.left);
                temp.left.hd = temp.hd - 1;
            }
            if (temp.right != null) {
                q.add(temp.right);
                temp.right.hd = temp.hd + 1;
            }
            q.poll();
        }
    }

    public static void TopVeiwFromLeftToRight(Node root) {
        Map<Integer, Node> m = new TreeMap<>();
        recursive(root, m);

        for (Integer key : m.keySet()) {
            System.out.print(m.get(key).data + " ");
        }
    }
    public static void recursive(Node root, Map<Integer, Node> m){
        if(root!= null){
            if(m.get(root.hd)==null){
                m.put(root.hd, root);
            }
            if(root.left!=null){
                root.left.hd = root.hd -1;
                recursive(root.left, m);
            }
            if(root.right!=null){
                root.right.hd = root.hd+1;
                recursive(root.right, m);
            }
        }
    }

    public  static void iterative(Node root, Map<Integer, Node> m){
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        root.hd = 0;
        while (!q.isEmpty()) {
            Node temp = q.peek();
            if (m.get(temp.hd) == null) {
                m.put(temp.hd, temp);
            }
            if (temp.left != null) {
                q.add(temp.left);
                temp.left.hd = temp.hd - 1;
            }
            if (temp.right != null) {
                q.add(temp.right);
                temp.right.hd = temp.hd + 1;
            }
            q.poll();
        }
    }



    public static void bottomVeiw(Node root) {
        Map<Integer, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        root.hd = 0;
        while (!q.isEmpty()) {
            Node temp = q.peek();
            if (m.get(temp.hd) == null) {
                m.put(temp.hd, temp);
            } else {
                m.replace(temp.hd, temp);
            }
            if (temp.left != null) {
                q.add(temp.left);
                temp.left.hd = temp.hd - 1;
            }
            if (temp.right != null) {
                q.add(temp.right);
                temp.right.hd = temp.hd + 1;
            }
            q.poll();
        }
        for (Integer key : m.keySet()) {
            System.out.print(m.get(key).data + " ");
        }
    }

    public static void mirrorTree(Node root) {
        if (root == null)
            return;
        else {
            mirrorTree(root.left);
            mirrorTree(root.right);
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    static class Node {
        Node left, right;
        int data, hd;

        public Node(int data, int hd) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.hd = hd;
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
