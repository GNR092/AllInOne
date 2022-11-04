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
    private int e1;
    private int e2;
    
    //Constructores
    public Nodo(Object o, Nodo n){
        objeto = o;
        siguiente = n;
    }
    public Nodo(int a, int b, Nodo s, Nodo an){
        e1 = a;
        e2 = b;
        siguiente = s;
        anterior = an;
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
    public void SetElemento1(int a1 ){
        e1 = a1;
    }
    public int GetElemento1(){
        return e1;
    }
    public void SetElemento2(int a2){
        e2 = a2;
    }
    public int GetElemento2(){
        return e2;
    }
            
}
