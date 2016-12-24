package FbInterview;

public class CheckIfBST {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public boolean chkIfBST(TreeNode root) {
		if (root == null) {
			
		} else {
			return chkIfBST(root.left) && chkIfBST(root.right);
		}
		if (root.left.val < root.val && root.right.val > root.val) {
			return true;
		}
        return false;
    }
}
