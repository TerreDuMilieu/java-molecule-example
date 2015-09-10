package yose.primeFactor;

import java.util.ArrayList;
import java.util.List;


public class PrimeFactor {
	public static Integer [] calcPow2(int numberToDecompose){
		List <Integer> listPrimeFactor = new ArrayList<Integer>();
		int [] tabFactPremier=new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23};
		
		int factorPrime;
		for(int i=0; i<tabFactPremier.length; i++){
			factorPrime = tabFactPremier[i];
			numberToDecompose=NbFacteurPremier(listPrimeFactor,factorPrime, numberToDecompose);
			if(numberToDecompose==1) break;
		}
		
		return  listPrimeFactor.toArray(new Integer [listPrimeFactor.size()]) ;
	}
	
	static int NbFacteurPremier(List <Integer> listPrimeFactor, int p, int x)
	{
		while(x%p==0) {
			listPrimeFactor.add(p);
			x=x/p;	
		}
		
		return x;
	}
	

}