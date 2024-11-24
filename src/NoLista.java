public class NoLista<T> { // parametro para a classe, identificador do parametro 
    private T info; 
    private NoLista<T> proximo;

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoLista getProximo() {
        return proximo;
    }
    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }  

    
}
