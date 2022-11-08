import java.util.ArrayList;
import java.util.Scanner;

public class comprobarAlg {
    // DECLARACIONES
    private static Scanner scan = new Scanner(System.in);
    // Algoritmo de Dijkstra
    private static ArrayList<algDijkstra> listaGrafos = new ArrayList<algDijkstra>();
    // Automata
    private static capturaDatos automata = new capturaDatos();
    private static char[] alfabetoListas = new char[0];
    private static char[] alfabetoNombres = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'Ñ', 'ñ', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', (char)(32)};
    private static char[] alfabetoVertices = new char[0];
    private static char[] alfabetoAristas = new char[0];



    public static void main(String[] args) throws Exception {
        // Intanciamientos
        crearGrafo_MetroSoul();

        // Menu principal
        String respuesta = "";
        do{
            limpiarPantalla();
            System.out.print(
                "..::: ALGORITMO DE DIJKSTRA :::..\n\n" +
                "\t1-. Seleccionar un grafo.\n" +
                "\t2-. Definir un grafo nuevo\n" +
                "\t0-. Salir\n\n" +
                "Seleccion (numero): ");

            // VALIDACIÓN - AUTOMATA
            alfabetoListas = crearAlfabetoLista(2);
            automata = new capturaDatos(alfabetoListas);
            respuesta = automata.capturar(2);

            switch(respuesta){
                // Si quiso seleccionar un grafo ya existente
                case "1":{
                    String respuesta2 = ""; // Grafo seleccionado

                    // Menu de grafos existentes
                    do{
                        limpiarPantalla();
                        System.out.println("..::: GRAFOS DISPONIBLES :::..\n");
                        imprimirListaGrafos();
                        System.out.print(
                            "\t0-. Volver\n\n" +
                            "Seleccion (numero): ");
                        
                        // VALIDACIÓN - AUTOMATA
                        alfabetoListas = crearAlfabetoLista(listaGrafos.size());
                        automata = new capturaDatos(alfabetoListas);
                        respuesta2 = automata.capturar(2);
                        
                        // Si el automata acepto la cadena
                        if(!(respuesta2.equals(""))){
                            int grafoSeleccionado = Integer.parseInt(respuesta2)-1;

                            // Si la respuesta señala un grafo existente
                            if(listaGrafos.size() > grafoSeleccionado && grafoSeleccionado >= 0){
                                alfabetoVertices = obtenerAlfabetoVertices(listaGrafos.get(grafoSeleccionado).getListaVertices());
                                alfabetoAristas = obtenerAlfabetoAristas(listaGrafos.get(grafoSeleccionado).getListaAristas());
                                String respuesta3 = "";
    
                                // Menu de manipulacion de grafo
                                do{
                                    limpiarPantalla();
                                    System.out.println(
                                        "..::: Grafo - [" +
                                        listaGrafos.get(grafoSeleccionado).getNombreGrafo() +
                                        "] :::..");
                                    imprimirOpcionesGrafo();
                                    System.out.print(
                                        "\n\t7-. Encontrar camino minimo\n" +
                                        "\t0-. Volver\n\n" +
                                        "Seleccion (numero): ");
                                    
                                    // VALIDACIÓN - AUTOMATA
                                    alfabetoListas = crearAlfabetoLista(7);
                                    automata = new capturaDatos(alfabetoListas);
                                    respuesta3 = automata.capturar(1);
    
                                    switch(respuesta3){
                                        // Si se decea agregar un vertice al grafo
                                        case "1":{
                                            aggVerticeGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Si se decea eliminar un vertice al grafo
                                        case "2":{
                                            if(listaGrafos.get(grafoSeleccionado).getListaVertices().size() > 0)
                                                eliminarVerticeGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Mostrar todos los vertices incluidos en el grafo
                                        case "3":{
                                            imprimirVerticesGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Si se decea agregar una adyacencia al grafo
                                        case "4":{
                                            aggAdyacenciaGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Si se decea eliminar una adyacencia al grafo
                                        case "5":{
                                            if(listaGrafos.get(grafoSeleccionado).getListaAristas().size() > 0)
                                                eliminarAdyacenciaGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Mostrar todos las adyacencias incluidos en el grafo
                                        case "6":{
                                            imprimirAdyacenciasGrafo(grafoSeleccionado);
                                            break;
                                        }
                                        // Si se decea encontrar el camino minimo de un vertice a otro
                                        case "7":{
                                            caminoMinimoEntre(grafoSeleccionado);
                                            break;
                                        }
                                    }
                                }while(!(respuesta3.equals("0")));

                                alfabetoVertices = new char[0];
                                alfabetoAristas = new char[0];
                            }
                        }
                    }while(!(respuesta2.equals("0")));
                    break;
                }



                case "2":{
                    algDijkstra nuevoAlgoritmo = new algDijkstra();
                    automata = new capturaDatos(alfabetoNombres);
                    String nombreGrafo;

                    do{
                        limpiarPantalla();
                        System.out.println("..::: NUEVO GRAFO :::..\n");
                        System.out.print("Nombre del grafo: ");
                        nombreGrafo = automata.capturar(25); // VALIDACIÓN - AUTOMATA
                    } while(nombreGrafo.equals(""));

                    nuevoAlgoritmo.setNombreGrafo(nombreGrafo);
                    listaGrafos.add(nuevoAlgoritmo);
                    int posicionEnLista = listaGrafos.size()-1;

                    String respuesta2 = "";
                    do{
                        limpiarPantalla();
                        System.out.println("..::: GRAFO - [" + nombreGrafo + "] :::..\n");
                        imprimirOpcionesGrafo();
                        System.out.print(
                            "\n\t7-. Cancelar\n" +
                            "\t0-. Guardar\n\n" +
                            "Seleccion (numero): ");

                        // VALIDACIÓN - AUTOMATA
                        alfabetoListas = crearAlfabetoLista(7);
                        automata = new capturaDatos(alfabetoListas);
                        respuesta2 = automata.capturar(1);

                        switch(respuesta2){
                            // Si se decea agregar un vertice al grafo
                            case "1":{
                                aggVerticeGrafo(posicionEnLista);
                                break;
                            }
                            // Si se decea eliminar un vertice al grafo
                            case "2":{
                                if(listaGrafos.get(posicionEnLista).getListaVertices().size() > 0)
                                    eliminarVerticeGrafo(posicionEnLista);
                                break;
                            }
                            // Mostrar todos los vertices incluidos en el grafo
                            case "3":{
                                imprimirVerticesGrafo(posicionEnLista);
                                break;
                            }
                            // Si se decea agregar una adyacencia al grafo
                            case "4":{
                                aggAdyacenciaGrafo(posicionEnLista);
                                break;
                            }
                            // Si se decea eliminar una adyacencia al grafo
                            case "5":{
                                if(listaGrafos.get(posicionEnLista).getListaAristas().size() > 0)
                                    eliminarAdyacenciaGrafo(posicionEnLista);
                                break;
                            }
                            // Mostrar todos las adyacencias incluidos en el grafo
                            case "6":{
                                imprimirAdyacenciasGrafo(posicionEnLista);
                                break;
                            }
                            // Si se decea encontrar el camino minimo de un vertice a otro
                            case "7":{
                                listaGrafos.remove(posicionEnLista);
                                break;
                            }
                        }
                    }while(!(respuesta2.equals("0") || respuesta2.equals("7")));

                    alfabetoVertices = new char[0];
                    alfabetoAristas = new char[0];

                    break;
                }
            }
        }while(!(respuesta.equals("0")));
    }

    // Limpiar consola
    private static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Imprimir lista de grafos almacenados
    private static void imprimirListaGrafos(){
        int cantidadGrafos =  listaGrafos.size();

        for(int i=0;
            i<cantidadGrafos;
            System.out.print("\t" + (i+1) + "-. " + listaGrafos.get(i).getNombreGrafo() + "\n"),
            i++);
    }

    private static void imprimirOpcionesGrafo(){
        System.out.println(
            "\t1-. Agregar vertice\n" +
            "\t2-. Eliminar vertice\n" +
            "\t3-. Mostrar vertices\n\n" +
            "\t4-. Agregar adyacencia\n" +
            "\t5-. Eliminar adyacencia\n" +
            "\t6-. Mostrar adyacencias");
    }

    private static void aggVerticeGrafo(int posicionGrafo){
        automata = new capturaDatos(alfabetoNombres);
        String nombreVertice;

        do{
            limpiarPantalla();
            System.out.print(
                "..::: AGREGAR VERTICE - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre: ");
            
            nombreVertice = automata.capturar(15);
        } while(nombreVertice.equals(""));

        listaGrafos.get(posicionGrafo).aggVertice(new vertices(nombreVertice));
        alfabetoVertices = obtenerAlfabetoVertices(listaGrafos.get(posicionGrafo).getListaVertices());
    }

    private static void eliminarVerticeGrafo(int posicionGrafo){
        String nombreVertice;
        
        automata = new capturaDatos(alfabetoVertices);
        do{
            limpiarPantalla();
            System.out.print(
                "..::: ELIMINAR VERTICE - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre: ");
    
            nombreVertice = automata.capturar(15);
        } while(nombreVertice.equals(""));

        listaGrafos.get(posicionGrafo).eliminarVertice(nombreVertice);
        alfabetoVertices = obtenerAlfabetoVertices(listaGrafos.get(posicionGrafo).getListaVertices());
    }
    
    private static void aggAdyacenciaGrafo(int posicionGrafo){
        String nombreAdyacencia;
        String valorAdyacencia;
        String nombreVerticeOrigen;
        String nombreVerticeDestino;

        automata = new capturaDatos(alfabetoNombres);
        do{
            limpiarPantalla();
            System.out.print(
                "..::: AGREGAR ADYACENCIA - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre: ");
            nombreAdyacencia = automata.capturar(15);
        } while(nombreAdyacencia.equals(""));

        do{
            limpiarPantalla();
            System.out.print(
                "..::: AGREGAR ADYACENCIA - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Valor (numerico): ");
            valorAdyacencia = automata.capturarNumero();
        } while(valorAdyacencia.equals(""));

        automata = new capturaDatos(alfabetoVertices);
        do{
            limpiarPantalla();
            System.out.print(
                "..::: AGREGAR ADYACENCIA - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre del vertice ORIGEN\n: ");
            nombreVerticeOrigen = automata.capturar(15);
        } while(nombreVerticeOrigen.equals(""));
        do{
            limpiarPantalla();
            System.out.print(
                "..::: AGREGAR ADYACENCIA - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre del vertice DESTINO\n: ");
            nombreVerticeDestino = automata.capturar(15);
        } while(nombreVerticeDestino.equals(""));

        listaGrafos.get(posicionGrafo).aggAdyacencia(new aristas(nombreAdyacencia, Float.parseFloat(valorAdyacencia), nombreVerticeOrigen, nombreVerticeDestino));
        alfabetoAristas = obtenerAlfabetoAristas(listaGrafos.get(posicionGrafo).getListaAristas());
    }

    private static void eliminarAdyacenciaGrafo(int posicionGrafo){
        String nombreAdyacencia;

        automata = new capturaDatos(alfabetoAristas);
        do{
            limpiarPantalla();
            System.out.print(
                "..::: ELIMINAR ADYACENCIA - [" +
                listaGrafos.get(posicionGrafo).getNombreGrafo() +
                "] :::..\n\n" +
                "Nombre: ");

            nombreAdyacencia = automata.capturar(15);
        } while(nombreAdyacencia.equals(""));

        listaGrafos.get(posicionGrafo).eliminarAdyacencia(nombreAdyacencia);
        alfabetoAristas = obtenerAlfabetoAristas(listaGrafos.get(posicionGrafo).getListaAristas());
    }

    private static void caminoMinimoEntre(int posicionGrafo){
        limpiarPantalla();
        System.out.print("..::: CAMINO DE MINIMO :::..\n\n");

        System.out.print("Nodo origen: ");
        String nodoOrigen = scan.nextLine();
        
        System.out.print("Nodo destino: ");
        String nodoDestino = scan.nextLine();

        listaGrafos.get(posicionGrafo).setVerticeInicial(nodoOrigen);
        listaGrafos.get(posicionGrafo).ejecutar();
        ArrayList<String> camino = listaGrafos.get(posicionGrafo).caronte(nodoDestino);

       System.out.println("\n\nRecorrido:\n\t" + camino);
        scan.nextLine();
    }

    private static void imprimirVerticesGrafo(int posicionGrafo){
        limpiarPantalla();
        System.out.println("..::: VERTICES - [" + listaGrafos.get(posicionGrafo).getNombreGrafo() + "] :::..\n");

        int cantVert = listaGrafos.get(posicionGrafo).getListaVertices().size();
        for(int i=0; i<cantVert; i++){
            System.out.println(
                (i+1) + "-. " +
                listaGrafos.get(posicionGrafo).getListaVertices().get(i).getNombre());
        }

        System.out.println();
        scan.nextLine();
    }

    private static void imprimirAdyacenciasGrafo(int posicionGrafo){
        limpiarPantalla();
        System.out.println("..::: ADYACENCIAS - [" + listaGrafos.get(posicionGrafo).getNombreGrafo() + "] :::..\n");

        int cantAristas = listaGrafos.get(posicionGrafo).getListaAristas().size();
        for(int i=0; i<cantAristas; i++){
            System.out.println(
                listaGrafos.get(posicionGrafo).getListaAristas().get(i).getNombre() +
                ": " + listaGrafos.get(posicionGrafo).getListaAristas().get(i).getValor() +
                ", " + listaGrafos.get(posicionGrafo).getListaAristas().get(i).getNodoOrigen() +
                "-" + listaGrafos.get(posicionGrafo).getListaAristas().get(i).getNodoDestino());
        }

        System.out.print("\n");
        scan.nextLine();
    }



    // Verificar si existe un grafo en this.listaGrafos
    private static boolean verificarExistenciaGrafo(String nombreGrafo){
        boolean existencia = false;
        
        if(!(nombreGrafo.equals(""))){
            int cantidadGrafos = listaGrafos.size();

            for(int i=0; i<cantidadGrafos; i++){
                if(listaGrafos.get(i).getNombreGrafo().equals(nombreGrafo)){
                    existencia = true;
                    break;
                }
            }
        }

        return existencia;
    }



    // Crear alfabeto para listas
    private static char[] crearAlfabetoLista(int cantidadOpciones){
        int cant = cantidadOpciones;

        if(cantidadOpciones > 9)
            cant = 9;
        else if (cant < 0)
            cant = 0;
        
        char[] alfabeto = new char[cant+1];
        
        for(int i=0;
            i<=cant && i<10;
            alfabeto[i] = (char)(i+48),
            i++);
        
        return alfabeto;
    }


    // Obtiene el alfabeto de vertices de un algoritmo
    private static char[] obtenerAlfabetoVertices(ArrayList<vertices> listaVertices){
        ArrayList<char[]> listaCaracteres = new ArrayList<char[]>();

        // OBTENCIÓN DE CARACTERES USADOS
        int cantVertices = listaVertices.size();
        for(int i=0; i<cantVertices; i++){
            String nombreVertice = listaVertices.get(i).getNombre();
            int cantCaracteres = nombreVertice.length();

            for(int j=0; j<cantCaracteres; j++){
                int tamañoAlfabeto = listaCaracteres.size();
                char[] nuevoCaracter = {nombreVertice.charAt(j)};

                boolean exito = true;
                for(int k=0; k<tamañoAlfabeto; k++){
                    if(nombreVertice.charAt(j) == listaCaracteres.get(k)[0]){
                        exito = false;
                        break;
                    }
                }

                if(exito) listaCaracteres.add(nuevoCaracter);
            }
        }

        // CREACIÓN DE ALFABETO (Array)
        int tamañoAlfabeto = listaCaracteres.size();
        char[] alfabeto = new char[tamañoAlfabeto];
        for(int i=0; i<tamañoAlfabeto; alfabeto[i] = listaCaracteres.get(i)[0], i++);

        return alfabeto;
    }



    // Obtiene el alfabeto de aristas / adyacencias de un algoritmo
    private static char[] obtenerAlfabetoAristas(ArrayList<aristas> listaAristas){
        ArrayList<char[]> listaCaracteres = new ArrayList<char[]>();

        // OBTENCIÓN DE CARACTERES USADOS
        int cantAristas = listaAristas.size();
        for(int i=0; i<cantAristas; i++){
            String nombreArista = listaAristas.get(i).getNombre();
            int cantCaracteres = nombreArista.length();

            for(int j=0; j<cantCaracteres; j++){
                int tamañoAlfabeto = listaCaracteres.size();
                char[] nuevoCaracter = {nombreArista.charAt(j)};

                boolean exito = true;
                for(int k=0; k<tamañoAlfabeto; k++){
                    if(nombreArista.charAt(j) == listaCaracteres.get(k)[0]){
                        exito = false;
                        break;
                    }
                }

                if(exito) listaCaracteres.add(nuevoCaracter);
            }
        }

        // CREACIÓN DE ALFABETO (Array)
        int tamañoAlfabeto = listaCaracteres.size();
        char[] alfabeto = new char[tamañoAlfabeto];
        for(int i=0; i<tamañoAlfabeto; alfabeto[i] = listaCaracteres.get(i)[0], i++);

        return alfabeto;
    }


    
    // Creación del grafo: METRO DE SOUL
    private static void crearGrafo_MetroSoul(){
        algDijkstra metroSoul = new algDijkstra();
        metroSoul.setNombreGrafo("Metro de Soul");
        metroSoul.aggVertice(new vertices("AA"));
        metroSoul.aggVertice(new vertices("AB"));
        metroSoul.aggVertice(new vertices("BA"));
        metroSoul.aggVertice(new vertices("BB"));
        metroSoul.aggVertice(new vertices("BC"));
        metroSoul.aggVertice(new vertices("BD"));
        metroSoul.aggVertice(new vertices("BE"));
        metroSoul.aggVertice(new vertices("BF"));
        metroSoul.aggVertice(new vertices("CA"));
        metroSoul.aggVertice(new vertices("CB"));
        metroSoul.aggVertice(new vertices("CC"));
        metroSoul.aggVertice(new vertices("CD"));
        metroSoul.aggVertice(new vertices("DA"));
        metroSoul.aggVertice(new vertices("DB"));
        metroSoul.aggVertice(new vertices("DC"));
        metroSoul.aggVertice(new vertices("EA"));
        metroSoul.aggVertice(new vertices("EB"));
        metroSoul.aggVertice(new vertices("EC"));
        metroSoul.aggVertice(new vertices("ED"));
        metroSoul.aggVertice(new vertices("EE"));
        metroSoul.aggAdyacencia(new aristas("arista1", 2, "AA", "AB"));
        metroSoul.aggAdyacencia(new aristas("arista2", 2, "AA", "BE"));
        metroSoul.aggAdyacencia(new aristas("arista3", 4, "AB", "BF"));
        metroSoul.aggAdyacencia(new aristas("arista4", 8, "BA", "CA"));
        metroSoul.aggAdyacencia(new aristas("arista5", 2, "BA", "BB"));
        metroSoul.aggAdyacencia(new aristas("arista6", 3, "BB", "BC"));
        metroSoul.aggAdyacencia(new aristas("arista7", 2, "BC", "BD"));
        metroSoul.aggAdyacencia(new aristas("arista8", 4, "BD", "BE"));
        metroSoul.aggAdyacencia(new aristas("arista9", 8, "BB", "CB"));
        metroSoul.aggAdyacencia(new aristas("arista10", 6, "BC", "CC"));
        metroSoul.aggAdyacencia(new aristas("arista11", 4, "BD", "CD"));
        metroSoul.aggAdyacencia(new aristas("arista12", 2, "BE", "CD"));
        metroSoul.aggAdyacencia(new aristas("arista13", 2, "BE", "BF"));
        metroSoul.aggAdyacencia(new aristas("arista14", 16, "BF", "ED"));
        metroSoul.aggAdyacencia(new aristas("arista15", 12, "BF", "EE"));
        metroSoul.aggAdyacencia(new aristas("arista16", 4, "CA", "CB"));
        metroSoul.aggAdyacencia(new aristas("arista17", 7, "CB", "CC"));
        metroSoul.aggAdyacencia(new aristas("arista18", 1, "CC", "CD"));
        metroSoul.aggAdyacencia(new aristas("arista19", 7, "DA", "DB"));
        metroSoul.aggAdyacencia(new aristas("arista20", 5, "CB", "EA"));
        metroSoul.aggAdyacencia(new aristas("arista21", 3, "DB", "DC"));
        metroSoul.aggAdyacencia(new aristas("arista22", 4, "CC", "DC"));
        metroSoul.aggAdyacencia(new aristas("arista23", 4, "CD", "DC"));
        metroSoul.aggAdyacencia(new aristas("arista24", 3, "DB", "EB"));
        metroSoul.aggAdyacencia(new aristas("arista24", 3, "DB", "EB"));
        metroSoul.aggAdyacencia(new aristas("arista26", 4, "DA", "EA"));
        metroSoul.aggAdyacencia(new aristas("arista27", 4, "EA", "EB"));
        metroSoul.aggAdyacencia(new aristas("arista28", 2, "EB", "EC"));
        metroSoul.aggAdyacencia(new aristas("arista29", 4, "EC", "ED"));
        metroSoul.aggAdyacencia(new aristas("arista30", 2, "ED", "EE"));

        listaGrafos.add(metroSoul);
    }
}
