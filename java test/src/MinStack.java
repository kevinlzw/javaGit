import java.util.ArrayList;

public class MinStack {
	/** initialize your data structure here. */
	
	ArrayList<Integer> stack ;
	private int min;
	private int count;
	
    public MinStack() {
        stack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
        count = 0;
    }
    
    public void push(int x) {
        stack.add(x);
        count++;
        if (x < min){
        	min = x;
        }
    }
    
    public void pop() {
        stack.remove(count -1);
        count--;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < count; i ++) {
        	if(stack.get(i) < min) {
        		min = stack.get(i);
        	}
        }
    }
    
    public int top() {
        return stack.get(count-1);
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack test = new MinStack();
    	test.push(-2);
    	test.push(0);
    	test.push(-3);
    	test.getMin();
    	test.pop();
    	test.top();
    	test.getMin();
    }
}
