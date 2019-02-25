package programacion_dinamica;

public class Suma_Subconjuntos_dp {

	// Retorna true si existe el subconjunto en set[] con suma igual a sum 
    static boolean isSubsetSum(int set[],int n, int sum) 
    { 
    	/*
    	 * El valor de subset[i][j] sera true
    	 * si existe un subset de set[0..j-1] 
    	 * con suma igual a i
    	 */
    	
        boolean subset[][] = new boolean[sum+1][n+1]; 
      
        // Si sum==0, entonces la respuesta es true
        for (int i = 0; i <= n; i++) 
            subset[0][i] = true; 
        
        // Si sum!=0 y set esta vacio entonces la respuesta es false
        for (int i = 1; i <= sum; i++) 
            subset[i][0] = false; 
        //========================================
        for(int i=0;i<n;i++) {
        	if(i==0) System.out.print(" ");
        	System.out.print(" "+set[i]);
        }
        for (int i = 0; i <=sum; i++) 
        {
        	System.out.println();
        	System.out.print(i);
	        for (int j = 0; j <= n; j++) {
	        	if(subset[i][j])
	        		System.out.print(" t");
	        	else
	        		System.out.print(" f");
	        } 
        }
        //==========================================
        //Llenar la tabla subset de abajo hacia arriba
        for (int i = 1; i <= sum; i++) 
        { 
            for (int j = 1; j <= n; j++) 
            { 
                subset[i][j] = subset[i][j-1]; 
                if (i >= set[j-1]) 
                	subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1]; 
            } 
        } 
      
        // descomentar este codigo para imprimir la tabla
      //========================================
        System.out.println();
        System.out.println("Solucion");
        for(int i=0;i<n;i++) {
        	if(i==0) System.out.print(" ");
        	System.out.print(" "+set[i]);
        }
        for (int i = 0; i <=sum; i++) 
        {
        	System.out.println();
        	System.out.print(i);
	        for (int j = 0; j <= n; j++) {
	        	if(subset[i][j])
	        		System.out.print(" t");
	        	else
	        		System.out.print(" f");
	        } 
        }
        //==========================================
        System.out.println();
        return subset[sum][n]; 
    }
    static boolean other(int set[],int n, int sum) {
    	boolean subset[][] = new boolean[n+1][sum+1];
    	
    	return subset[n][sum];
    }
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Se encontro el subconjunto con la suma dada"); 
        else
            System.out.println("No se encontro el subconjunto con la suma dada"); 
	}
	
}
