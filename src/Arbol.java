public class Arbol {
    public NodoArbol raiz;
    public String nombre;
    public Arbol() {
        raiz = null;
        nombre = null;
    }

    public Arbol(int dato) {
        raiz = new NodoArbol(dato, null, null);
    }

    public Arbol(int dato, String nombreArbol) {
        raiz = new NodoArbol(dato, null, null);
        nombre = nombreArbol;
    }

    static String preOrden(NodoArbol arbol) {
        String impresion = "Nodo Vacio";
        if (arbol != null) {
            impresion = (arbol.clave + " ");
            preOrden(arbol.iz);
            preOrden(arbol.de);
            return impresion;
        }
        return impresion;
    }

    public void preOrden() {
        preOrden(raiz);
    }

    static String postOrden(NodoArbol arbol) {
        String impresion = "Nodo Vacio";
        if (arbol != null) {
            postOrden(arbol.iz);
            postOrden(arbol.de);
            impresion = (arbol.clave + " ");
            return impresion;
        }
        return impresion;
    }

    public void postOrden() {
        postOrden(raiz);
    }

    public static String ordenarCentral(NodoArbol arbol) {
        String impresion = "Nodo Vacio";
        if (arbol != null) {
            ordenarCentral(arbol.iz);
            impresion = (arbol.clave + " ");
            ordenarCentral(arbol.de);
            return impresion;
        }
        return impresion;
    }

    public void ordenarCentral() {
        ordenarCentral(raiz);
    }

    public String juntarArboles(int dato, Arbol a1, Arbol a2) {
        String mensaje;
        if (a1.raiz == a2.raiz && a1.raiz != null) {
            mensaje = "No se pueden mezclar los arboles ya que las raíces son similares";
            return mensaje;
        }

        raiz = new NodoArbol(dato, a1.raiz, a2.raiz);

        if (this != a1){
            a1.raiz = null;
        }
        if (this != a2){
            a2.raiz = null;
        }

        return mensaje = "Los árboles han sido juntados exitosamente";
    }

}