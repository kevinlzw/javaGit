import java.util.HashMap;

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
		 System.out.println(longestCommonPrefix(trya));
	 }
}
