public class vertices {
    //ATRIBUTOS
    private String nombre;
    private String valor;
    private float posicionVertical;
    private float posicionHorizontal;
    private String sigVertice;          //Nombre del vertice siguiente
    private String antVertice;          //Nombre del vertice anterior
    private int numeracion;             //Posicion en las matrices

    //CONSTRUCTORES
    public vertices(){
        this.nombre = "";
        this.valor = "";
        this.posicionVertical = 0.0f;
        this.posicionHorizontal = 0.0f;
        this.sigVertice = "";
        this.antVertice = "";
        this.numeracion = 0;
    }
    public vertices(String nombre, String valor, float posicionVertical, float posicionHorizontal, String sigVertice, String antVertice, int numeracion){
        this.nombre = nombre;
        this.valor = valor;
        this.posicionVertical = posicionVertical;
        this.posicionHorizontal = posicionHorizontal;
        this.sigVertice = sigVertice;
        this.antVertice = antVertice;
        this.numeracion = numeracion;
    }
    public vertices(vertices vertice){
        this.nombre = vertice.nombre;
        this.valor = vertice.valor;
        this.posicionVertical = vertice.posicionVertical;
        this.posicionHorizontal = vertice.posicionHorizontal;
        this.sigVertice = vertice.sigVertice;
        this.antVertice = vertice.antVertice;
        this.numeracion = vertice.numeracion;
    }

    //ENCAPSULAMIENTO (Set)
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setValor(String valor){
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
    public void setNumeracion(int numeracion){
        this.numeracion = numeracion;
    }

    //ENCAPSULAMIENTO (Get)
    public String getNombre(){
        return this.nombre;
    }
    public String getValor(){
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
    public int getNumeracion(){
        return this.numeracion;
    }
}
