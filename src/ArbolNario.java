public class ArbolNario {

    private NodoArbolNario raiz;

    public ArbolNario(int dato) {
        raiz = new NodoArbolNario(dato);
    }

    public void insertar(ArbolNario arbol) {
        raiz.getHijos().insertar(arbol.raiz);
    }

    // ------------------------------------------------------------------------
    // TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
    public void mostrarProfundidadRecursivo() {
        System.out.print("Profundidad Recursivo: ");
        mostrarProfundidadRecursivoPrivado(raiz);
        System.out.println();
    }

    private void mostrarProfundidadRecursivoPrivado(NodoArbolNario nodo) {
        System.out.print(nodo.getDato() + " ");
        if (!nodo.getHijos().vacia()) {
            IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
            while (it.hasNext())
                mostrarProfundidadRecursivoPrivado(it.next());
        }
    }

    // ------------------------------------------------------------------------
    // TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
    public void mostrarProfundidadIterativo() {
        System.out.print("Profundidad Iterativo: ");
        if (raiz != null) {
            PilaNodosArbolNario pila = new PilaNodosArbolNario();
            NodoArbolNario act;
            pila.apilar(raiz);
            while (!pila.vacia()) {
                act = pila.desapilar();
                System.out.print(act.getDato() + " ");
                if (!act.getHijos().vacia()) {
                    IteradorAtrasListaNodosArbolNario it = act.getHijos().getIteradorAtras();
                    while (it.hasPrevious())
                        pila.apilar(it.previous());
                }
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------
    // TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
    public void mostrarAmplitud() {
        System.out.print("Amplitud: ");
        if(raiz != null)
        {
            ColaNodosArbolNario cola = new ColaNodosArbolNario();
            cola.encolar(raiz);
            while(!cola.vacia())
            {
                NodoArbolNario act;
                act = cola.desencolar();
                System.out.print(act.getDato() + " ");
                if(!act.getHijos().vacia())
                {
                    IteradorAdelanteListaNodosArbolNario it = act.getHijos().getIteradorAdelante();
                    while(it.hasNext())
                        cola.encolar(it.next());
                }
            }
        }
        System.out.println();
    }
}