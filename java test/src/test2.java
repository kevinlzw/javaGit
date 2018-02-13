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
	 
	  // Origins from https://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
	  public boolean isPalindrome(String s) {
		  s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			System.out.println(s);
	 
			for(int i = 0; i < s.length() ; i++){
				if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
					return false;
				}
			}
	 
			return true;
		  
	    }
	  
	  
	  public static int maxProfit(int[] prices) {
		  int max = 0;
		  int lowest = Integer.MAX_VALUE;
		  for(int i = 0; i < prices.length; i ++) {
	    	 if(prices[i] < lowest) {
	    		 lowest = prices[i];
	    	 }
	    	 else {
	    		 if(prices[i] - lowest > max) {
	    			 max = prices[i] - lowest;
	    		 }
	    	 }
	     }
		  return max;
	    }
	  
	  
	  
	  
	  public static List<List<Integer>> generateBetter(int numRows) {
	        List<List<Integer>> rows = new ArrayList<>();
	        ArrayList<Integer> row = new ArrayList<>();
	        if (numRows == 0) return rows;
	        row.add(1);
	        rows.add(row);
	        for (int i=1; i<numRows; i++) {
	            row = new ArrayList<>();
	            row.add(1);
	            for (int j=1; j<i; j++) {
	                row.add(rows.get(i-1).get(j-1)+rows.get(i-1).get(j));            
	            }
	            row.add(1);
	            rows.add(row);
	        }
	        return rows;
	    }
	  
	  
	  
	  
	  public static List<List<Integer>> generate(int numRows) {
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
	     if (numRows == 0) {
	    	 return res;
	     }
	     for(int i = 0; i < numRows; i ++) {
	    	 res.add(new ArrayList<Integer>());
	    	 System.out.println(res.get(i).size());
	    	 for(int k = 0; k < i + 1; k++) {
	    		 res.get(i).add(0);
	    	 }
	    	 res.get(i).set(0, 1);
	    	 res.get(i).set(i , 1);
	    	 if(i != 0 && i != 1) {
	    		 for(int j = 1; j < i; j++) {
	    			 int front = res.get(i-1).get(j-1);
	    			 int back = res.get(i-1).get(j);
	    			 res.get(i).set(j,front+back);
	    		 }
	    	 }
	     }
	     return res;
	    }
	  
	  
	  
	  public boolean isBalanced(TreeNode root) {
		  if(root == null) {
			  return true;
		  }
		  else {
			  int rightdepth = maxDepthBetter(root.right);
			  int leftdepth = maxDepthBetter(root.left);
			  if(Math.abs(rightdepth - leftdepth) > 1) {
				  return false;
			  }
			  else {
				  return isBalanced(root.left) && isBalanced(root.right);
			  }
		  }
	    }
	  
	  
	  
	  
	  
	  public TreeNode sortedArrayToBST(int[] nums) {
		  if(nums.length == 0  || nums == null) {
			  return null;
		  }
		  else {
			  return sortedArrayToBSTHelper(nums, 0, nums.length-1);
		  }
	    }
	  
	  public TreeNode sortedArrayToBSTHelper(int[] nums, int low, int high) {
		  if(low> high) {
			  return null;
		  }
		  else {
			  int middle = (low + high) / 2;
			  TreeNode root = new TreeNode(nums[middle]);
			  root.left = sortedArrayToBSTHelper(nums, low, middle -1 );
			  root.right = sortedArrayToBSTHelper(nums, middle +1, high);
			  return root;
		  }
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
	  
	  public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null && sum != 0) {
	        	return false;
	        }
	        else if(root == null && sum == 0) {
	        	return true;
	        }
	        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
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
	  
	  public static void main(String[] args) {
		  //generate(3);
		  int[] test = new int[6];
		  test[0] = 7;
		  test[1] = 1;
		  test[2] = 5;
		  test[3] = 3;
		  test[4] = 6;
		  test[5] = 4;
		 // maxProfit(test);
		  String Str = new String("www.google.com");
		  // 正则表达式，十分重要
		  Str = Str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		  System.out.println(Str);
	  }
	
}
