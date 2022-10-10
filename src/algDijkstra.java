public class algDijkstra {
    private String vertInicial;
    private String vertActual;
    
    private int cantidadVertices; //Cantidad de vertices
    private vertices[] listaVertices;
    private String[] vertVisitados; //Registra los vertices visitados en orden
    private float[] sumValoresVertices; //Acomulación de valores para cada vertice

    private float[] matrizAdyacencia;
    
    
    public void algDijkstra(){
        this.vertInicial = "";
        this.vertActual = "";
        this.cantidadVertices = 0;
        this.vertVisitados = new String[0];
        this.sumValoresVertices = new float[0];
        this.matrizAdyacencia = new float[0];
    }
    public void algDijkstra(float[] matrizAdyacencia, int cantidadVertices, vertices[] listaVertices){
        
    }
}
