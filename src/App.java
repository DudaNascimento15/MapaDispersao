 
public class App {
    public static void main(String[] args) throws Exception {
        MapaDispersao<Integer> mapa = new MapaDispersao<>(10); 

        mapa.inserir(1, 1);
        mapa.inserir(2, 2);
        mapa.inserir(3, 3);
        mapa.inserir(4, 4);
        mapa.inserir(5, 5);
        mapa.inserir(6, 6);
        mapa.inserir(7, 7);
        mapa.inserir(8, 8);
        mapa.inserir(9, 9);
        mapa.inserir(10, 10);
        
        System.out.println(mapa.toString());

        mapa.remover(5);
        System.out.println(mapa.toString());
        mapa.inserir(16, 15);
        System.out.println(mapa.toString());




System.out.println(mapa.containsValue(10)); // true
System.out.println(mapa.containsValue(300)); // false

mapa.limparMapa();

 System.out.println(mapa.toString());

        
    }
}
