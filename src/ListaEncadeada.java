public class ListaEncadeada<T>{
    private NoLista<T> primeiro;
   
    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista getPrimeiro() {
        return primeiro;
    }
    
   
    public void inserir(T valor){
        NoLista<T> novo = new NoLista<>(); 
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }
    
    public boolean estaVazia(){
        if (!primeiro.equals(null)) {
            return false;
        }else {return true;}
    }


    public NoLista<T> buscar(T valor){
        NoLista<T> p = primeiro;
        while (p != null){
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }


    public void retirar(T valor){
        NoLista<T> anterior = null; 
        NoLista<T> p = primeiro;
        while((p != null) && (!p.getInfo().equals(valor))){
           anterior = p; 
           p = p.getProximo();
        }

        if (p != null){
            if (p.equals(primeiro)){
                this.primeiro = p.getProximo(); 
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }
     

    public int obterComprimento(){
      int count = 0; 
      NoLista<T> p = primeiro;
      while (p != null){
          count++;
          p = p.getProximo();
      }       
      return count;
        
    }

    public NoLista<T> obterNo(int idx){      
      /*int comprimento = obterComprimento(); 

      if((idx < 0) || idx >= comprimento){
        throw new IndexOutOfBoundsException();
      }

    

      NoLista<T> no = primeiro; 

      int sequencia = 0;
      while((no != null) && (sequencia < idx)){
         sequencia++; 
         no = no.getProximo(); 
      } 

      return no; */ 


      if(idx < 0){
          throw new IndexOutOfBoundsException(); 
      }
      NoLista<T> no = primeiro; 

      while((no != null) && (idx > 0 )){
        idx--; 
        no = no.getProximo(); 
     } 
      
     if(no == null){
        throw new IndexOutOfBoundsException(); 
     }
      
      return no;
    }

    @Override
    public String toString() {
        String resultado = ""; 
        NoLista<T> no = primeiro; 

        while (no != null) {
            if(no != primeiro){
                resultado = resultado + ",";
            }

            resultado = resultado + no.getInfo().toString(); 
            no = no.getProximo();
            
        }

        return resultado;
    }

    

    

}
