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
public class Nodo 
{
    private Object objeto;
    private Nodo siguiente;
    private Nodo anterior;
    
    //Constructores
    public Nodo(){
        siguiente = anterior = null;
        objeto = null;
    }
    public Nodo(Object o, Nodo n){
        objeto = o;
        siguiente = n;
    }
    public Nodo(Object o)
    {
        objeto = o;
    }
    //Encapsulados
    public void SetObjecto(Object e){
        objeto = e;
    }
    public Object GetObjecto(){
        return  objeto;
    }
    public void SetSiguiente(Nodo n){
        siguiente = n;
    }
    public Nodo GetSiguiente(){
        return siguiente;
    }
    public void SetAnterior(Nodo n){
        anterior = n;
    }
    public Nodo GetAnterior(){
        return anterior;
    }
            
}
