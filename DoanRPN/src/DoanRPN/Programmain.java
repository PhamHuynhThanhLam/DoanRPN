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
		

		System.out.println("Nhap phep tinh can tinh : " );
		InputStreamReader ips=new InputStreamReader(System.in);   
    	BufferedReader br=new BufferedReader(ips);
    	bieuthuc = br.readLine(); 
		
    	bieuthuc = th.Chuanam(bieuthuc);
    	elementMath = th.ChuanHoa(bieuthuc);

    	if(th.Kiemtrahople(elementMath) == 1)
    	{
    		  doi = th.chuyendoi(elementMath);

    		  for(int i=0; i<doi.length ; i++)
    		  {
    			  
    			System.out.print(doi[i]);	
    		  }
    		  System.out.println();    
    		  double k = th.Xuatkq(doi);
    		  System.out.println("Ket qua phep tinh: " + bieuthuc + "=" + k);
	    }
    	else 
    	{
			System.out.println("Bieu thuc nhap sai");
		}
    	
    }
	
}
