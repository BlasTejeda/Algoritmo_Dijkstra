import java.util.Scanner;

//DESCRIPCIÓN
//  Clase usada para validar la captura de datos por medio de alfabetos.

public class capturaDatos {
    // ATRIBUTOS
    private char[] alfabeto;
    


    // CONSTRUCTORES
    public capturaDatos(){
        this.alfabeto = new char[0];
    }
    public capturaDatos(char[] alfabeto){
        this.alfabeto = alfabeto;
    }



    // METODOS

    // Devuelve una cadena con la longitud indicada y consistente con el alfabeto
    // En caso de devolver una cadena vacia quiere decir que la cadena ingresada es invalida.
    public String capturar(int caracteresMax){
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();

        int longitudNombre = nombre.length();
        int longitudAlfabeto = alfabeto.length;

        if(longitudNombre <= caracteresMax){
            // Recorrido en todos los caracteres de la cadena
            for(int i=0; i<longitudNombre; i++){
                char caracterActual = nombre.charAt(i);
                boolean exito = false;

                // Recorrido en todos los caracteres del alfabeto
                for(int j=0; j<longitudAlfabeto; j++){
                    if(caracterActual == alfabeto[j]){
                        exito = true;
                        break;
                    }
                }
                
                if(!exito){
                    nombre = "";
                    break;
                }
            }
        }
        else nombre = "";

        return nombre;
    }
}
