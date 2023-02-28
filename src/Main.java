public class Main {

    public static void main(String[] args) {
        Nodo cabecera = new Nodo();
        Nodo recorrer = new Nodo();
        Lista.InsertarAlFinal(30,cabecera);
        Lista.InsertarAlInicio(15,cabecera);
        Lista.InsertarAlFinal(20,cabecera);
        Lista.InsertarAlFinal(10,cabecera);
        Lista.get(cabecera,2);
        Lista.InsertarEnPosicion(cabecera,2,70);
        System.out.println(Lista.get(cabecera,2).getDato());
        Lista.BorrarEnPosicion(cabecera,2);
        System.out.println(Lista.get(cabecera,2).getDato());
    }
}

class TDA {
    public static boolean estavacia(Nodo[]array){
        if(array[0]==null){
            return true;
        }else{
            return false;
        }
    }
    public static <T> Nodo[] InsertarAlInicio(int n,Nodo[]array) {
        Nodo nuevo = new Nodo();
        if(estavacia(array)){
            array[0]=nuevo;
            array[0].setDato(n);
            array[0].setSiguiente(null);
            return array;
        }else{
            Nodo array2[] = new Nodo [array.length+1];
            array2[0]=nuevo;
            array2[0].setDato(n);
            array2[0].setSiguiente(array[0]);
            System.arraycopy(array,0,array2,1,array.length);
            return array2;
        }

    }
    public static Nodo[]  BorrarAlInicio(Nodo[] array){
        if(estavacia(array)){
            return array;
        }else{
            Nodo array2[]= new Nodo[array.length];
            System.arraycopy(array,1,array2,0,array.length-1);
            return array2;
        }
    }
    public static Nodo[] InsertarAlFinal(int n,Nodo[]array){
        Nodo nuevo = new Nodo();
        if(estavacia(array)){
            array[0]=nuevo;
            array[0].setDato(n);
            array[0].setSiguiente(null);
            return array;
        }else{
            int i=0;
            while (array[i].getSiguiente()!=null){
                i=i+1;
            }
            array[i].setSiguiente(nuevo);
            array[i+1]=nuevo;
            array[i+1].setDato(n);
            array[i+1].setSiguiente(null);
            return array;
        }

    }
    public static Nodo[] BorrarAlFinal(Nodo[]array){
        if(estavacia(array)){
            return array;
        }else{
            int i=0;
            while (array[i].getSiguiente()!=null){
                i=i+1;
            }
            array[i-1].setSiguiente(null);
            array[i].setDato(null);
            return array;
        }
    }
    public static Nodo[] InsertarEnPosicion(Nodo[] array, int posicion, int n){
        Nodo nuevo = new Nodo();
        if(estavacia(array)){
            if(posicion==0){
                array[0]=nuevo;
                array[0].setDato(n);
                array[0].setSiguiente(null);
                return array;
            }
            else{
                System.out.println("Error, no se puede insertar en "+posicion+" porque el arreglo está vacío");
                return array;
            }
        }else{
            if(array[posicion-1]!=null){
                Nodo array2[]= new Nodo[array.length];
                System.arraycopy(array,0,array2,0,posicion);
                array2[posicion]=nuevo;
                array2[posicion].setDato(n);
                array2[posicion].setSiguiente(array[posicion]);
                array2[posicion-1].setSiguiente(array2[posicion]);
                System.arraycopy(array,posicion,array2,posicion+1,array.length-(posicion+1));
                return array2;
            }
            else{
                System.out.println("Error, indice fuera de la longitud del arreglo");
                return array;
            }
        }
    }
    public static Nodo[] BorrarEnPosicion(Nodo[]array,int posicion){
        if(estavacia(array)) {
            System.out.println("Error, no se puede borrar en " + posicion + " porque el arreglo está vacío");
            return array;
        }else{
            if(array[posicion]!=null){
                Nodo[] array2= new Nodo[array.length];
                System.arraycopy(array,0,array2,0,posicion);
                if(array[posicion].getSiguiente()!=null){
                    array2[posicion-1].setSiguiente(array[posicion].getSiguiente());
                    Nodo nuevo= new Nodo();
                    array2[posicion]=nuevo;
                    array2[posicion].setDato(array[posicion+1].getDato());
                    array2[posicion].setSiguiente(array[posicion+1].getSiguiente());
                    System.arraycopy(array,posicion+2,array2,posicion+1,array.length-(posicion)-2);
                    return array2;
                }
                else{
                    array2[posicion-1].setSiguiente(null);
                    return array2;
                }
            }
            else{
                System.out.println("Esta posicion está vacía");
                return array;
            }
        }
    }

