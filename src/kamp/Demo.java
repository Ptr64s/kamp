package kamp;

public class Demo {
	int a;
	
	public int compareTo(int b) {
		
		if(a<b) return -1;
		if(a==b) return 0;
		if(a>b) return 1;
		
		return 0;
		
	}
}


/*
 * Demo x=0;
 * Demo y=1;
 * x.compareTo(y) -> -1
 * 
 * y.compareTo(x) -> 1
 * 
 */
