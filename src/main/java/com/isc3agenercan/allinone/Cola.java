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
public class Cola
{
    private int length;
    private Nodo cabecera;
    private Nodo cola;
    
    public Cola(){
        cabecera = cola = null;
        length = 0;
    }
    //propiedades
    public int longitud(){
        return  length;
    }
    public boolean esVacio(){
        return cabecera == null;
    }
    public Object GetCabeceraObject(){
        if (esVacio()) 
        {
            return null;
        }
        else
        {
            return cabecera.GetObjecto();
        }
    }
    public Nodo GetCabecera(){
        return esVacio() ? null : cabecera;
    }
    //Metodos
    public void Encolar(Object o){
        Nodo nodo = new Nodo(o,null);
        if(length == 0)
        {
            cabecera = nodo;
        }
        else
        {
            cola.SetSiguiente(nodo);
        }
        cola = nodo;
        length++;
    }
    public Object DesEncolar(){
        Object temp;
        if (esVacio()) 
        {
            return null;
        }
        temp = cabecera.GetObjecto();
        cabecera = cabecera.GetSiguiente();
        length--;
        return  temp;
    }
}
