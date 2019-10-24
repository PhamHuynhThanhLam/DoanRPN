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
       
    }
	
}
