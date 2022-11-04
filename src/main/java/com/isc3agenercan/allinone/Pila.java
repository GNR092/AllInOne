/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isc3agenercan.allinone;

/**
 *
 * @author Gener Can
 * @author Mitzy Cante
 */
public class Pila 
{
    private int length;
    private Nodo pila;
    //Nodo raiz;
    
    public Pila(){
        pila = null;
        length = 0;
    }
    
    public boolean EsVacio()
    {
        return  pila == null;
    }
    public Nodo GetNodo()
    {
        return EsVacio() ? null : pila;
    }
    
    public void NewApilar(Object o)
    {
        Nodo nodo = new Nodo(o, null);
        if (length == 0) 
        {
            pila = nodo;
        }
        else
        {
            if(o != null)
            {
                nodo.SetSiguiente(pila);
                pila = nodo;
            }
        }
        length++;
    }
    public void Desapilar()
    {
       
        if(!EsVacio())
        {
            Nodo temp = pila;
            pila = temp.GetSiguiente();
            length--;
        }
    }
}
