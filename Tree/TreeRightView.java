package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<Integer> l = leftSideView(root);
        for(int a : l)
            System.out.print(a+" ");

    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode prev = null;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp  == null){
                if(prev == null)
                    return l;
                l.add(prev.val);
                prev = null;
                q.add(null);
            }
            else{
                prev = temp;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return l;
    }
    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        TreeNode prev = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t == null){
                if(prev == null)
                    return l;
                else{
                    prev = null;
                    q.add(null);
                }
            }
            else{
                if(prev == null)
                    l.add(t.val);
                prev = t;
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
        }
        return l;
    }
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1+Math.min(helper(root.left),helper(root.right));
    }
    static int helper(TreeNode root){
        if(root == null)
            return 10001;
        if(root.left == null && root.right == null)
            return 1;
        return 1+Math.min(helper(root.left),helper(root.right));
    }
}
