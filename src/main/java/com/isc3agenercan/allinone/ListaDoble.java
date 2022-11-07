/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isc3agenercan.allinone;

import java.util.Vector;

/**
 *
 * @author Gener Can
 * @author Mitzy Cante
 */
public class ListaDoble{
    private Nodo primero;
    private Nodo ultimo;
    private int length;
    
    public int GetLongitud(){
        return length;
    }
    public boolean esVacia(){
        return primero == null;
    }
    
    //Metodos
    public void InsertarEn(int i, Object elemento) {
        
        Nodo n = new Nodo(elemento);
        if (i <= 0)
        {
            AgregaInicio(elemento);
        }
        else if (i >= GetLongitud())
        {
            AgregaFinal(elemento);
        }
        else if(GetLongitud() == 0)
        {
            primero = n;
            ultimo = n;
            length++;
        }
        else
        {
          int count = 0;
          Nodo temp = primero;
          while(count < i)
          {
            temp = temp.GetSiguiente();
            count++;
          }
          temp.GetAnterior().SetSiguiente(n);
          temp.SetAnterior(n);
          n.SetSiguiente(temp);
          n.SetAnterior(temp.GetAnterior().GetAnterior());
          length++;
        }

    }
    public void Agregar(Object elemento){
        
        if (GetLongitud() <= 0)
        {
            AgregaInicio(elemento);
        }
        else if (GetLongitud() >= GetLongitud())
        {
            AgregaFinal(elemento);
        }
    }
    
    public void Eliminar(Object elemento) {
        
        if(!esVacia() && Contiene(elemento))
        {
          if(primero.GetSiguiente() == null)
          {
            primero = null;
            ultimo = null;
            length--;
          }
          else
          {
            Nodo n = primero;
            while(n.GetSiguiente() !=null && !n.GetObjecto().equals(elemento))
            {
              n = n.GetSiguiente();
            }
            if(n.GetAnterior() == null)
            {
              EliminaPrimero();
            }
            else if (n.GetSiguiente() == null)
            {
              EliminaUltimo();
            }
            else
            {
              n.GetSiguiente().SetAnterior(n.GetAnterior());
              n.GetAnterior().SetSiguiente(n.GetSiguiente());
              n.SetSiguiente(null);
              n.SetAnterior(null);
              length--;
            }
          }
        }
    }
    private Object EliminaPrimero() {
        
        if(!esVacia())
        {
          Nodo n = primero;
          if(primero.GetSiguiente() == null)
          {
            primero = null;
            ultimo = null;
          }
          else
          {
            primero = primero.GetSiguiente();
            primero.GetAnterior().SetSiguiente(null);
            primero.SetAnterior(null);
          }
          length--;
          return n.GetObjecto();
        }
        return null;
    }
    private Object EliminaUltimo() {
        
        if(!esVacia())
        {
          Nodo n = ultimo;
          if(ultimo.GetAnterior() == null)
          {
            primero = null;
            ultimo = null;
          }
          else
          {
            ultimo = ultimo.GetAnterior();
            ultimo.GetSiguiente().SetAnterior(null);
            ultimo.SetSiguiente(null);
          }
          length--;
          return n.GetObjecto();
        }
        return null;
    }
    public void limpiar() {
                
        while(GetLongitud() != 0 )
        {
          EliminaPrimero();
        }
    }
    
    private void AgregaInicio(Object elemento) {
        Nodo n = new Nodo(elemento);
        if (!esVacia())
        {
          primero.SetAnterior(n);
          primero.GetAnterior().SetSiguiente(primero);
          primero = n;
          length++;
        }
        else
        {
          primero = n;
          ultimo = n;
          length++;
        }
    }
    
    private void AgregaFinal(Object elemento) {
        Nodo n = new Nodo(elemento);
        
        if (!esVacia())
        {
          ultimo.SetSiguiente(n);
          ultimo.GetSiguiente().SetAnterior(ultimo);
          ultimo = n;
          length++;
        }
        else
        {
          primero = n;
          ultimo = n;
          length++;
        }
    }
    
    public boolean Contiene(Object elemento) {
        
        Nodo temp = primero;
        
        for (int i = 1; i <= GetLongitud(); i++)
        {
          if(temp.GetObjecto().equals(elemento)){
            return true;
          }
          temp = temp.GetSiguiente();
        }
        return false;
    }
    
    public int IndexOf(Object elemento) {
        
        if(Contiene(elemento))
        {
          int count = 0;
          Nodo temp = primero;
          while(!temp.GetObjecto().equals(elemento)){
            temp = temp.GetSiguiente();
            count++;
          }
          return count;
        }
        return -1;
    }
    
    public Object Get(int index){
        if (0 <= index && index < GetLongitud())
        {
            Nodo n = primero;
            int count = 0;
            while(n.GetObjecto() != null && count < index)
            {
                n = n.GetSiguiente();
                count++;
            }
            return n.GetObjecto();
        }
        return null;
    }
}
