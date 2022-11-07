/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isc3agenercan.allinone;

import java.util.Vector;

/**
 *
 * @author Admin
 * @param <E>
 */
public class Lista<E> extends Vector<E>
{
    public Lista()
    {
        
    }
    public E Add(E item)
    {
        addElement(item);
        return  item;
    }
    public E Remove(E item)
    {
        removeElement(item);
        return  item;
    }
    public boolean EsVacio() {
        return isEmpty();
    }
    public int buscar(Object o)
    {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
