package primeFactor;
import java.util.Vector;

public class PrimeFactor {
	static String calcPow2(int x){
	//	int [] tab=new int[]{2,2};
	//	 Vector<Integer> tabFactPremier= new Vector<Integer>();
		String strPuissance="";
		// Vector<Integer> nbPuissance= new Vector<Integer>();
		int nbPuissance=0; //Compte simplement le nombre de puissance
		
		while(x%2==0)
		{
		// nbPuissance++;
		 strPuissance+="2";
		 x=x/2;	
		}
			
			
		return strPuissance ;
	}

}
