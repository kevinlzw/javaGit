
public class test2 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	  public boolean isSymmetricBetter(TreeNode root) {
	        return root == null || isSymmetric(root.left, root.right);
	    }

	    private boolean isSymmetricBetter(TreeNode left, TreeNode right) {
	        int nu = (left == null ? 1 : 0) + (right == null ? 1 : 0);
	        if (nu == 1)
	            return false;
	        if (nu == 2)
	            return true;
	        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	    }
	  
	  
	  
	  
	  
	  public boolean isSymmetric(TreeNode root) {
		  if(root == null) {
			  return true;
		  }
		  else if(root.left == null && root.right != null) {
			  return false;
		  }
		  else if (root.right == null && root.left != null) {
			  return false;
		  }
        else if(isNode(root)){
            return true;
        }
		  else if(root.left.val != root.right.val) {
			  return false;
		  }
		  else {
			  return isSymmetric(root.left,root.right);
		  }
		  
	    }
	  
	  public boolean isNode(TreeNode node) {
		  return node.left == null && node.right == null;
	  }
	  
	  public boolean isLeftNodeEmpty(TreeNode node) {
		  return node.left == null;
	  }
	  
	  public boolean isRightNodeEmpty(TreeNode node) {
		  return node.right == null;
	  }
	  
	  public boolean isSymmetric(TreeNode left, TreeNode right) {
          if(left.val != right.val){
            return false;  
          }
		  if(isNode(left) && isNode(right)) {
			  return left.val == right.val;
		  }
		  else if(isLeftNodeEmpty(left) && !isRightNodeEmpty(right)) {
			  return false;
		  }
		  else if(!isLeftNodeEmpty(left) && isRightNodeEmpty(right)) {
			  return false;
		  }
		  else if(!isLeftNodeEmpty(right) && isRightNodeEmpty(left)) {
			  return false;
		  }
		  else if(isLeftNodeEmpty(right) && !isRightNodeEmpty(left)) {
			  return false;
		  }
          else if(isLeftNodeEmpty(left)){
              return isSymmetric(left.right, right.left);
          }
          else if (isLeftNodeEmpty(right)){
              return isSymmetric(left.left,right.right);
          }
		  else {
			  return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
		  }
	  }
	
}
