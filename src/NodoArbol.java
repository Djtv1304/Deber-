public class NodoArbol {
    public String clave;
    public NodoArbol iz;
    public NodoArbol de;
    public boolean jugando;
    public boolean arbJuntado;
    public NodoArbol() {
        clave = "";
        iz = null;
        de = null;
    }

    public NodoArbol (String dato) {
        clave = dato;
        iz = null;
        de = null;
    }

    public NodoArbol (String dato, NodoArbol izq, NodoArbol der) {
        clave = dato;
        iz = izq;
        de = der;
        jugando = false;
        arbJuntado = false;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    public void setArbJuntado(boolean arbJuntado) {
        this.arbJuntado = arbJuntado;
    }
}