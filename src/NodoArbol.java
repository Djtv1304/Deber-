public class NodoArbol {
    public int clave;
    public NodoArbol iz;
    public NodoArbol de;

    public NodoArbol() {
        clave = 0;
        iz = null;
        de = null;
    }

    public NodoArbol (int dato) {
        clave = dato;
        iz = null;
        de = null;
    }

    public NodoArbol (int dato, NodoArbol izq, NodoArbol der) {
        clave = dato;
        iz = izq;
        de = der;
    }
}