    public static void mostrar(Nodo[]array){
        int i=0;
        while(array[i].getDato()!=null){
            System.out.println(array[i].getDato());
            System.out.println(array[i].getSiguiente());
            i=i+1;
            if(array[i]==null){
                break;
            }
        }
    }
}
class Lista <T>{
    Nodo cabecera= new Nodo();
    public static boolean estavacia(Nodo cabecera){
        if(cabecera.getSiguiente()==null){
            return true;
        }
        else{
            return false;
        }
    }
    public static Nodo InsertarAlInicio(int dato,Nodo cabecera){
        Nodo nuevo = new Nodo();
        if(estavacia(cabecera)){
            cabecera.setDato(dato);
            cabecera.setSiguiente(null);
            nuevo.setDato(null);
            nuevo.setSiguiente(cabecera);
            return nuevo;
        }else{
            nuevo.setDato(dato);
            nuevo.setSiguiente(cabecera.getSiguiente());
            cabecera.setSiguiente(nuevo);
            return cabecera;
        }
    }
    public static Nodo InsertarAlFinal(int dato,Nodo cabecera){
        Nodo nuevo = new Nodo();
        if(estavacia(cabecera)){
            cabecera.setSiguiente(nuevo);
            nuevo.setDato(dato);
            nuevo.setSiguiente(null);
            return cabecera;
        }else{
            Nodo recorrer = new Nodo();
            recorrer.setSiguiente(cabecera.getSiguiente());
            while (recorrer.getSiguiente()!=null){
                recorrer=recorrer.getSiguiente();
            }
            nuevo.setDato(dato);
            nuevo.setSiguiente(null);
            recorrer.setSiguiente(nuevo);
            return recorrer;
        }
    }
    public static Nodo BorrarAlInicio(Nodo cabecera){
        if(estavacia(cabecera)){
            System.out.println("Error, lista vacia");
            return cabecera;
        }
        else{
            cabecera.setSiguiente(cabecera.getSiguiente().getSiguiente());
            return cabecera;
        }
    }
    public static Nodo BorrarAlFinal(Nodo cabecera){
        if(estavacia(cabecera)){
            System.out.println("Error, lista vacia");
            return cabecera;
        }else{
            Nodo recorrer = new Nodo();
            Nodo penultimo = new Nodo();
            recorrer.setSiguiente(cabecera.getSiguiente());
            while (recorrer.getSiguiente()!=null){
                penultimo=recorrer;
                recorrer=(recorrer.getSiguiente());
            }
            penultimo.setSiguiente(null);
            return cabecera;
        }
    }
    public static Nodo get(Nodo cabecera, int posicion) {
        Nodo recorrer = new Nodo();
        recorrer.setSiguiente(cabecera.getSiguiente());
        int i=0;
        while(i<=posicion) {
            recorrer = recorrer.getSiguiente();
            i += 1;
        }
        return recorrer;
    }
    public static Nodo InsertarEnPosicion(Nodo cabecera,int posicion,int dato){
        Nodo nuevo = new Nodo();
        if(estavacia(cabecera)){
            if(posicion==0){
                cabecera.setDato(dato);
                cabecera.setSiguiente(null);
                nuevo.setDato(null);
                nuevo.setSiguiente(cabecera);
                return cabecera;
            }
            else {
                System.out.println("Error, lista vacía");
                return cabecera;
            }
        }
        else{
            if(get(cabecera,posicion-1)!=null){
                nuevo.setDato(dato);
                Nodo anterior= get(cabecera,posicion-1);
                anterior.setSiguiente(nuevo);
                nuevo.setSiguiente(get(cabecera,posicion));
                return cabecera;
            }
            else{
                System.out.println("Error, indice fuera de la longitud de la lista");
                return cabecera;
            }
        }
    }
    public static Nodo BorrarEnPosicion(Nodo cabecera,int posicion){
        if(estavacia(cabecera)){
            System.out.println("Error, lista vacía");
            return cabecera;
        }else {
            if(get(cabecera,posicion)!=null){
                Nodo anterior = new Nodo();
                anterior = get(cabecera,(posicion-1));
                anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
                return cabecera;
            }
            else{
                System.out.println("Error, esta posicion esta vacia");
                return cabecera;
            }
        }
    }
}
