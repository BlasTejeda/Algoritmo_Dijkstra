public class vertices {
    //ATRIBUTOS
    private String nombre;
    private float valor;
    private float posicionVertical;
    private float posicionHorizontal;
    private String sigVertice; //Nombre del vertice siguiente
    private String antVertice; //Nombre del vertice anterior
    private  int estado; //En que estado del algoritmo esta (Sin visitar (0), pendiente (1), visitado (2))
    //private boolean adyacencia; //Nos indica si es adyacente a otro vertice



    //CONSTRUCTORES
    public vertices(){
        this.nombre = "";
        this.valor = 0.0f;
        this.posicionVertical = 0.0f;
        this.posicionHorizontal = 0.0f;
        this.sigVertice = "";
        this.antVertice = "";
        this.estado = 0;
        //this.adyacencia = false;
    }
    public vertices(String nombre, float posicionVertical, float posicionHorizontal){
        this.nombre = nombre;
        this.valor = 0.0f;
        this.posicionVertical = posicionVertical;
        this.posicionHorizontal = posicionHorizontal;
        this.sigVertice = "";
        this.antVertice = "";
        this.estado = 0;
        //this.adyacencia = adyacencia;
    }
    public vertices(vertices vertice){
        this.nombre = vertice.nombre;
        this.valor = vertice.valor;
        this.posicionVertical = vertice.posicionVertical;
        this.posicionHorizontal = vertice.posicionHorizontal;
        this.sigVertice = vertice.sigVertice;
        this.antVertice = vertice.antVertice;
        this.estado = vertice.estado;
        //this.adyacencia = vertice.adyacencia;
    }



    //ENCAPSULAMIENTO (SETs & GETs)
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public void setPosicionVertical(float posicionVertical){
        this.posicionVertical = posicionVertical;
    }
    public void setPosicionHorizontal(float posicionHorizontal){
        this.posicionHorizontal = posicionHorizontal;
    }
    public void setSigVertice(String sigVertice){
        this.sigVertice = sigVertice;
    }
    public void setAntVertice(String antVertice){
        this.antVertice = antVertice;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }
    //public void setAdyacencia(Boolean adyacencia){
    //    this.adyacencia = adyacencia;
    //}
    public String getNombre(){
        return this.nombre;
    }
    public float getValor(){
        return this.valor;
    }
    public float getPosicionVertical(){
        return this.posicionVertical;
    }
    public float getPosicionHorizontal(){
        return this.posicionHorizontal;
    }
    public String getSigVertice(){
        return this.sigVertice;
    }
    public String getAntVertice(){
        return this.antVertice;
    }
    public int getEstado(){
        return this.estado;
    }
    //public Boolean getAdyacencia(){
    //    return this.adyacencia;
    //}
}
