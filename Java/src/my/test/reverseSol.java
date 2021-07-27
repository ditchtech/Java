package my.test;

/**
* Program to reverse digits and maintain positive or negative
* Params can be passed as args to reverse function
* @param x number to be reversed
*/
public class reverseSol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseSol T=new reverseSol();
		T.reverse(-746324311);
	}
	
	 public void reverse(int x) {
	       /* StringBuilder s=new StringBuilder();   
	        		s.append("9646324351");//(Integer.toString(Math.abs(x))).toString());
	        		
	        if(x<0)s.append("-");s.reverse();
	        System.out.println(Integer.parseInt(s.toString()));*/
		 int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) System.out.println(0);
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) System.out.println(0);
	            rev = rev * 10 + pop;
	    }
	        System.out.println(rev);
	 }
}
