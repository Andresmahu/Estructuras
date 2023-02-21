public class Nodo<T> {
    private T dato;
    private Nodo siguiente;

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

}
