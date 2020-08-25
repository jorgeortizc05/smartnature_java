package jorgeortiz.smartnature.dao;

import java.util.Scanner;

public class Promedio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner recibir = new Scanner(System.in);
        int array[] = new int[5];
        
        //Guardo las notas en un array
        for(int i = 0; i < 5; i ++){
            System.out.println("Ingrese nota "+(i+1));
            int valor = recibir.nextInt();
            if(valor >= 1 && valor <= 10) {
            	array[i] = valor;
            }else {
            	System.out.println("No es una nota");
            	break;
            }

        }
        
        //Leo los archivos
        int promedio = 0;
        int mayor, menor;
        mayor = menor = array [0];
        
        System.out.println("Notas: ");
        for(int i = 0; i < array.length; i ++){
            
            System.out.print(array[i]+ " ");
            promedio = promedio + array[i];
            if(array [i] > mayor) {
                mayor = array[i];
            }
            if(array[i]<menor) {
                menor = array[i];
            }
        }
        
        System.out.println();
        System.out.println("Promedio: " + (promedio/5));
        System.out.println("El mayor valor es: "+mayor);
        System.out.println("El menor valor es: "+menor);
	}

}
