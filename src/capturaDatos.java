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


    
    /*
     * REGLAS
     * 1. Ingresar un número (longitud máxima de 11 caracteres)
     * 2. Después de ingresar un número, puede ingresar un .
     * 3. Una vez ingresado el ., no lo puede volver a usar
     * 4. Si se ingresa un punto, puede ingresar dos numeros cómo máximo.
    */
    public String capturarNumero(){
        Scanner scan = new Scanner(System.in);
        String numero = scan.nextLine();
        int longitud = numero.length();
        int estado = 0;

        /*
         * se maneja 1 sola longitud, ya que el alfabeto tiene 11 caracteres (0-9 y ".") 
         * y la longitud máxima de la cadena es de 11 caracteres (8 enteros, ., 2 decimales)
         */

        // Verificar que el numero ingresado sea de la longitud máxima
        if(longitud <= 11){

            // Revisar cada caracter de la cadena (del numero)
            for(int i = 0; i<longitud; i++){
                char caracterAct = numero.charAt(i);

                switch(estado){
                    case 0: {
                        if(esNumero(caracterAct))
                            estado = 1;
                        else
                            numero = "";
                        
                        break;
                    }
                    case 1: {
                        if(esNumero(caracterAct) && i<8)
                            estado = 1;
                        else if(caracterAct == '.')
                            estado = 2;
                        else
                            numero = "";

                        break;
                    }
                    case 2: {
                        if(esNumero(caracterAct))
                            estado = 3;
                        else
                            numero = "";
                        
                        break;
                    }
                    case 3: {
                        if(i != longitud-1 || !esNumero(caracterAct))
                            numero = "";

                        break;
                    }
                }

                if(numero.equals("")) break;
            }

            if(!(estado==1 || estado==3))
                numero = "";

        }else numero = "";

        return numero;
    }

    // Comprueba que un caracter este dentro del alfabeto numerico
    public boolean esNumero(char caracter){
        char[] alfabetoNumerico = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int cantidadNumeros = alfabetoNumerico.length;
        boolean exito = false;

        for(int i=0; i<cantidadNumeros; i++){
            if(caracter == alfabetoNumerico[i]){
                exito = true;
                break;
            }
        }

        return exito;
    }
}