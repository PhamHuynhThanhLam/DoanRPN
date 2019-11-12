package DoanRPN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Programmain
{		
	public static void main(String[] args) throws IOException
	{
		String bieuthuc;
		String s = "";
		LinkedList<String> infix = new LinkedList<String>();
		LinkedList<String> postfix = new LinkedList<String>();
		Tinhtoan th = new Tinhtoan(); 
		
    	do {
    		System.out.println("Nhap phep tinh can tinh : " );
    		InputStreamReader ips=new InputStreamReader(System.in);   
        	BufferedReader br=new BufferedReader(ips);
        	bieuthuc = br.readLine();   		
    	}while(bieuthuc.length() == 0);
       
        
        try {
            bieuthuc = th.Chuanam(bieuthuc);
		} catch (Exception e) {
			
		}
        
        infix = th.ChuanHoa(bieuthuc); 
        postfix = th.chuyendoi(infix);   

        System.out.println("Chuoi infix to postfix");
      			  
    	System.out.print(postfix);	
    	
        try {
        	System.out.println();   
        	String k = th.Xuatkq(postfix);
            System.out.println("Ket qua phep tinh: " + bieuthuc + " : " + k); 
		} catch (Exception e)
        {
   		    System.out.println("Ket qua phep tinh: " + bieuthuc + " : " + "NULL"); 
		}
         
	    System.out.println("========================================================"); 
	    infix.add(" ");
	    th.Statusstack.add(" ");
	    for(int i=0;i<infix.size();i++)
	    {
	    	s= "";
	    	if(i==0 && (infix.get(i).equals("-")||infix.get(i).equals("+")))
	    	{
	    		s= s + infix.get(i);
	    		infix.remove(i);
	    		s= s + infix.get(i);
	    		infix.remove(i);
	    		infix.addFirst(s);
	    	}
	    	if((infix.get(i).equals("-")||infix.get(i).equals("+")) && (infix.get(i-1).equals("*")||infix.get(i-1).equals("/")))
	    	{
	    		s= s + infix.get(i);
	    		infix.remove(i);
	    		s= s + infix.get(i);
	    		infix.remove(i);
	    		infix.add(i,s);
	    	}
	    }
	    infix.add(" ");
	    th.Statusstack.add(" ");
	    System.out.println("Tokens" + "\t" + "Stack" + "\t" + "Postfix");       	
        for(int i=0; i< th.StatusPostfix.size();i++)
        {       	    	
            System.out.println(infix.get(i) + "\t" + th.Statusstack.get(i) + "\t" + th.StatusPostfix.get(i));       	
        }
        
    }
	
}
