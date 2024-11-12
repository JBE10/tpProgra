package apis;

public interface DiccionarioSimpleTDA {
    void inicializarDiccionario();

    void agregar(int var1, int var2);

    void eliminar(int var1);

    int recuperar(int var1);

    ConjuntoTDA claves();
}
