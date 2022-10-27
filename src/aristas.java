public class aristas {
    //ATRIBUTOS
    private String nombre;
    private float valor;
    private String nodoOrigen; 
    private String nodoDestino;



    //CONSTRUCTORES
    public aristas(){
        this.nombre = "";
        this.valor = 0.0f;
        this.nodoOrigen = "";
        this.nodoDestino = "";
    }
    public aristas(String nombre, float valor, String nodoOrigen, String nodoDestino){
        this.nombre = nombre;
        this.valor = valor;
        this.nodoOrigen = nodoOrigen;
        this.nodoDestino = nodoDestino;
    }
    public aristas(aristas arista){
        this.nombre = arista.nombre;
        this.valor = arista.valor;
        this.nodoOrigen = arista.nodoOrigen;
        this.nodoDestino = arista.nodoDestino;
    }



    //ENCAPSULAMIENTO (SETs & GETs)
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public void setNodoOrigen(String nodoOrigen){
        this.nodoOrigen = nodoOrigen;
    }
    public void setNodoDestino(String nodoDestino){
        this.nodoDestino = nodoDestino;
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getValor(){
        return this.valor;
    }
    public String getNodoOrigen(){
        return this.nodoOrigen;
    }
    public String getNodoDestino(){
        return this.nodoDestino;
    }



    //OTROS METODOS

    //Verificar repetición entre la arista actual y otra
    //  1. Pide dos aristas
    //  2. Compara los atributos a excepción del nombre
    //  3. Devuelve con un boolean su semejanza
    public boolean verificarRepeticion(aristas arista){
        if((this.nodoOrigen==arista.nodoOrigen && this.nodoDestino==arista.nodoDestino)
        || (this.nodoOrigen==arista.nodoDestino && this.nodoDestino==arista.nodoOrigen))
            return true;
        else
            return false;
    }
}
