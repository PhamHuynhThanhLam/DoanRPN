package DoanRPN;


public class Toantu 
{

	public String[] Chuoi(char elementMath)
	{
		String[] myArray = new String[3];
		String a= String.valueOf(elementMath);
			myArray[0]= a;
		int kt;
		String b;
		kt = GetPriority(elementMath);
		b=String.valueOf(kt);
		myArray[1]= b;
		return myArray;
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
