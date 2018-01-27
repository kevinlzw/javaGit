import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test2 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	  public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			if (root == null)
				return res;
			dfs(root, 0, res);
	        Collections.reverse(res);
	        return res;
		}
	    
	    public void dfs(TreeNode root, int depth, List<List<Integer>> res) {
	        if (root == null) {
	            return;
	        }
	        if (depth == res.size()) {
	            res.add(new ArrayList<>());
	        }
	        res.get(depth).add(root.val);
	        dfs(root.left, depth + 1, res);
	        dfs(root.right, depth + 1, res);
	    }
	  
	  
	  public boolean isSameTree(TreeNode p, TreeNode q) {
		  if(p == null && q == null) {
			  return true;
		  }
		  else if(p == null && q!=null) {
			  return false;
		  }
		  else if(p != null && q == null) {
			  return false;
		  }
		  else if (p.val != q.val) {
			  return false;
		  }
		  else {
			  return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		  }
	    }
	  
	  
	  public int maxDepthBetter(TreeNode root) {
	        
	        if (root == null) return 0;
	        
	        int lHeight = maxDepthBetter(root.left);
	        int rHeight = maxDepthBetter(root.right);
	        
	        return Math.max(lHeight, rHeight)+1;
	        
	    }
	  
	  public int maxDepth(TreeNode root) {
		  if(root == null) {
			  return 0;
		  }
		  else {
			  int depth = 1 + maxDepth(root.left,root.right);
			  return depth;
		  }
	    }
	  
	  public int maxDepth(TreeNode left, TreeNode right) {
		  if(left == null && right == null) {
			  return 0;
		  }
		  else if(left == null) {
			  int depth = 1 + maxDepth(right.left,right.right);
			  return depth;
		  }
		  else if(right == null) {
			  int depth = 1 + maxDepth(left.left,left.right);
			  return depth;
		  }
		  else {
			  int depth = 1 + Math.max(maxDepth(right.left,right.right), maxDepth(left.left,left.right));
			  return depth;
		  }
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
