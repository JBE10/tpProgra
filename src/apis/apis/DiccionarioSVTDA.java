package apis.apis;

import apis.ConjuntoSTDA;
import apis.ConjuntoTDA;

public interface DiccionarioSVTDA {
    void inicializarDiccionario();

    void agregar(int var1, String var2);

    void eliminar(int var1);

    void eliminarValor(int var1, String var2);

    ConjuntoSTDA recuperar(int var1);

    ConjuntoTDA claves();
}
