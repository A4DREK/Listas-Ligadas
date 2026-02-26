public class ListaDoblementeLigada<T> {
    private Nodo<T> cabeza;
    private int elementos;

    //Cosa a hacer
    public void add(int indice, T elemento) {
        if (indice < 0 || indice > this.elementos) {
            throw new IndexOutOfBoundsException("Índice fuera del rango permitido.");
        }
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if(indice == 0){
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(null);
        }

        for(int i = 0; i < indice - 1; i++){
            cabeza = cabeza.getSiguiente();
        }
        nuevoNodo.setAnterior(cabeza);
        nuevoNodo.setSiguiente(cabeza.getSiguiente());
        this.cabeza.getSiguiente().setAnterior(nuevoNodo);
        this.cabeza.setSiguiente(nuevoNodo);
        
        return;
    }

    //Cosa a hacer
    public boolean add(T elemento) {
        return true;
    }

    public boolean contains(Nodo<T> objeto) {
        if (objeto == null || this.elementos == 0) {
            return false;
        }

        Nodo<T> actual = this.cabeza;

        while (actual != null) {
            if (actual.equals(objeto)) {
                return true;
            } else {
                actual = actual.getSiguiente();
            }
        }
        return false;
    }

    //Cosa a hacer
    public T remove(int indice) {
        if (indice < 0 || indice > this.elementos - 1) {
            throw new IndexOutOfBoundsException("Índice fuera del rango permitido.");
        }
        return null;
    }

    //Cosa a hacer
    public boolean remove(Nodo<T> objeto) {
        if (objeto == null) {
            return false;
        }   

        return true;
    }

    public int size() {
        return elementos;
    }

    @Override
    public String toString() {
        if (this.elementos == 0) {
            return "cabeza -> null";
        }
        String cadena = "cabeza ->";
        Nodo<T> actual = this.cabeza;

        for (int i = 0; i < this.elementos; i++) {
            if (actual.getSiguiente() == null) {
                cadena += actual + " -> ";
                actual = actual.getSiguiente();
            } else {
                cadena += actual + " <-> ";
                actual = actual.getSiguiente();
            }
        }

        return cadena + " null";
    }
}