public class Main {

    public static void main(String[] args) {
        Nodo array[] = new Nodo[2000];
        TDA.InsertarAlInicio(10,array);
        TDA.InsertarAlFinal(120,array);
        TDA.mostrar(TDA.InsertarAlInicio(20,array));
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
    public static Nodo[] InsertarAlInicio(int n,Nodo[]array) {
        Nodo nuevo = new Nodo();
        if(estavacia(array)){
            array[0]=nuevo;
            array[0].setDato(n);
            array[0].setSiguiente(null);
            return array;
        }else{
            Nodo array2[] = new Nodo [array.length];
            array2[0]=nuevo;
            array2[0].setDato(n);
            array2[0].setSiguiente(array[0]);
            System.arraycopy(array,0,array2,1,array.length-1);
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
