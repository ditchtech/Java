package my.test;

/**
* Program to find max length of unrepeated string
* Params can be passed as args to lengthOfLongestSubstring function
* @param x number to be reversed
*/

import java.util.HashMap;

public class MaxString {

	public static void main(String[] args) {
		MaxString T=new MaxString();
		System.out.println(T.lengthOfLongestSubstring("dvdkfsljijkjiekljy"));
		
	}
	 public int lengthOfLongestSubstring(String s) {
	        //HashMap<Integer, Character> container=new HashMap<Integer, Character>();
	        int sLength=0;int pos;
	        StringBuffer container=new StringBuffer(s.length());
	        for(int i=0;i<s.length();i++) {
	        	char temp=s.charAt(i);
	        //	System.out.println(container.indexOf(Character.toString(temp))+" "+container+" "+temp);
	        	pos=container.indexOf(Character.toString(temp));
	        	if(pos>=0) {
	        		if(sLength<container.length()) 
	        		sLength=container.length();
	        		container=container.delete(0, pos+1);
	        		
	        		
	        	}
	        		
	        	container.append(temp);
	        	
	        }
	        if(sLength<container.length())
		        sLength=container.length();
	        		
	        /*for(int i=0;i<s.length();i++)
	        {
	        	char temp=s.charAt(i);
	        	if(container.containsValue(temp)) {
	        		int keyVal=0;
					while(keyVal<=i) {container.remove(keyVal);
						keyVal++;}
	        		if(sLength<pos)
		        sLength=pos;
		        pos=0;container.clear();
	        	}
	        	 {
	        	pos++;
	        	container.put(pos, s.charAt(i));
	        	}
	        }
	        if(sLength<pos)
		        sLength=pos;*/
	        return sLength;
	    }
}
