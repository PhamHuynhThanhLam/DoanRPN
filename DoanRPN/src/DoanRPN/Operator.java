package DoanRPN;


public class Operator
{
	public char kitu;
	public int douutien;
    
	public char getkitu()
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
    
    public Operator(char kitu, int douutien)
    {
    	super();
    	this.kitu = kitu;
    	this.douutien = douutien;
    } 
    
    public void Chuoi(char elementMath)
	{
    	this.kitu = elementMath;
		int kt = GetPriority(elementMath);
		this.douutien = kt;
	}
    
    public Character[] xetdouutien(char elementMath)
   	{
    	Character[] arrary = new Character[2];
   		arrary[0] = elementMath;
   		int kt = GetPriority(elementMath);
   		arrary[1] = (char)kt;
   		return arrary;
   	}
    
    public boolean sosanh(Operator a, Operator b)     
    {      
    	double value1 = (double)a.getdouutien(); 
    	double value2 = (double)b.getdouutien();   
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
