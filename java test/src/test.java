import java.util.HashMap;
import java.util.Stack;

public class test {
	
	public int mySqrt(int x) {
		return (int)Math.sqrt(x);
    }
	
	public static int climbStairsBetter(int n) {
		if(n <= 2) {
			return n;
		}
		else {
			int[] temp = new int[n];
			temp[0] = 1;
			temp[1] = 2;
			for(int i = 2;  i < n; i++) {
				temp[i] = temp[i-1] + temp[i-2];
			}
			return temp[n-1];
		}
	}
	
	public static int climbStairs(int n) {
		return climbStairs(n, 0);
    }
	
	public static int climbStairs(int n, int count) {
		if(n == 1) {
			return count + 1;
		}
		else if(n == 2) {
			return count + 2;
		}
		else {
			return climbStairs(n-1,count) + climbStairs(n-2,count);
		}
	}
	
	
	
	// 来自http://blog.csdn.net/happyaaaaaaaaaaa/article/details/48896239
	public String addBinary(String a, String b) {
		int maxLen = Math.max(a.length(), b.length());  
	    StringBuilder sb = new StringBuilder();  
	    int carry = 0;  
	    for (int i = 0; i < maxLen; i++) { //从右边开始逐位取出字符串 a、b 的字符值 tempA 和 tempB，如果长度不足，则用0替代  
	        int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;  
	        int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;  
	        sb.insert(0, (tempA + tempB + carry) % 2);  //在最左侧插入相加结果  
	        carry = tempA + tempB + carry > 1 ? 1 : 0;  //得到进位  
	    }  
	    if (carry == 1) sb.insert(0, 1);  //如果最高位有进位，则最高位还要加一位 1  
	    return sb.toString();  
    }
	
	
	public static int[] plusOne(int[] digits) {
		for(int i=digits.length-1; i>=0; i--) {
			if(digits[i] != 9) {
				digits[i]++;
				return digits;
			}
			else if(i == 0 && digits[0] == 9) {
				int[] newresult = new int[digits.length+1];
				newresult[0] = 1;
				return newresult;
			}
			else if (digits[i] == 9) {
				digits[i] = 0;
				continue;
			}
		}
		return new int[1];
    }
	
	
	
    public static String countAndSay(int n) {
    	if(n == 1) {
    		return "1";
    	}
    	else {
    		return countOnce(countAndSay(n-1));
    	}
    }
    
