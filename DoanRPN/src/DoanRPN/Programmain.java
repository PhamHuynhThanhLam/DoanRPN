package DoanRPN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmain
{		
	public static void main(String[] args) throws IOException
	{
		String bieuthuc, elementMath[] = null;
		String doi[] = null; 
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
             
        elementMath = th.ChuanHoa(bieuthuc);
        doi = th.chuyendoi(elementMath);
        System.out.println("Chuoi infix to postfix");
    	for(int i=0; i<doi.length ; i++)
    	{    			  
    	    System.out.print(doi[i]);	
    	}
    		
    	System.out.println();    
        String k = th.Xuatkq(doi);
        System.out.println("Ket qua phep tinh: " + bieuthuc + " : " + k);  	
    }
	
}
