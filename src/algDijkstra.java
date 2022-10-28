import java.util.ArrayList;
import java.util.Scanner;

// DESCRIPCIÓN
//      Clase creada para implementar el Algoritmo de Dijkstra en Java.
//      Consiste en encontrar los caminos mas cercanos de un vertice hacia todos los demas.

public class algDijkstra {
    //ATRIBUTOS
    private static Scanner scan = new Scanner(System.in);

    private String nombreGrafo; // Nombre del grafo
    private String verticeInicial; // Necesario antes de ejecutar el algoritmo
    private String verticeActual; // Utilizado en el proceso
    
    private ArrayList<String> verticesVisitados; // Registra los vertices visitados en orden

    private ArrayList<vertices> listaVertices;
    private ArrayList<aristas> listaAristas;
    
    

    //CONSTRUCTORES
    public algDijkstra(){
        this.nombreGrafo = "";
        this.verticeInicial = "";
        this.verticeActual = "";
        this.verticesVisitados = new ArrayList<String>();
        this.listaVertices = new ArrayList<vertices>();
        this.listaAristas = new ArrayList<aristas>();
    }
    public algDijkstra(String nombre, ArrayList<vertices> listaVertices, ArrayList<aristas> listasAristas){
        this.verticeInicial = "";
        this.verticeActual = "";
        this.verticesVisitados = new ArrayList<String>();

        this.nombreGrafo = nombre;
        this.listaVertices = listaVertices;
        this.listaAristas = listasAristas;
    }
    public algDijkstra(ArrayList<vertices> listaVertices, ArrayList<aristas> listasAristas){
        this.nombreGrafo = "";
        this.verticeInicial = "";
        this.verticeActual = "";
        this.verticesVisitados = new ArrayList<String>();

        this.listaVertices = listaVertices;
        this.listaAristas = listasAristas;
    }
    public algDijkstra(algDijkstra algoritmo){
        this.nombreGrafo = algoritmo.nombreGrafo;
        this.verticeInicial = algoritmo.verticeInicial;
        this.verticeActual = algoritmo.verticeActual;
        this.verticesVisitados = algoritmo.verticesVisitados;
        this.listaVertices = algoritmo.listaVertices;
        this.listaAristas = algoritmo.listaAristas;
    }



    //ENCAPSULAMIENTO (Gets & Sets)
    public String getNombreGrafo(){
        return this.nombreGrafo;
    }
    public void setNombreGrafo(String nombreGrafo){
        this.nombreGrafo = nombreGrafo;
    }
    public ArrayList<vertices> getListaVertices(){
        return this.listaVertices;
    }
    public ArrayList<aristas> getListaAristas(){
        return this.listaAristas;
    }
    public ArrayList<String> getVerticesVisitados(){
        return this.verticesVisitados;
    }
    public String getVerticeInicial(){
        return this.verticeInicial;
    }
    public boolean setVerticeInicial(String verticeInicial){
        if(verticeExistente(verticeInicial)){
            this.verticeInicial = verticeInicial;
            return true;
        }
        else
            return false;
    }



    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //METODOS



    //Volver al estado inicial el algoritmo para su siguiente ejecución
    //  - Limpiara this.verticesVisitados
    //  - Reiniciara el valor (a 0.0f) de todos los vertices en this.listaVertices
    //  - Reiniciara sigVertice (a "") de todos los vertices en this.listaVertices
    //  - Reiniciara antVertice (a "") de todos los vertices en this.listaVertices
    private void estadoInicial(){
        verticesVisitados.clear();

        int cantidadVertices = listaVertices.size();
        for(int i=0; i<cantidadVertices; i++){
            listaAristas.get(i).setValor(0.0f);
            listaVertices.get(i).setSigVertice("");
            listaVertices.get(i).setAntVertice("");
            listaVertices.get(i).setEstado(0);
        }
    }



    //Verificar si un vertice ya existe en this.listaVertices
    //  - Pedira el nombre del vertice
    //  - Buscara el vertice en this.listaVertices
    //  - Devolvera un boolean con el resultado
    public boolean verticeExistente(String nombreVertice){
        boolean resultado = false;
        int numeroVertices = listaVertices.size();

        if(!(nombreVertice.equals("")))
            for(int i=0; i<numeroVertices; i++)
                if(listaVertices.get(i).getNombre().equals(nombreVertice)){
                    resultado = true;
                    break;
                }

        return resultado;
    }



