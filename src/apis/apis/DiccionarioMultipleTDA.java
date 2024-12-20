package apis.apis;

import apis.ConjuntoTDA;

public interface DiccionarioMultipleTDA {
    void inicializarDiccionario();

    void agregar(int var1, int var2);

    void eliminar(int var1);

    void eliminarValor(int var1, int var2);

    apis.ConjuntoTDA recuperar(int var1);

    ConjuntoTDA claves();
}
