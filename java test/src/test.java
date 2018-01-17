
public class test {

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
	
}
