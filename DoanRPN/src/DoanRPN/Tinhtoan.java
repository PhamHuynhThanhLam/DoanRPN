package DoanRPN;

import java.util.Arrays;
import java.util.Stack;


public class Tinhtoan 
{
	Stack<Double> sh = new Stack<Double>();
	Toantu chuoitoantu = new Toantu();
	protected String bieuthuc;
    protected String[] elementMath;		
    Stack<String[]> st = new Stack<String[]>();
	protected String[] doi;
	protected String[] chuoi;
	
	public int Kiemtrahople(String[] elementMath)
	{
		int demmo = 0,demdong=0;
		for(int i=0; i<elementMath.length;i++)
		{
			if(elementMath[i].charAt(0) == '(') demmo++;
			else if(elementMath[i].charAt(0) == ')') demdong++;			
		}
		if(demmo == demdong) return 1;
		else return 0;
	}
	
	public Double Xuatkq(String[] doi)
	{
		double a,b;
		double kq = 0;
		for(int i=0; i< doi.length; i++)
		{
			if(!isOperator(doi[i]))
			{
				kq = Double.parseDouble(doi[i]);
				sh.push(kq);
			}
			else {
				a = sh.pop();
				b = sh.pop();
				switch (doi[i])
				{
				    case "+": kq = (b + a); break;
				    case "-": kq = (b - a); break;
				    case "*": kq = (b * a); break;
				    case "/": kq = (b / a); break;
				}
				sh.push(kq);
			}
		}
		return sh.pop();
	}
    
    
	public String[] chuyendoi(String[] elementMath)
    {
	 
       String chuoipost = "";
       for (int i=0; i<elementMath.length ; i++)
       {
    	   if(!isOperator(elementMath[i]))
    	   {
    		   chuoipost = chuoipost + " " + elementMath[i];
    	   }
    	   else if(elementMath[i].charAt(0) == '(')
    	   {
    		   st.push(chuoitoantu.Chuoi(elementMath[i].charAt(0)));
    	   }
    	   else if(elementMath[i].charAt(0) == ')' )
    	   {
    		   String[] x = st.pop();
    		   while(x[0].charAt(0) != '(')
    		   {
        		   chuoipost = chuoipost + " " + x[0];
        		   x = st.pop();
    		   }
    	   }
    	   else if(elementMath[i].charAt(0) == '*' || elementMath[i].charAt(0) == '/')
		   {
			   if(elementMath[i+1].charAt(0) == '-' || elementMath[i+1].charAt(0) == '+')
			   {
				   int j = i + 1 ;
				   chuoipost = chuoipost + " " +elementMath[j];
				   j++;
				   while(j < elementMath.length && !isOperator(elementMath[j]))
                   {
					   chuoipost = chuoipost + elementMath[j];
					   j++;
		     	   }
			   }
		   }
    	   else 
    	   {
    		   while(!st.isEmpty() && Integer.parseInt(chuoitoantu.Chuoi(elementMath[i].charAt(0))[1]) <= Integer.parseInt(st.peek()[1]))
    		   {
        		   chuoipost = chuoipost + " " + st.peek()[0];
        		   st.pop();
    		   }
    		   st.push(chuoitoantu.Chuoi(elementMath[i].charAt(0)));
    	   }
       }
       
       while(!st.isEmpty())
       {
    	   String[] toantut = st.peek();
		   chuoipost = chuoipost + " " + toantut[0];
    	   st.pop();
       }
       chuoipost = chuoipost.trim();
       doi = chuoipost.split(" ");
       return doi;
    }

	
	public boolean isOperator(String c)
	{  
        String operator[] = { "+", "-", "*", "/", ")", "(" };
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else return false;
    }
	
	public String[] ChuanHoa(String bieuthuc)
	{ 
		String s1 = "", elementMath[] = null;
        bieuthuc = bieuthuc.trim();
        bieuthuc = bieuthuc.replaceAll("\\s+"," ");
        
        for (int i=0; i<bieuthuc.length(); i++)
        {
        	char c = bieuthuc.charAt(i);
            String d = Character.toString(c);
            
            if (!isOperator(d))
                s1 = s1 + d;
            else if (i==0 && c == '-')
            {
            	s1 = s1 + c;
            	i++;
            	while(!isOperator(Character.toString(bieuthuc.charAt(i))))
            	{
            		s1 = s1 + bieuthuc.charAt(i);
            		i++;
            	}
            	i--;
            	s1 = s1 + " ";
            }
            else s1 = s1 + " " + d + " ";
			
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," "); 
        elementMath = s1.split(" "); 
        return elementMath;
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
