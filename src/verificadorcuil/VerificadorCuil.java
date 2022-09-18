package verificadorcuil;
import java.io.*;
import java.util.Scanner;

public class VerificadorCuil {
	
	
	

public static void main(String[] args ){
	long cadena, cadena_aux = 0;
	int verificacion=0, acumulador= 0;
	int [] dni = new int[11];
	int [] factor = new int[10];
	
	factor [0] = 5; factor [1] = 4; factor [2] = 3; factor [3] = 2; factor [4] = 7; factor [5] = 6; factor [6] = 5; factor [7] = 4; factor [8] = 3; factor [9] = 2;
	
	PrintWriter salida = null;
	
	try{
		
		Scanner sc = new Scanner(new File("Input.txt"));
		
		while(sc.hasNextLine()==true ){
			cadena_aux = cadena = sc.nextLong();
			
			if(Long.toString(cadena).length()==11){
				
			for(int i = 10 ; i >= 0 ; i--){
				dni [i] = (int) (cadena%10);
				cadena = cadena/10;
			}
			for(int i = 0 ; i < 10 ; i++){
				acumulador = acumulador + (dni[i]*factor[i]);	
			}
			verificacion = 11-acumulador%11;
			if(verificacion==10) verificacion = 9;
			
			if(verificacion == dni[10]){
				String miPath="C:\\Users\\agust\\Desktop\\Facultad\\POO\\WorkSpace\\015_VerificadorCuil\\src\\verificadorcuil\\";
				salida=new PrintWriter(new FileWriter(miPath+"Output.txt", true));
				salida.println("El cuil ingresado  ["+cadena_aux+"] es [CORRECTO]");
				salida.close();
			}else{
				String miPath="C:\\Users\\agust\\Desktop\\Facultad\\POO\\WorkSpace\\015_VerificadorCuil\\src\\verificadorcuil\\";
				salida=new PrintWriter(new FileWriter(miPath+"Output.txt", true));
				salida.println("El cuil ingresado  ["+cadena_aux+"] es [INCORRECTO] \n El Digito verificador debería ser: ["+verificacion+"]");
				salida.close();
				
			}
		
			
			
		}else{
			String miPath="C:\\Users\\agust\\Desktop\\Facultad\\POO\\WorkSpace\\015_VerificadorCuil\\src\\verificadorcuil\\";
			salida=new PrintWriter(new FileWriter(miPath+"Output.txt", true));
			salida.println("El cuil ["+cadena_aux+"] es INVALIDO");
			salida.close();
			
		}
	}
		
		
		
	}catch(Exception e){
		System.out.println("Error: "+ e.getMessage());
		
	}finally {
		if (salida != null)
			salida.close();
	}
	
	
}	
}