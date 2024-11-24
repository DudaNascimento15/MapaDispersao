import java.util.Arrays;

public class MapaDispersao<T extends Comparable<T>>{
  private ListaEncadeada<NoMapa<T>> [] info ; 

  public MapaDispersao(int tamanho){
    info =  new ListaEncadeada[tamanho];
  }


  public int calcularHash(int chave){
    int tamanho = info.length;
    return  chave % tamanho;
  }
   

  public void inserir(int chave , T dado){
    int indice = calcularHash(chave); 

    if(info[indice] == null){
        info[indice] = new ListaEncadeada<>(); 
    }
    
    NoMapa<T> noMapa;
    noMapa = new NoMapa<>(); 
    noMapa.setChave(chave);
    noMapa.setInfo(dado);

     info[indice].inserir(noMapa);
  }
  

  public T buscar(int chave){
    int indice = calcularHash(chave); 

    if(info[indice] != null){
        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
         
        NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
        if (noMapa != null) {
           return  no.getInfo().getInfo();
        }
    }
    
    return null;
  }

  public void remover(int chave){
    int indice = calcularHash(chave); 

    if(info[indice] != null){
        NoMapa<T> no = new NoMapa<>(); 
        no.setChave(chave);
        info[indice].retirar(no);
    }
  }


public boolean containsKey(int chave){
    int indice = calcularHash(chave); 

    if(info[indice] != null){
        NoMapa<T> no = new NoMapa<T>(); 
        no.setChave(chave);

        NoLista<NoMapa<T>> noOther = info[indice].buscar(no);

        if(noOther != null){
            return true;
        }
    }

    return false;

}


public boolean containsValue(T valor){
    for(int i = 0; i < info.length; i++){
     if(info[i] != null){
        NoLista<NoMapa<T>> noAtual = info[i].getPrimeiro(); 
        while (noAtual != null) {
            if(noAtual.getInfo().getInfo().equals(valor)){
                return true;
            }
            noAtual = noAtual.getProximo();            
        }
     }
    }
    return false;
}


public void limparMapa(){
    for(int i = 0; i < info.length;i++){
        info[i] = null;
    }
}

//retorna uma lista ou coleção contendo tosos os pares chave valor
/*public List<ParChaveValor<Integer, T>> entrySet() {
    List<ParChaveValor<Integer, T>> entradas = new ListaEncadeada<ParChaveValor<Integer, T>>(); // Usando sua estrutura ListaEncadeada

    for (int i = 0; i < info.length; i++) {
        if (info[i] != null) {
            NoLista<NoMapa<T>> noAtual = info[i].getPrimeiro();
            while (noAtual != null) {
                ParChaveValor<Integer, T> entry = new ParChaveValor<>(noAtual.getInfo().getChave(), noAtual.getInfo().getInfo());
                entradas.inserir(entry); // Inserir o par chave-valor na lista encadeada
                noAtual = noAtual.getProximo();
            }
        }
    }

    return entradas;
}

necessário cria uma classe: 

public class ParChaveValor<K, V> {
    private K chave;
    private V valor;

    public ParChaveValor(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}

*/


public void redimencionar(int NovoTamanho){
    ListaEncadeada<NoMapa<T>> [] novaInfo = new ListaEncadeada[NovoTamanho]; 
     for(int i = 0; i < info.length; i++){
        if(info[i] != null){
          NoLista<NoMapa<T>> noAtual = info[i].getPrimeiro(); 
          while (noAtual != null) {
            int novoIndice = noAtual.getInfo().getChave() % NovoTamanho;
            if (novaInfo[novoIndice] == null) {
                novaInfo[novoIndice] = new ListaEncadeada<>(); 
            }
            novaInfo[novoIndice].inserir(noAtual.getInfo());
            noAtual = noAtual.getProximo();
          }
        }
     }
     info = novaInfo;
}

// chaves de busca do tipo texto
public int calcularHash(String chave) {
    int hash = 0;
    for (int i = 0; i < chave.length(); i++) {
        hash = (hash * 31 + chave.charAt(i)) % info.length;
    }
    return hash;
}


public int calcularHashAlfabeto(String texto) {
    int n = texto.length() - 1;
    int h = 0;

    for (int c = 0; c <= n; c++) {
        char caracter = texto.charAt(c);  // Pega o caractere no índice c
        int codigo = mapear(caracter);  // Mapeia o caractere para um número de 0 a 25
        h = (h + (codigo * (int) Math.pow(26, c))) % info.length;  // Atualiza o valor de h
    }

    return h;
}


public int calcularHashTexto(String chave) {
    int hash = 0;
    for (int i = 0; i < chave.length(); i++) {
        hash = (hash * 31 + chave.charAt(i)) % info.length;
    }
    return hash;
}


public int mapear(char caracter) {
    return caracter - 'a';  
}

//bubllersort  
public void ordenarBolhaCrescente(T [] info){
    int i,j;
    int n = info.length;
    boolean trocar; 
    int numTrocas = 0; 
    int numComparacoes = 0; 

    for(i = n-1 ;i >= 1; i--){
        trocar = false;
       for(j = 0; j <= i; j++){
          numComparacoes++;
          if(((Comparable<T>)info[j]).compareTo(info[j+1]) > 0){
            trocar(info, j, j+1);
            trocar = true; 
            numTrocas++; 
          }
       }
       if(!trocar) break; 

    }
}

public void ordenarBolhaDecrescente(T [] info) {
    int i, j;
    int n = info.length;
    boolean trocar;
    int numTrocas = 0; 

    for (i = n - 1; i >= 1; i--) { 
        trocar = false;
        for (j = 0; j < i; j++) { 
            if (((Comparable<T>)info[j]).compareTo(info[j + 1]) < 0) { 
                trocar(info, j, j + 1);
                trocar = true;
                numTrocas++;
            }
        }
        if (!trocar) break; 
    }
}

public int comparacoes(T [] info){
   int N = info.length;
   int numComparacoes = (N * (N - 1)) / 2;
   if(numComparacoes > 0){
     return(numComparacoes);
   }
   return 0; 
}

public void ordernaQuickSort(){
    int n = info.length-1;
    quicksort(0,n);
}


public void quicksort(int inicio, int fim){
    if(inicio < fim){
        int idxPivo = particionar(inicio,fim);
        quicksort(inicio, idxPivo-1);
        quicksort(idxPivo+1, fim);
    }
}


public int particionar(int inicio, int fim){
    int a = inicio; 
    int b = fim; 

    T pivo = (T) info[inicio]; 
    
    while(true){
        
    do{
     a = a +1; 
    }while( a <= fim  && ((Comparable<T>)info[a]).compareTo(pivo) < 0);
      
    do{
       b = b -1;         
    } while(b >= inicio && ((Comparable<T>)info[b]).compareTo(pivo) > 0); 
    
    if(a >= b)
      break;
    
    trocar(a, b);
}
    
    trocar(b, inicio);
    return b;
}


public int particionarUltimoPivo(int inicio, int fim){
    int a = inicio;
    int b = fim - 1;  

    T pivo = (T) info[fim]; 
    
    while(true){
        
        do{
            a = a + 1;
        } while(a <= fim - 1 && ((Comparable<T>)info[a]).compareTo(pivo) < 0);

        do{
            b = b - 1;
        } while(b >= inicio && ((Comparable<T>)info[b]).compareTo(pivo) > 0);

        if(a >= b)
            break;

        trocar(a, b);
    }

   
    trocar(a, fim); 

    return a; 
}

public void trocar(int a, int b){
    ListaEncadeada<NoMapa<T>> temp = info[a]; 
    info[a] = info[b];
    info[b] = temp;
 
 }
 

public void trocar(T [] info, int atual, int sucessor){
   T temp =  info[atual]; 
   info[atual] = info[sucessor];
   info[sucessor] = temp;

}



@Override
public String toString() {
   StringBuilder resultado = new StringBuilder(); 

   for(int i = 0; i < info.length; i++){
      resultado.append("indice: ").append(i).append(":");  

      if(info[i] != null){
        NoLista<NoMapa<T>> atual = info[i].getPrimeiro(); 
        while (atual != null) {
            resultado.append("[Chave: ").append(atual.getInfo().getChave())
                     .append(", Valor: ").append(atual.getInfo().getInfo()).append("] ");
            atual = atual.getProximo();
        }
    } else {
        resultado.append("Vazio");
    }
    resultado.append("\n");
   }


    return resultado.toString();
    }


  
}
