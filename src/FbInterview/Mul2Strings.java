package FbInterview;

public class Mul2Strings {
	    
	    public static class Mulres{
	        int res;
	        int carry;
	        Mulres(int x, int y) {
	            res = x;
	            carry = y;
	        }
	    }
	    
	    static Mulres multiply(int x, int y, int prevcarry) {
	        int z;
	        if (prevcarry > 0) {
	            z = x*y + prevcarry;
	        } else {
	            z = x*y;
	        }
	        return new Mulres(z%10, z/10);
	    }
	    
	    Mulres add(int x, int y, int prevcarry) {
	        int z;
	        if (prevcarry > 0) {
	            z = x + y + prevcarry;
	        } else {
	            z = x + y;
	        }
	        return new Mulres(z%10, z/10);
	    }
	    
	    public static String multiply(String num1, String num2) {
	        int numOfIntSum = num2.length();
	        String []inSums = new String[numOfIntSum];
	        for (int i=numOfIntSum-1;i>=0;i--) {
	            StringBuffer intSum = new StringBuffer("");
	            int x=Integer.parseInt(num2.substring(i,i+1));
	            int l = num1.length();
	            int prevcarry = 0;
	            for (int j=l-1;j>=0;j--) {
	                int y = Integer.parseInt(num1.substring(j,j+1));
	                Mulres r = multiply(x,y, prevcarry);
	                prevcarry = r.carry;
	                if (j!=0) {
	                    intSum = intSum.insert(0,r.res);
	                } else {
	                    intSum = intSum.insert(0,r.res).insert(0,r.carry);
	                }
	            }
	            System.out.println(intSum);
	            inSums[i] = intSum.toString();
	        }
	        return "";
	    }
	    
	    public static void main(String[] args) {
	    	multiply("123", "345");
		}
	}