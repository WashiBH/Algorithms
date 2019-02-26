package programacion_dinamica;

public class Suma_Subconjuntos_dp {
 // Retorna true si existe el subconjunto en set[] con suma igual a sum 
    static boolean isSubsetSum(int set[],int n, int sum) {
    	boolean subset[][] = new boolean[n+1][sum+1];
    	//Retornar true si sum=0
    	for(int i=0;i<=n;i++)
    		subset[i][0]=true;
    	// Si sum!=0 y el conjunto esta vacio entonces la respuesta es false
    	for(int j=1;j<=sum;j++)
    		subset[0][j]=false;
    	//Llenar la tabla subset de abajo hacia arriba
    	for(int j=1;j<=sum;j++) {
    		System.out.println("Para la suma = "+j);
    		for(int i=1;i<=n;i++) {
    			System.out.println("Se evalua para el valor del conjunto = "+set[i-1]);
    			subset[i][j] = subset[i-1][j];
    			if (j >= set[i-1]) {
    				System.out.println(j+" --> "+set[i-1]+" --> "+(j - set[i-1]));
    				subset[i][j] = subset[i][j] || subset[i-1][j - set[i-1]];
    			}
    		}
    	}
    	//========================================
//        System.out.println("Solucion");
//        for(int i=0;i<=sum;i++) {
//        	if(i==0) System.out.print(" ");
//        	System.out.print(" "+i);
//        }
//        for (int i = 0; i <=n; i++) 
//        {
//        	System.out.println();
//        	System.out.print(i);
//	        for (int j = 0; j <= sum; j++) {
//	        	if(subset[i][j])
//	        		System.out.print(" t");
//	        	else
//	        		System.out.print(" f");
//	        } 
//        }
        //==========================================
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
