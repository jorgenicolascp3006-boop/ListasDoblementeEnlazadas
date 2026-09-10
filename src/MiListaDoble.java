public class MiListaDoble implements ListInterface {
    DoubleNode cabeza = null;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        if (this.cabeza == null) {
            return 0;
        }
        DoubleNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador++;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        DoubleNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato == null ? object == null : iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        try {
            if (node == null) {
                return insertHead(object);
            }
            DoubleNode nuevo = new DoubleNode(object);
            nuevo.siguiente = node.siguiente;
            nuevo.anterior = node;
            if (node.siguiente != null) {
                node.siguiente.anterior = nuevo;
            }
            node.siguiente = nuevo;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        try {
            DoubleNode nodoReferencia = search(objectRef);
            if (nodoReferencia == null) {
                return false;
            }
            return insert(nodoReferencia, object);
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            DoubleNode nuevaCabeza = new DoubleNode(object);
            nuevaCabeza.siguiente = this.cabeza;
            nuevaCabeza.anterior = null;
            if (this.cabeza != null) {
                this.cabeza.anterior = nuevaCabeza;
            }
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        try {
            if (this.cabeza == null) {
                this.cabeza = new DoubleNode(object);
                return true;
            }
            DoubleNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;
            }
            DoubleNode nuevaCola = new DoubleNode(object);
            nuevaCola.anterior = iterador;
            iterador.siguiente = nuevaCola;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        if (node.anterior != null) {
            node.anterior.siguiente = node.siguiente;
        } else {
            this.cabeza = node.siguiente;
        }
        if (node.siguiente != null) {
            node.siguiente.anterior = node.anterior;
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        if (this.cabeza == null) {
            return new Object[0];
        }
        Object[] arreglo = new Object[getSize()];
        DoubleNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int tam = getSize();
        Object[] arreglo = (object.length >= tam) ? object : new Object[tam];
        DoubleNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        if (arreglo.length > tam) {
            arreglo[tam] = null;
        }
        return arreglo;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        if (from == null || to == null) {
            return null;
        }
        MiListaDoble nueva = new MiListaDoble();
        DoubleNode iterador = from;
        boolean encontroFin = false;
        while (iterador != null) {
            nueva.insertTail(iterador.dato);
            if (iterador == to) {
                encontroFin = true;
                break;
            }
            iterador = iterador.siguiente;
        }
        if (!encontroFin) {
            return null;
        }
        return nueva;
    }

    @Override
    public MiListaDoble sortList() {
        Object[] arreglo = toArray();
        for (int i = 1; i < arreglo.length; i++) {
            Object actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable) arreglo[j]).compareTo(actual) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
        MiListaDoble ordenada = new MiListaDoble();
        for (Object o : arreglo) {
            ordenada.insertTail(o);
        }
        return ordenada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MiListaDoble{");
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            sb.append(iterador.dato);
            if (iterador.siguiente != null) {
                sb.append(", ");
            }
            iterador = iterador.siguiente;
        }
        sb.append("}");
        return sb.toString();
    }
}