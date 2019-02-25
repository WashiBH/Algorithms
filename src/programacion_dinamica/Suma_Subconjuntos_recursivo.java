package programacion_dinamica;

public class Suma_Subconjuntos_recursivo {

	// Retorna true si existe el subconjunto en set[] con suma igual a sum 
    static boolean isSubsetSum(int set[],int n, int sum) 
    { 
        // Casos Base 
        if (sum == 0) 
            return true; 
        if (n == 0 && sum != 0) 
            return false;
        // Si el ultimo elemento es mayor a sum,entonces se debe ignorar
        if (set[n-1] > sum) 
            return isSubsetSum(set, n-1, sum); 
         /*
          * Caso contrario, observar si la suma puede ser obtenida por alguno de los siguientes pasos:
          * a) Incluyendo el ultimo elemento
          * b) Excluyendo el ultimo elemento
          */
        return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]); 
    } 
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Se encotro el subconjunto con la suma dada"); 
        else
            System.out.println("No se encontro el subconjunto con la suma dada"); 
	}

}
