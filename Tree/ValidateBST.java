package Tree;

public class ValidateBST {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return util(root, (long)-Math.pow(2,31)-1, (long)Math.pow(2,31));
    }
    static boolean util(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return util(root.left,min, root.val) && util(root.right, root.val, max);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
}