    //Verificar si una adyacencia (arista) ya existe en this.listaAristas por su nombre
    //  - Pedira el nombre de la arista
    //  - Buscara la adyacencia en this.listaAristas
    //  - Devolvera un boolean con el resultado
    public boolean adyacenciaExistente(String nombre){
        boolean resultado = false;
        int cantidadAdyacencias = listaAristas.size();

        //Comprobar si el nombre se repite
        if(!(nombre.equals("")))
            for(int i=0; i<cantidadAdyacencias; i++)
                if(listaAristas.get(i).getNombre().equals(nombre)){
                    resultado = true;
                    break;
                }

        return resultado;
    }
    //Verificar si una adyacencia (arista) ya existe en this.listaAristas por sus vertices
    //  - Pedira el nombre de la arista
    //  - Buscara la adyacencia en this.listaAristas
    //  - Devolvera un boolean con el resultado
    public boolean adyacenciaExistente(String nombreVertice1, String nombreVertice2){
        boolean resultado = false;
        int cantidadAdyacencias = listaAristas.size();

        if(!(nombreVertice1.equals("")) && !(nombreVertice2.equals(""))){
            for(int i=0; i<cantidadAdyacencias; i++){
                String nodoOrigen = listaAristas.get(i).getNodoOrigen();
                String nodoDestino = listaAristas.get(i).getNodoDestino();
                if((nodoOrigen.equals(nombreVertice1) && nodoDestino.equals(nombreVertice2))
                || (nodoOrigen.equals(nombreVertice2) && nodoDestino.equals(nombreVertice1))){
                    resultado = true;
                    break;
                }
            }
        }
        
        return resultado;
    }
    //Verificar si una adyacencia (arista) ya existe en this.listaAristas
    //  - Pedira una arista
    //  - Buscara la adyacencia en this.listaAristas
    //  - Devolvera un boolean con el resultado
    public boolean adyacenciaExistente(aristas adyacencia){
        if(adyacenciaExistente(adyacencia.getNombre())
        || adyacenciaExistente(adyacencia.getNodoOrigen(), adyacencia.getNodoDestino()))
            return true;
        else
            return false;
    }



    //Egregar un nuevo vertice a la lista
    //  - Pedira un vertice o su nombre
    //  - Verificara que no se repita el vertice con su nombre (Función existente)
    //  - Agregara el vertice a this.listaVertices
    //  - Limpiara this.verticesVisitados
    //  - Devolvera un boolean confirmando la acción
    public boolean aggVertice(vertices nuevoVertice){
        if(!(verticeExistente(nuevoVertice.getNombre()))){
            listaVertices.add(nuevoVertice);
            verticesVisitados.clear();
            return true;
        }
        else
            return false;
    }



    //Agregar adyacencia (arista)
    //  - Pedira una arista
    //  - Verificara que los vertices espesificados en la adyacencia existan en this.listaVertices
    //  - Verificara que ambos vertices de la adyacencia no sean el mismo
    //  - Verificara que la adyacencia no exista en this.listaAdyacencia
    //  - Agregara la adyacencia en this.listaAristas
    //  - Limpiara this.verticesVisitados
    //  - Devolvera un boolean confirmando la acción
    public boolean aggAdyacencia(aristas nuevaArista){
        if(!(nuevaArista.getNombre().equals(""))
        && !(adyacenciaExistente(nuevaArista))
        && verticeExistente(nuevaArista.getNodoOrigen())
        && verticeExistente(nuevaArista.getNodoDestino())
        && !(nuevaArista.getNodoOrigen().equals(nuevaArista.getNodoDestino()))){
            listaAristas.add(nuevaArista);
            verticesVisitados.clear();
            return true;
        }
        else
            return false;
    }