    public int lengthOfLastWordBetter(String s) {
    	s = s.trim();	//去掉首尾空格（非常实用）
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
    
    
    public int lengthOfLastWord(String s) {
    	int lastindexspace = s.lastIndexOf(" ");
    	if(lastindexspace == -1) {
    		return s.length();
    	}
        if(lastindexspace == s.length()-1){
            return lengthOfLastWord(s.substring(0,s.length()-1));    
        }
    	return s.substring(lastindexspace+1, s.length()).length();
    }
    
    
    public int maxSubArray(int[] nums) {
    	int currentmax = nums[0];
    	int max = nums[0];
    	for(int i=1;i<nums.length;i++) {
    		currentmax = Math.max(currentmax + nums[i], nums[i]);
    		if(currentmax > max) {
    			max = currentmax;
    		}
    	}
    	return max;
    }
    
    
    
    public static String countOnce(String res){
    	char c = res.charAt(0);
    	int num=1;
    	StringBuilder sb = new StringBuilder();
    	for(int i=1;i<res.length();i++){
    		if(res.charAt(i)==c){
    			num++;
    			continue;
    	}
    	sb.append(String.valueOf(num)+c);
    	c=res.charAt(i);
    	num=1;
    	}
    	sb.append(String.valueOf(num)+c);
    	return sb.toString();
    	}
    /*public static String countAndSayHelper(String input) {
    	int count = 1;
    	String result = "";
    	char[] chararray = input.toCharArray();
    	for(int i=0; i<chararray.length-1;i++) {
    		if(chararray[i] == chararray[i+1]) {
    			count++;
    		}
    		else {
    			result+= count + chararray[i];
    		}
    	}

    	if(input.equals("1")) {
    		return "11";
    	}
    	return result;
    }
	*/
	
	
    public int searchInsert(int[] nums, int target) {
    	for(int i=0; i<nums.length;i++) {
    		if(nums[i] == target) {
    			return i;
    		}
    		else if (i == 0 && nums[i] > target) {
    			return 0;
    		}
    		else if (i == nums.length-1) {
    			return nums.length;
    		}
    		else if (nums[i] < target && nums[i+1] > target) {
    			return i+1;
    		}
    		else {
    		}
    	}
    	return 0;
    }
	
	
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0) {
			return "";
		}
        if(strs.length==1){
            return strs[0];
        }
        String first = strs[0];
		String result = "";
		for (int i = 1; i < first.length()+1; i++) {
			String common = first.substring(0,i);
			boolean same = true;
			for(int j=1; j < strs.length; j++) {
				try {
					String commonother = strs[j].substring(0,i);
					if(!commonother.equals(common)) {
						same = false;
					}
				}
                catch(Exception e) {
					same = false;
				}
				finally {
				}
			}
			if(same) {
				result = common;
			}
		}
		return result;
    }
	
	  //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	  
	  // 源自 https://www.cnblogs.com/grandyang/p/4059650.html
	  public static void merge1(int[] A, int m, int[] B, int n){
		  int count = m + n - 1;
	      --m; --n;
	      while (m >= 0 && n >= 0) A[count--] = A[m] > B[n] ? A[m--] : B[n--];
	      while (n >= 0) A[count--] = B[n--];  
	  }
	  
	  public static void merge(int[] nums1, int m, int[] nums2, int n) {
		  int[] result = new int[n+m];
		  int count1 = 0;
		  int count2 = 0;
		  int count3 = 0;
		  while(count1 != m && count2 != n) {
			  if(nums1[count1] <= nums2[count2]) {
				  result[count3] = nums1[count1];
				  count1++;
			  }
			  else {
				  result[count3] = nums2[count2];
				  count2++;
			  }
			  count3++;
		  }
		  nums1 = result;
		  if(m == 0){
	            nums1 = nums2;
	        }
	    }
	  
	  
	  
	  
	  
	  public ListNode deleteDuplicates(ListNode head) {
		  if (head == null) {
			  return null;
		  }
		  ListNode temp = head;
		  while(temp.next !=null) {
			  if(temp.val == temp.next.val) {
				  if(temp.next.next!=null) {
					  temp.next = temp.next.next;
					  continue;
				  }
				  else {
					  temp.next = null;
					  break;
				  }
			  }
			  temp = temp.next;
		  }
		  return head;
	  }
	  
	  
	
	public ListNode betterMergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;

	        if(l1.val > l2.val) {
	            ListNode temp = l2;
	            temp.next = betterMergeTwoLists(l1, l2.next);
	            return temp;
	        } else {
	            ListNode temp = l1;
	            temp.next = betterMergeTwoLists(l1.next, l2);
	            return temp;
	    }
	}
	  
	  
	  
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode result;
    	ListNode resultprogress;
    	if(l1.val <= l2.val) {
    		result = new ListNode(l1.val);
    		l1 = l1.next;
    		resultprogress = result;
    	}
    	else {
    		result = new ListNode(l2.val);
    		l2 = l2.next;
    		resultprogress = result;
    	}
    	while(!(l1 == null && l2 == null)) {
    		if(l1 == null) {
    			resultprogress.next = l2;
    			l2 = null;
    		}
    		else if (l2 == null) {
    			resultprogress.next = l1;
    			l1 = null;
    		}
    		else if (l1.val <= l2.val) {
    			resultprogress.next = new ListNode(l1.val);
    			resultprogress = resultprogress.next;
    			l1 = l1.next;
    		}
    		else {
    			resultprogress.next = new ListNode(l2.val);
    			resultprogress = resultprogress.next;
    			l2 = l2.next;
    		}
    	}
    	return result;
    }
	
    
    public static int strStr(String haystack, String needle) {
    	  for (int i = 0; ; i++) {
    	    for (int j = 0; ; j++) {
    	      if (j == needle.length()) return i;
    	      if (i + j == haystack.length()) return -1;
    	      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    	    }
    	  }
    	}
    
    
    public int removeElement(int[] nums, int val) {
    	int length = 0;
    	for(int i=0; i<nums.length;i++) {
    		if(nums[i] != val) {
    			nums[length] = nums[i];
    			length++;
    		}
    	}
    	return length;
    }
	
	public static boolean isValid(String s) {
		HashMap<Character, Character> mapping = new HashMap<Character, Character>();
		mapping.put(')', '(');
		mapping.put('}', '{');
		mapping.put(']', '[');
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			}
			else {
				if(mapping.get(s.charAt(i)) == stack.peek()) {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		return stack.empty();
	}
	
	
	
	public static int romanToInt(String s) {
		HashMap<String, Integer> correspond = new HashMap<String, Integer>();
		correspond.put("I", 1);
		correspond.put("V", 5);
		correspond.put("X", 10);
		correspond.put("L", 50);
		correspond.put("C", 100);
		correspond.put("D", 500);
		correspond.put("M", 1000);
		int result = 0;
		for(int i = 0; i < s.length(); i ++) {
			int value = correspond.get(s.substring(i,i+1));
			if(i == s.length()-1 || value > correspond.get(s.substring(i+1,i+2))){
				result += value;
			}
			else {
				result -= value;
			}
		}
		return result;
    }
	
	
	int reverse(int x)  
	{  
	    int y=0,z;  
	    for (; x>0; x=x/10)  
	    {  
	        z=x%10;  
	        y=y*10+z;  
	    }  
	    return y;  
	}  
	
	
	 public static void main(String[] args) {
		 romanToInt("DCXXI");
		 String[] trya = new String[2];
		 trya[0] = "aa";
		 trya[1] = "a";
		 //System.out.println(longestCommonPrefix(trya));
		 String test= "(])";
		 isValid(test);
		 
		 test test1 = new test();
		 ListNode a = test1.new ListNode(1);
		 ListNode b = test1.new ListNode(1);
		 a.next = test1.new ListNode(2);
		 a.next.next = test1.new ListNode(4);
		 b.next = test1.new ListNode(3);
		 b.next.next = test1.new ListNode(4);
		 test1.mergeTwoLists(a, b);
		 String strtest = "interesting";
		 String strsubtest = "est";
		 strStr(strtest,strsubtest);
		 countAndSay(4);
		 int[] newtest = new int[10];
		 newtest[0] = 9;
		 newtest[1] = 8;
		 newtest[2] = 7;
		 newtest[3] = 6;
		 newtest[4] = 5;
		 newtest[5] = 4;
		 newtest[6] = 3;
		 newtest[7] = 2;
		 newtest[8] = 1;
		 newtest[9] = 0;
		 plusOne(newtest);
		 //System.out.println(climbStairs(44,0));
		 //System.out.println(climbStairsBetter(44));
		 int[] nums1 = new int[1];
		 int[] nums2 = new int[1];
		 nums2[0] =1;
		 merge(nums1,0,nums2,1);
	 }
}
