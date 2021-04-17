import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author Javier Aguilar, 20611 
 * @version 16/04
 * No olvidar colocar las direcciones de los archivos a utilizar en su espacio corresondiente 
 * Diccionario: fila 102
 * Texto: fila 122
 */
public class Main {

    public static String Idioma;
    public static String IdiomaTraducido;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree<Association> Arbol = new BinaryTree<Association>();
        int opc1=0,opc2=0;
        boolean Iterador = false;
        boolean Iterador2=false;
        
        while (!Iterador){
        	try {
        		// Menu del sistema para que el usuario escoja el idioma a traducir de la frase  
        		System.out.println("*   Binevenido a uno de los mejores traductores del mundo   *\n");
                System.out.println("****        Traductor hecho de Arboles binarios         *****\n");
        	     System.out.println("Ingrese una opcion: ");
        	     System.out.println("\n1. Ingles\n2. Español\n3. Frances");
        	        
                opc1=scan.nextInt();
            switch(opc1) {
                // Se manda a eleccion del usuiario a la clase de comparador de palabras 
            	case 1:
            		Idioma="ingles";
            		Iterador=true;
            		break;
            	case 2:
            		Idioma="español";
            		Iterador=true;
            		break;
            	case 3:
            		Idioma="frances";
            		Iterador=true;
            	default:
            		System.out.println("Lo sentimos, sobrepaso el numero de opciones");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado no es numerico\n");
        	scan.next();
        
        	}
        
        }

    
        scan.nextLine();
        Iterador2=false;
        while (!Iterador2){
        	try {
        	     System.out.println("Ingrese una opcion a la cual desea traducir el texto: ");
        	     System.out.println("\n1 Ingles\n2 Español\n3 Frances");
        	        
                opc2=scan.nextInt();
            switch(opc2) {
            	case 1:
            		IdiomaTraducido="ingles";
            		Iterador2=true;
            		break;
            	case 2:
            		IdiomaTraducido="español";
            		Iterador2=true;
            		break;
            	case 3:
            		IdiomaTraducido="frances";
            		Iterador2=true;
            		break;
            	default:
            		System.out.println("Lo sentimos, sobrepaso el numero de opciones");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado no es numerico\n");
        	scan.next();
        
        	}
        }

        try {
            // Aqui se separa por palabras para el arbol para luego asi comparalo 
            // AQUI SE COLOCA LA DIRECCION EN DONDE ESTA UBICADO SU DICCIONARO A COMPARAR
            //IMPORTANTE COLOCARLO COMPLETO
            File myObj = new File("C:\\Users\\Usuario\\OneDrive - Universidad del Valle de Guatemala\\Semestre 3\\Estructura de Datos\\H.T 7\\HT7.1\\HDT7-EstructuraDatos-main\\Diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                 Association word = new  Association(words[0],words[1],words[2]);
              
                Arbol.add(word);
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR, BUSCA BIEN EL ARCHIVO :).");
            e.printStackTrace();
        }

        try {
            // se lee el texto a comparar 
            // AQUI SE COLOCA LA DIRECCION EN DONDE ESTA UBICADO SU TEXTO A TRADUCIR
            //IMPORTANTE COLOCARLO COMPLETO
            File myObj = new File("C:\\Users\\Usuario\\OneDrive - Universidad del Valle de Guatemala\\Semestre 3\\Estructura de Datos\\H.T 7\\HT7.1\\HDT7-EstructuraDatos-main\\Texto.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("\nTexto a traducir:");
                System.out.println(data);
                data=data.replace("*","");
                String[] words = data.split(" ");
                for (int i=0;i<words.length;i++){
                    if (Arbol.locate(new  Association(words[i])) != null){
                        words[i] = Arbol.locate(new  Association(words[i])).value.getWord(IdiomaTraducido);
                    }
                }
                data = String.join(" ",words);
                System.out.println("\nTexto traducido:");
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR :), INTENTOLO MAS TRADE.");
            e.printStackTrace();
        }


    }
}
