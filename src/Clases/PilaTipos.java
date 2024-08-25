package Clases;

import java.util.Stack;

public class PilaTipos {

    private Stack<Object> pilaTipos;

    public PilaTipos() {
        this.pilaTipos=new Stack<>();
    }

    public void pushPila(Object o) throws Exception{
        if(pilaTipos.isEmpty() || pilaTipos.peek().getClass().equals(o.getClass())){
            pilaTipos.push(o);
        }
        else{
            throw new Exception("El tipo del objeto no coincide con el tipo del objeto en la cima de la pila.");
        }
    }

    public Object pop() throws Exception{
        if(!pilaTipos.isEmpty()){
            return pilaTipos.pop();
        }else {
            throw new Exception("La pila está vacía.");
        }
    }


    public Object peek() throws Exception{
        if(!pilaTipos.isEmpty()){
            return pilaTipos.peek();
        }else {
            throw new Exception("La pila está vacía.");
        }
    }

    public boolean isEmpty(){
        return pilaTipos.isEmpty();
    }
}

