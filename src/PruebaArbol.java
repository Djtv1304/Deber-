public class PruebaArbol {

    static String sumaClaves (NodoArbol arbol) {
        String resul;
        if (arbol != null) {
            resul = arbol.clave + sumaClaves(arbol.iz) + sumaClaves(arbol.de);
        } else {
            resul = null;
        }
        return resul;
    }


    static String sumaClaves (Arbol a){
        return sumaClaves(a.raiz);
    }

    static int cuentaHojas (NodoArbol arbol){
        int resul=0;
        if (arbol != null){
            if((arbol.iz == null)&& (arbol.de==null)){
                resul = 1;
            }
            else{
                resul = cuentaHojas(arbol.iz)+cuentaHojas(arbol.de);
            }

        }
        return resul;
    }

    static int cuentaHojas(Arbol a){
        return cuentaHojas (a.raiz);
    }

    static String clavesNiveles(NodoArbol arbol, int n){
        String impresion = "Nodo vacío";
        if(arbol != null){
            impresion = "Clave: "+arbol.clave+" en el nivel: "+n;
            clavesNiveles(arbol.iz,n+1);
            clavesNiveles(arbol.de, n+1);
            return impresion;
        }
        return impresion;
    }
}