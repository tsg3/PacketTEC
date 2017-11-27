package wtp;

import java.util.Arrays;

public class Test {
	public static void main(String [] args){
		long matrizA[][]={{0,3,4,1000000000},{1000000000,0,1000000000,1000000000},{1000000000,1000000000,0,7},{1000000000,1000000000,1000000000,0}};
		System.out.println(Arrays.deepToString(matrizA));
		System.out.println();
		CaminosMinimos ruta = new CaminosMinimos();
		System.out.println(ruta.algoritmoFloyd(matrizA));
		System.out.println("-------------------------------");
		matrizA=Matriz.agregarNodo(matrizA);
		System.out.println(Arrays.deepToString(matrizA));
		System.out.println();
		System.out.println(ruta.algoritmoFloyd(matrizA));
	}
}
