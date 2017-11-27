package wtp;

import java.util.Arrays;

public class Matriz {

	public static long[][] agregarNodo(long[][] matriz){
		/*System.out.println(Arrays.deepToString(matriz));
		System.out.println(matriz[m][n]);*/
		long [][] nuevaMatriz = new long[matriz.length+1][matriz.length+1];
		for (int i=0;i<nuevaMatriz.length;i++){
			for (int j=0;j<nuevaMatriz.length;j++){
				if (i==matriz.length && j == matriz.length)
					nuevaMatriz[i][j]=0;
				else if ((i!=matriz.length && j==matriz.length)||(i==matriz.length && j!=matriz.length)){
					long camino = (long) (Math.random() * 11);
					if (camino == 0)
						nuevaMatriz[i][j]=1000000000;
					else
						nuevaMatriz[i][j]=camino;
				}
				else{
					nuevaMatriz[i][j]=matriz[i][j];
				}
			}
		}
		return nuevaMatriz;
	}
	
}
