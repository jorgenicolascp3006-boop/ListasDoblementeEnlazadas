void main() {
    MiListaDoble miListaDoble = new MiListaDoble();
    System.out.println(miListaDoble.toString());
    System.out.println("¿Está vacía? " + miListaDoble.isEmpty());

    miListaDoble.insertHead(0);
    miListaDoble.insertHead("Juan");
    miListaDoble.insertHead(true);
    miListaDoble.insertTail("Angela");

    System.out.println(miListaDoble.toString());
    System.out.println("Tamaño: " + miListaDoble.getSize());
    System.out.println("Cabeza: " + miListaDoble.getHead());
    System.out.println("Cola: " + miListaDoble.getTail());

    DoubleNode nodoJuan = miListaDoble.search("Juan");
    System.out.println("¿Contiene 'Juan'? " + miListaDoble.contains("Juan"));
    System.out.println("Dato del nodo encontrado: " + miListaDoble.get(nodoJuan));

    miListaDoble.set(nodoJuan, "Juan Carlos");
    System.out.println("Después de set: " + miListaDoble.toString());

    miListaDoble.insert(nodoJuan, "Nuevo después de Juan Carlos");
    System.out.println("Después de insert(node, object): " + miListaDoble.toString());

    miListaDoble.insert("Angela", "Nuevo después de Angela");
    System.out.println("Después de insert(objectRef, object): " + miListaDoble.toString());

    Object[] arreglo = miListaDoble.toArray();
    System.out.print("Arreglo: ");
    for (Object o : arreglo) {
        System.out.print(o + " ");
    }
    System.out.println();

    miListaDoble.remove(nodoJuan);
    System.out.println("Después de remove: " + miListaDoble.toString());

    miListaDoble.add("Elemento agregado con add()");
    System.out.println("Después de add: " + miListaDoble.toString());

    miListaDoble.clear();
    System.out.println("Después de clear: " + miListaDoble.toString());
    System.out.println("¿Está vacía? " + miListaDoble.isEmpty());


    MiListaDoble numeros = new MiListaDoble();
    numeros.insertTail(5);
    numeros.insertTail(1);
    numeros.insertTail(3);
    numeros.insertTail(2);
    numeros.insertTail(4);
    System.out.println("Lista de números: " + numeros.toString());

    MiListaDoble ordenada = numeros.sortList();
    System.out.println("Lista ordenada: " + ordenada.toString());

    DoubleNode inicio = numeros.search(1);
    DoubleNode fin = numeros.search(2);
    MiListaDoble sub = numeros.subList(inicio, fin);
    System.out.println("Sublista de 1 a 2: " + sub.toString());
}