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
public class Estudiante 
{
    private int Code;
    private String Name;
    private int Age;
    
    //Constructores
    public Estudiante()
    {
        
    }
    public Estudiante(int codigo,String nombre,int edad)
    {
        Code = codigo;
        Name = nombre;
        Age = edad;
    }
    //Propiedades encapsulados
    public void SetCodigo(int codigo)
    {
        Code = codigo;
    }
    public int GetCodigo()
    {
        return Code;
    }
    public void SetNombre(String nombre)
    {
        Name = nombre;
    }
    public String GetNombre()
    {
        return Name;
    }
    public void SetEdad(int edad)
    {
        Age = edad;
    }
    public int GetEdad()
    {
        return Age;
    }
    
}