    //Eliminar adyacencia
    //  - Pedira el nombre de una arista
    //  - Buscara la adyacencia con el nombre espesificado
    //  - Eliminara la adyacencia
    //  - Limpiara this.verticesVisitados
    //  - Devolvera un boolean confirmando la acción
    public boolean eliminarAdyacencia(String nombreArista){
        boolean resultado = false;
        int cantidadAdyacencias = listaAristas.size();

        if(!(nombreArista.equals("")))
            for(int i=0; i<cantidadAdyacencias; i++)
                if(listaAristas.get(i).getNombre().equals(nombreArista)){
                    this.listaAristas.remove(i);
                    this.verticesVisitados.clear();
                    resultado = true;
                    break;
                }
        
        return resultado;
    }



    //Eliminar adyacencias de un vertice
    //  - Pedira el nombre del vertice
    //  - Buscara todas las adyacencias que incluyan ese vertice
    //  - Eliminara las adyacencias encontradas
    //  - Limpiara this.verticesVisitados
    //  - Devolvera un boolean confirmando la acción
    public boolean eliminarAdyacencias(String nombreVertice){
        boolean resultado = false;

        if(!(nombreVertice.equals("")))
            for(int i=0; i<listaAristas.size(); i++)
                if(listaAristas.get(i).getNodoOrigen().equals(nombreVertice)
                || listaAristas.get(i).getNodoDestino().equals(nombreVertice)){
                    this.listaAristas.remove(i);
                    this.verticesVisitados.clear();
                    i--;
                    resultado = true;
                }

        return resultado;
    }



    //Eliminar un vertice de la lista
    //  - Pedira el nombre del vertice
    //  - Buscara el vertice en this.listaVertices
    //  - Eliminara todas las adyacencias a las que pertenecia el vertice
    //  - Eliminara el vertice de this.listaVertices
    //  - Eliminara el vertice de this.verticeInicial
    //  - Limpiara this.verticesVisitados
    //  - Devolvera un boolean confirmando la acción
    public boolean eliminarVertice(String nombreVertice){
        boolean resultado = false;
        int cantidadVertices = listaVertices.size();

        if(!(nombreVertice.equals("")))
            for(int i=0; i<cantidadVertices; i++){
                String verticeEnFoco = listaVertices.get(i).getNombre();

                if(verticeEnFoco.equals(nombreVertice)){
                    eliminarAdyacencias(nombreVertice);
                    listaVertices.remove(i);
                    if(verticeInicial.equals(verticeEnFoco))
                        verticeInicial = "";
                    verticesVisitados.clear();
                    resultado = true;
                    break;
                }
            }

        return resultado;
    }



