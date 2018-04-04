import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class test2 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	  
	  class ListNode {
		       int val;
		       ListNode next;
		       ListNode(int x) {
		           val = x;
		           next = null;
		       }
		   }
	  
	  public ListNode reverseList(ListNode head) {
	        ListNode temp = new ListNode(4);
	        
	        if(head == null) {
	        	return head;
	        }
	        ListNode count = temp;
	        while(head.next != null) {
	        	count = temp.next;
	        	temp.next = head.next;
	        	temp.next.next = count;
	        	head.next = head.next.next;
	        }
	        head.next = temp.next;
	        return head;
	    }
	  
	  
	  
	  public int countPrimes(int n) {
	        if(n == 0){
	            return 0;
	        }
	        else if (n == 1){
	            return 0;
	        }
	         int[] array = new int[n]; // 假设初始所有数都是素数，且某个数是素数，则其值为0；比如第一个数为素数那么array[0]为0  
	    array[0] = 1; // 0不是素数  
	    array[1] = 1; // 1不是素数  
	    // 下面是筛选核心过程  
	    for (int i = 2; i < Math.sqrt(n); i++) { // 从最小素数2开始  
	        if (array[i] == 0) {  
	            for (int j = i * i; j < n; j += i) {  
	                array[j] = 1; // 标识该位置为非素数  
	            }  
	        }  
	    }
	        int count = 0;
	        for(int i = 0; i < n; i ++){
	            if(array[i] == 0){
	                count++;
	            }
	        }
	        return count;
	    }
	  
	  
	  
	  public static boolean isHappy(int n) {
		  HashSet<Integer> duplicate = new HashSet<Integer>();
		  while(true) {
			  int temp = 0;
			  while(n != 0) {
				  temp += Math.pow(n % 10, 2);
				  n /= 10;
			  }
			  if(!duplicate.add(temp)) {
				  return false;
			  }
			  else if(temp == 1) {
				  return true;
			  }
			  n = temp;
		  }
	    }
	  
	  
	  public static int robBetter(int[] nums) {
	        int rob = 0, not_rob = 0;
	        for(int i=0;i<nums.length;i++){
	            int temp = rob;
	            rob = not_rob + nums[i];
	            not_rob = Math.max(temp,not_rob);
	        }
	        return Math.max(rob,not_rob);
	    }
	  
	  
	  public int rob(int[] nums) {
		  int[] sum = new int[nums.length];
		  if(nums.length == 0) {
			  return 0;
		  }
		  else if (nums.length == 1) {
			  return nums[0];
		  }
		  sum[0] = nums[0];
		  sum[1] = Math.max(nums[0], nums[1]);
		  for(int i = 2; i < sum.length; i ++) {
			  sum[i] = Math.max((sum[i-2] + nums[i]), sum[i-1]);
		  }
		  return sum[sum.length-1];
	    }
	  
	  public int hammingWeight(int n) {
	        int count = 0;
	        for(int i = 0; i < 32; i ++, n >>= 1) {
	        	if((n & 1) == 1) {
	        		count ++;
	        	}
	        }
	        return count;
	    }
	  
	  
	  public int reverseBits(int n) {
		  // >> 是右移 | 是“或” & 是 “和”
		  // 优先层级: | < "<<"
		  int res = 0;
	        for(int i = 0; i < 32; i++, n >>= 1){
	            res = res << 1 | (n & 1);
	        }
	        return res;
	    }
	  
	  
	  
	  public static void rotate1(int[] nums, int k) {
		  int[] result = new int[nums.length];
		  for(int i=0;i<nums.length;i++) {
			  result[i] = nums[(i+k)%nums.length];
		  }
		  System.arraycopy(result, 0, nums, 0, nums.length);
	  }
	  
	  
	  public static void rotate(int[] nums, int k) {
		  if (k > nums.length)
	            k = k % nums.length;

	        int[] result = new int[nums.length];

	        System.arraycopy(nums, nums.length - k, result, 0, k);
//	        for (int i = 0; i < k; i++) {
//	            result[i] = nums[nums.length - k + i];
//	        }

	        System.arraycopy(nums, 0, result, k, nums.length - k);
//	        for (int i = k; i < nums.length; i++) {
//	            result[i] = nums[i-k];
//	        }

	        System.arraycopy(result, 0, nums, 0, nums.length);
	    }
	  	  
	  
	  
	  
	  public int majorityElementSmart(int[] nums) {
		  Arrays.sort(nums);
		  return nums[nums.length/2];
	  }
	  
	  public int majorityElement(int[] nums) {
	        HashMap <Integer, Integer> count = new HashMap<Integer, Integer>();
	        for (int i = 0; i<nums.length;i++) {
	        	count.putIfAbsent(nums[i], 0);
	        	if(count.get(nums[i])+1 > (nums.length/2)) {
	        		return nums[i];
	        	}
	        	count.put(nums[i], count.get(nums[i])+1);
	        }
	        return Integer.MIN_VALUE;
	    }
	  
	  public int trailingZeroes(int n) {
		  int res = 0;
	        while (n > 0) {
	            res += n / 5;
	            n /= 5;
	        }
	        return res;
	    }
	  
	  public String convertToTitleSmart(int n) {
	        StringBuilder sb = new StringBuilder();
	        while(n>0){
	            n--;
	            sb.insert(0,(char)('A'+n%26));
	            n=n/26;
	        }
	        return sb.toString();   
	    }
	  
	  
	  public String convertToTitle(int n) {
		  HashMap<Integer, String> convertchart = new HashMap<Integer, String>();
		  convertchart.put(1, "A");
		  convertchart.put(2, "B");
		  convertchart.put(3, "C");
		  convertchart.put(4, "D");
		  convertchart.put(5, "E");
		  convertchart.put(6, "F");
		  convertchart.put(7, "G");
		  convertchart.put(8, "H");
		  convertchart.put(9, "I");
		  convertchart.put(10, "J");
		  convertchart.put(11, "K");
		  convertchart.put(12, "L");
		  convertchart.put(13, "M");
		  convertchart.put(14, "N");
		  convertchart.put(15, "O");
		  convertchart.put(16, "P");
		  convertchart.put(17, "Q");
		  convertchart.put(18, "R");
		  convertchart.put(19, "S");
		  convertchart.put(20, "T");
		  convertchart.put(21, "U");
		  convertchart.put(22, "V");
		  convertchart.put(23, "W");
		  convertchart.put(24, "X");
		  convertchart.put(25, "Y");
		  convertchart.put(0, "Z");
		  String result = "";
		  while(n > 0) {
			  int remin = n % 26;
			  result = convertchart.get(remin) + result;
              n--;
			  n /= 26;
		  }
		  return result;
	    }
	  
	  
	  public int[] twoSum(int[] numbers, int target) {
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<numbers.length;i++){
	            if(numbers[i] > target){
	                return null;
	            }
	            int comp = target - numbers[i];
	            if(map.containsKey(comp)){
	                return new int[]{map.get(comp),i};
	            }
	            map.put(numbers[i],i);
	        }
	        return null;
	    }
	  
	  
	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		  HashSet<ListNode> Aset = new HashSet<ListNode>();
		  if(headA == null|| headB == null) {
			  return null;
		  }
		  ListNode A = headA;
		  ListNode B = headB;
		  while(A != null) {
			  Aset.add(A);
			  A = A.next;
		  }
		  while(B != null) {
			  if(Aset.contains(B)) {
				  return B;
			  }
			  B = B.next;
		  }
		  return null;
	  }
	  
	  
	  
	  
	  public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null) {
	        	return false;
	        }
	        ListNode onestep = head;
	        ListNode twostep = head.next;
	        while(onestep.next != null && twostep.next != null && twostep.next.next != null) {
	        	if(onestep == twostep) {
	        		return true;
	        	}
	        	else {
	        		onestep = onestep.next;
	        		twostep = twostep.next.next;
	        	}
	        }
	        return false;
	    }
	  
	  
	  public int singleNumber(int[] nums) {
		  int result = 0;
		    for (int i = 0; i<nums.length; i++)
		    {
		        result ^=nums[i];
		    }
		    return result;
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
		  int[] test2 = new int[3];
		  test2[0] = 1;
		  test2[1] = 2;
		  test2[2] = 3;
		  rotate(test2,1);
		  int test11 = 10;
		  System.out.println(test11 << 3);
		  System.out.println(4 & 2);
		  robBetter(test);
		  isHappy(3);
		  System.out.println(3 % 10);
		  System.out.println(3^2);

		  
	  }
	
}
