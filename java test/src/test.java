import java.util.HashMap;
import java.util.Stack;

public class test {

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
	 }
}