    //Ejecutar algoritmo
    //  1. Verificar que existan vertices en this.listaVertices
    //  2. Verificar que existan aristas en this.listaAristas
    //  3. Verificar que exista un vertice inicial
    //  4. Establecera el algoritmo a su estado inicial (función existente)
    //  4. Posicionarse en el vertice actual
    //  5. Registrar los valores de sus vertices adyacentes
    //  6. Escojer la adyacencia con menos peso
    //  7. Posicionarse en el vertice adyacente
    //  8. Registrar en el vertice actual el anterior
    //  9. Volver al paso 4 hasta que se recorran todos los vertices
    public void ejecutar(){
        if(listaVertices.size() > 0
        && listaAristas.size() > 0
        && verticeExistente(this.verticeInicial)){
            estadoInicial();

            int cantidadVertices = listaVertices.size();
            int cantidadAristas = listaAristas.size();

            verticeActual = verticeInicial;
            verticesVisitados.add(verticeInicial);

            //Cantidad de veces que se repetira el paso 4
            for(int i=0; i<cantidadVertices; i++){

                float valorVerticeActual = 0.0f;

                // El vertice actual se establece como visitado
                for(int j=0; j<cantidadVertices; j++)
                    if(listaVertices.get(j).getNombre().equals(verticeActual)){
                        listaVertices.get(j).setEstado(2);
                        valorVerticeActual = listaVertices.get(j).getValor();
                        break;
                    }


                //Se buscan las adycencias con el vertice actual
                for(int j=0; j<cantidadAristas; j++){
                    String nodoOrigen = listaAristas.get(j).getNodoOrigen();
                    String nodoDestino = listaAristas.get(j).getNodoDestino();
                    String nodoAdyacente = "";

                    if(nodoOrigen.equals(verticeActual))
                        nodoAdyacente = nodoDestino;
                    else if(nodoDestino.equals(verticeActual))
                        nodoAdyacente = nodoOrigen;

                        
                    
                    // Si se encontro un vertice adyacente
                    if(!(nodoAdyacente.equals(""))){
                        for(int k=0; k<cantidadVertices; k++){

                            // Se busca en this.listaVertices
                            if(listaVertices.get(k).getNombre().equals(nodoAdyacente)){
                                float valorCaminoActual = valorVerticeActual + listaAristas.get(j).getValor();

                                switch(listaVertices.get(k).getEstado()){

                                    // Si no a sido visitado
                                    case 0:{
                                        // Se marca como pendiente
                                        listaVertices.get(k).setEstado(1);
                                        // Se guarda el vertice por el que se llego a el
                                        listaVertices.get(k).setAntVertice(verticeActual);
                                        // Y se guarda el valor necesario para llegar hasta él por el camino actual
                                        listaVertices.get(k).setValor(valorCaminoActual);
                                        break;
                                    }

                                    // Si quedo pendiente
                                    case 1:{
                                        // Se compara el coste del camino actual con el registrado en el vertice
                                        // Si resulta mas barato el actual
                                        if(listaVertices.get(k).getValor() > valorCaminoActual){
                                            // Se incorpora al camino actual
                                            listaVertices.get(k).setAntVertice(verticeActual);
                                            // Se le asigna su nuevo valor
                                            listaVertices.get(k).setValor(valorCaminoActual);
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }


                int nodoMasBarato = -1;
                float menorValor = 0.0f;
                // Se compara el valor de todos los vertices con estado pendiente
                for(int j=0; j<cantidadVertices; j++){
                    if(listaVertices.get(j).getEstado() == 1 /* 1: Pendiente */){
                        float valorAct = listaVertices.get(j).getValor();

                        // En el caso de ser el primer vertice se toman como referencia su valor
                        if(nodoMasBarato == -1){
                            nodoMasBarato = j;
                            menorValor = valorAct;
                        }
                        // Si es mas barato este vertice que el de referencia, ahora sera la referencia
                        // Asi hasta optener el vertice pendiente mas barato
                        else if(valorAct < menorValor){
                            menorValor = valorAct;
                            nodoMasBarato = j;
                        }
                    }
                }

                // Si se encontraron vertices pendientes
                if(nodoMasBarato != -1){
                    // Se seleccionara el vertice pendiente con la ruta de menor valor o peso
                    // Para eso:

                    String nomVert = listaVertices.get(nodoMasBarato).getNombre();
                    // Se cambia el vertice actual
                    verticeActual = nomVert;
                    verticesVisitados.add(nomVert);
                }
            }
        }
    }



    //Encontrar camino mas cercano del vertice inicial a otro
    //  1. Verificar que exista un vertice inicial
    //  2. Verificar que ya se haya ejecutado el algoritmo
    //  3. Posicionarse en el vertice final
    //  4. Verificar que el vertice actual tenga antVertice
    //  5. Posicionarse en antVertice
    //  6. Registrar recorrido en un vector
    //  7. Volver al paso 4 hasta posicionarse en el vertice inicial
    //  8. Devolver el vector de recorrido
    public ArrayList<String> caronte(String nombreVertice){
        ArrayList<String> caminoVertices =  new ArrayList<String>();

        if(verticeExistente(this.verticeInicial)
        && this.verticesVisitados.size() > 0
        && verticeExistente(nombreVertice)){
            int cantidadVertices = listaVertices.size();
            String verticeActual = nombreVertice;

            while(!(verticeActual.equals(this.verticeInicial))){
                
                for(int i=0; i<cantidadVertices; i++){
                    if(listaVertices.get(i).getNombre().equals(verticeActual)){
                        if(!(listaVertices.get(i).getNombre().equals(nombreVertice)))
                            caminoVertices.add(listaVertices.get(i).getNombre());
                        verticeActual = listaVertices.get(i).getAntVertice();
                        break;
                    }
                }
            }
        }

        return caminoVertices;
    }
}
