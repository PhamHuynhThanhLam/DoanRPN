package DoanRPN;

import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;

public class Tinhtoan 
{
	protected String bieuthuc;  
	Stack<Double> sh = new Stack<Double>();			
	Operator toantu = new Operator();
	
	public String Xuatkq(LinkedList<String> doi)
	{
		double a,b;
		double kq = 0;
		for(int i=0; i< doi.size(); i++)
		{
			String s ="";
	       	s+= doi.get(i);
			if(!isOperator(s))
			{
				kq = Double.parseDouble(s);
				sh.push(kq);
			}
			else {
				a = sh.pop();
				if (s.equals("+")|| s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^"))
				{
					b = sh.pop();
					switch (s)
					{
					    case "+": kq = (b + a); break;
					    case "-": kq = (b - a); break;
					    case "*": kq = (b * a); break;
					    case "/": 
					    	if(a==0)
					        {
					    		System.out.println("Khong the chia 0");
					    	}
					    	kq = (b / a); break;
					    case "^":
                            kq = Math.pow(b, a);
                            break;
					}
					sh.push(kq);
				}
				else if (s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("cotg") || s.equals("ln") || s.equals("log") || s.equals("sqrt"))
				{
					 double c = Math.toRadians(a);
					 switch (s)
                     {
                         case "sin":
                             sh.push(Math.sin(c));
                             break;
                         case "cos":
                             sh.push(Math.cos(c));
                             break;
                         case "tan":
                             sh.push(Math.tan(c));
                             break;
                         case "cotg":
                             sh.push(1.00/Math.tan(c));
                             break;
                         case "ln":
                             sh.push(Math.log(a));
                             break;
                         case "log":
                             sh.push(Math.log10(a));
                             break;
                         case "sqrt":
                             sh.push(Math.sqrt(a));
                             break;
                     }
				}		
			}
		}
		return String.valueOf(sh.pop());
	}
    
   
	public LinkedList<String> chuyendoi(LinkedList<String> elementMath)
    {	 
		 Operator t1 = null;
		 String[] t2 = null;
		 LinkedList<String> chuoipost = new LinkedList<String>();
		 Stack<String[]> st1 = new Stack<String[]>();
	     for (int i=0; i<elementMath.size() ; i++)
	     {
	    	 String s ="";
	         s+= elementMath.get(i);
	         
	         toantu.Chuoi(s);
	         
	    	 if(!isOperator(s))
	    	 {
	    		 chuoipost.add(s);
	    	 }
	    	 
	    	 else if(i == 0 && s.equals("-"))
	    	 {   
	    		 if(!isOperator(elementMath.get(i+1)))
	    		 {
	    			 String s3 = s;
		    		 while(i + 1 < elementMath.size() && !isOperator(elementMath.get(i+1)))
		    		 {
		    			 s3 = s3 + elementMath.get(i+1);
		    			 i++;
		    		 }
		    		 chuoipost.add(s3);
	    		 }
	    			    		
	    	 }
	    	 
	    	 else if(s.equals("("))
	    	 {
	    		 st1.push(toantu.xetdouutien(s));
	    	 }
	    	 else if(s.equals(")"))
	    	 {
	    		 String[] x = st1.pop();
	    		 while(x[0].equals("(") == false)
	    		 {
	        	    chuoipost.add(x[0]);
	        	    x = st1.pop();
	    		 }
	    	 }
	    	  
	    	 else if(s.equals("*") || s.equals("/"))
			 {
	    		 st1.push(toantu.xetdouutien(s));    		   
				 if(elementMath.get(i+1).charAt(0) == '-' || elementMath.get(i+1).charAt(0) == '+')
				 {				   
					 String s1 ="",s2="";
			         s1+= elementMath.get(i+1);
			         s2+=elementMath.get(i+2);
					 while(i < elementMath.size() && isOperator(elementMath.get(i)))
	                 {						 
						 chuoipost.add(s1+s2);
						 i=i+2;
			     	 }
				  }
				
			 }
	    	 
	    	 else 
	    	 {
	    		  if(!st1.empty())
	    		  {
	    			  t2 = st1.peek();
	    			  t1 = new Operator(t2[0],Integer.valueOf(t2[1]));
	    		  }
	    		  while(!st1.isEmpty() && toantu.sosanh(toantu,t1))
	    		  {
	    			  String[] tt= st1.peek(); 
	        		  chuoipost.add(tt[0]);
	        		  st1.pop();
	        		  
	        		  if(!st1.empty())
		    		  {
		    			  t2 = st1.peek();
		    			  t1 = new Operator(t2[0],Integer.valueOf(t2[1]));

		    		  }
	    		  }
	    		  st1.push(toantu.xetdouutien(s));
	    	 }
	      }
	      
	      while(!st1.isEmpty())
	      {
	    	  String[] toa = st1.peek();
	    	  chuoipost.add(toa[0]);
	    	  st1.pop();
	      }
	     
	      return chuoipost;
    }
	
	public static boolean isOperator(String c)
	{  
        String operator[] = { "+", "-", "*", "/", ")", "(" ,"sin","cos","tan","cotg","^","log","ln","sqrt"};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else return false;
    }
	
	public LinkedList<String> ChuanHoa(String bieuthuc)
	{ 
		LinkedList<String> infix = new LinkedList<String>();
        String s1 = "", elementMath[] = null;
        bieuthuc = bieuthuc.trim();
        bieuthuc = bieuthuc.replaceAll("\\s+"," ");
        for (int i=0; i<bieuthuc.length(); i++)
        {
            char c = bieuthuc.charAt(i);
            String d = Character.toString(c);
          
            if(!isOperator(d))
            {
            	s1 = s1 + d; 
            }      
            else if (c >= 'a' && c <= 'z')
            {
                int j = i;
                while (bieuthuc.charAt(i) >= 'a' && bieuthuc.charAt(i) <= 'z')
                    i++;
                d = bieuthuc.substring(j, i - j);
                s1 = s1 + d + " ";
                i--;
            }
           
            else s1 = s1 + " " + d + " ";
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," "); 
        elementMath = s1.split(" "); 
        for(int i=0;i<elementMath.length;i++)
        {
        	infix.add(elementMath[i]);
        }
        return infix;
    }
	
	
	public String Chuanam(String bieuthuc)
	{ 
		String s1 = "";
        bieuthuc = bieuthuc.trim();
        bieuthuc = bieuthuc.replaceAll("\\s+"," ");
        int j=0;
        for(int i=0;i<bieuthuc.length();i++)
        {
        	if (bieuthuc.charAt(i) == '-' && bieuthuc.charAt(i+1) == '-' || bieuthuc.charAt(i) == '-' && bieuthuc.charAt(i+1) == '+' || bieuthuc.charAt(i) == '+' && bieuthuc.charAt(i+1) == '+'|| bieuthuc.charAt(i) == '+' && bieuthuc.charAt(i+1) == '-')
            {
                 if (bieuthuc.charAt(i) == '-')
                      j = 1;
                 while (bieuthuc.charAt(i+1) == '-' || bieuthuc.charAt(i+1) == '+')
                 {
                      if (bieuthuc.charAt(i+1) == '-')
                          j++;
                      else 
                      {
                    	  int a=i+1;
                    	  if(a == bieuthuc.length())
                    	  {
                    		  break;
                    	  }
                      }
                      i++;
                 }
                             
                 if (( j) % 2 == 0)
                      s1 = s1 + "+";
                 else
                      s1 = s1 + "-";
               }
            else
            {
            	s1 = s1 + bieuthuc.charAt(i);
            }
        }
        return s1;
    }


}
