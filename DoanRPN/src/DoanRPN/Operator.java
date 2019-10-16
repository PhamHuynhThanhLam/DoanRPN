package DoanRPN;


public class Operator
{
	protected char kitu;
	protected int douutien;
    
	public char getkitu()
	{
		return kitu;
	} 
 
    public void setkitu(char kitu)
    {
    	this.kitu = kitu;
    } 
    public int getdouutien()
	{
		return kitu;
	} 
 
    public void setdouutien(int douutien)
    {
    	this.douutien = douutien;
    } 
 
    public Operator()
    {
    	
    }
    
    public Operator(char kitu, int douutien)
    {
    	super();
    	this.kitu = kitu;
    	this.douutien = douutien;
    } 
    
    public void Chuoi(char elementMath)
	{
    	kitu = elementMath;
		int kt = GetPriority(kitu);
		douutien = kt;
	}
    
    public boolean sosanh(Operator a, Operator b)     
    {      
    	double value1 = (double)a.douutien; 
    	double value2 = (double)b.douutien;   
    	return value1 <= value2;     
    } 
    
        
	public static int GetPriority(char op)
    {	
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else return 0;
    }

}
