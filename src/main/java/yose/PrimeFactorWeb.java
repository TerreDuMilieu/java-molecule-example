package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import yose.primeFactor.PrimeFactor;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class PrimeFactorWeb {
    private final Gson gson;
    private String strparam="";
    
    public PrimeFactorWeb(Gson gson) {
        this.gson = gson;
    }

    public void Decomposition(Request request, Response response) throws Exception {
    	strparam=request.parameter("number");
    	response.contentType(JSON).body(gson.toJson(new Decomposition(Integer.parseInt(strparam))));
    	
    }
/*
 * 
 * 
 * {
    "number" : 16,
    "decomposition" : [ 2, 2, 2, 2 ]
}
 * 
 */
    public static class Decomposition {
    	final int number;
    	final Integer[] decomposition;
    	
;    	Decomposition(int parm)
    	{
    		   number  = parm ;
    	       // public final String str "\n" ;
    	       decomposition = PrimeFactor.calcPow2(parm);	
    		
    	}
      
    }
}


