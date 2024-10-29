package apis;

public interface DiccionarioSTDA {
    void inicializarDiccionario();

    void agregar(String var1, int var2);

    void eliminar(String var1);

    void eliminarValor(String var1, int var2);

    ConjuntoTDA recuperar(String var1);

    ConjuntoSTDA claves();
}
