package Question_1;


import java.util.LinkedList;

/**
 *
 * @author Semih KARACAOĞLU
 */

public class MyDeque<AnyType> {
    
    MyDeque()
    {L = new LinkedList<AnyType>();}
    
    void push(AnyType x){
        L.addFirst(x);
    }
    
    AnyType pop(){
        return L.removeFirst();
    }
    void inject(AnyType x){
        L.addLast(x);
    }
    
    AnyType eject(){
        return L.removeLast();
    }
    LinkedList<AnyType> L;
}
