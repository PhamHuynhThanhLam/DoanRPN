package DoanRPN;

public class Operator 
{
	public String kitu;
	public int douutien;
    
	public String getkitu()
	{
		return kitu;
	} 
    
    public int getdouutien()
	{
		return douutien;
	} 
 
    public Operator()
    {
    	
    }
    
    public Operator(String kitu, int douutien)
    {
    	super();
    	this.kitu = kitu;
    	this.douutien = douutien;
    } 
    
    public void Chuoi(String elementMath)
	{
    	this.kitu = elementMath;
		int kt = GetPriority(elementMath);
		this.douutien = kt;
	}
    
    public String[] xetdouutien(String elementMath)
   	{
    	String[] arrary = new String[2];
   		arrary[0] = elementMath;
   		int kt = GetPriority(elementMath);
   		arrary[1] = String.valueOf(kt);
   		return arrary;
   	}
    
    public boolean sosanh(Operator a, Operator b)     
    {      
    	double value1 = (double)a.getdouutien(); 
    	double value2 = (double)b.getdouutien();   
    	return value1 <= value2;     
    } 
          
    public static int GetPriority(String op)
    {
        if (op.equals("sin") || op.equals("cos") || op.equals("tan") || op.equals("cotg") || op.equals("ln") || op.equals("log") || op.equals("sqrt"))
            return 3;
        if (op.equals("*") || op.equals("/") || op.equals("^"))
            return 2;
        if (op.equals("+") ||op.equals ("-"))
            return 1;
        return 0;
    }

}
