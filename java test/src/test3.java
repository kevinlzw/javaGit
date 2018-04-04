import java.util.HashSet;

public class test3 {

	
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> count = new HashSet<Integer>();
        for(int i=0; i<nums.length;i++) {
        	if(!count.add(nums[i])) {
        		return true;
        	}
        }
        return false;
    }
	
	
	
	public static void main(String[] args) {
		
		
		
	}
	
}
