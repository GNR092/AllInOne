/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.isc3agenercan.allinone;

import javax.swing.JOptionPane;

/**
 *
 * @author Gener Can
 * @author Mitzy Cante
 */
public class AllInOne {
    private static final String[] MainMenu  = {"Colas", "Pilas", "Listas","Salir"};
    private static final String[] PilaMenu  = {"Agregar estudiante", "Mostrar contenido", "Desapilar","Salir"};
    private static final String[] ColasMenu = {"Agregar estudiante", "Mostrar contenido", "Desencolar","Salir"};
    private static final String[] ListaMenu = {"Agregar a la lista", "Mostrar contenido", "Eliminar", "Limpiar", "Salir"};
    
    public static void main(String[] args){
        boolean menu = true;
        int select;
        
        while (menu) 
        {
            select = CheckOption(InputMessage("Seleccione una opción.", "¿Qué desea hacer?-Menú", JOptionPane.INFORMATION_MESSAGE, MainMenu, MainMenu[0]));
            switch (select) {
                case 0 -> MenuCola();
                case 1 -> MenuPila();
                case 2 -> MenuLista();
                case 10 -> menu = false;
            }
        }
    }
    
     private static void MenuCola() {
        boolean menu = true;
        int select, code = 1;
        Cola c = new Cola();
        
        while (menu) 
        {
            select = CheckOption(InputMessage("Seleccione una opción.", "¿Qué desea hacer?-Colas", JOptionPane.INFORMATION_MESSAGE, ColasMenu, ColasMenu[0]));
            switch (select) {
                case 0 -> {
                    try {
                        Estudiante Esttemp = new Estudiante();
                        Esttemp.SetCodigo(code);
                        Esttemp.SetNombre(InputMessage("Ingrese el nombre."));
                        Esttemp.SetEdad(Integer.parseInt(InputMessage("Ingrese la edad.")));
                        c.Encolar(Esttemp);
                        code++;
                    } catch (NumberFormatException num) {
                        ShowMessage("Ha ocurrido un error y no se a agregado el estudiante.\nError:\n" + num.getMessage());
                    }
                }
                case 1 -> {
                    String dp = GetDatosCola(c);
                    ShowMessage( "".equals(dp) ? "No hay nada que mostrar" : dp );
                }
                case 2 -> {
                    try
                    {
                        if(!c.esVacio())
                        {
                            ShowMessage("Se desencolo " + ((Estudiante)c.GetCabecera().GetObjecto()).GetNombre());
                            c.DesEncolar();
                        }
                        else
                            ShowMessage("No se puede desencolar.\nCola vacia.");
                    }
                    catch (Exception ex) 
                    {}
                }
                case 10 -> menu = false;
            }
        }
    }
     
    private static void MenuPila(){
        boolean menu = true;
        int select, code = 1;
        Pila p = new Pila();
        
        while (menu) 
        {
            select = CheckOption(InputMessage("Seleccione una opción.", "¿Qué desea hacer?-Pilas", JOptionPane.INFORMATION_MESSAGE, PilaMenu, PilaMenu[0]));
            switch (select) {
                case 0 -> {
                    try {
                        Estudiante Esttemp = new Estudiante();
                        Esttemp.SetCodigo(code);
                        Esttemp.SetNombre(InputMessage("Ingrese el nombre."));
                        Esttemp.SetEdad(Integer.parseInt(InputMessage("Ingrese la edad.")));
                        p.NewApilar(Esttemp);
                        code++;
                    } catch (NumberFormatException num) {
                        ShowMessage("Ha ocurrido un error y no se a agregado el estudiante.\nError:\n" + num.getMessage());
                    }
                }
                case 1 -> {
                    String dp = GetDatosPila(p); 
                    ShowMessage( "".equals(dp) ? "No hay nada que mostrar" : dp );
                }
                case 2 -> {
                    try
                    {
                        if(!p.EsVacio())
                        {
                            ShowMessage("Se desapilo " + ((Estudiante)p.GetNodo().GetObjecto()).GetNombre());
                            p.Desapilar();
                        }
                        else
                            ShowMessage("No se puede desenpilar.\nPila vacia.");
                    }
                    catch (Exception ex) 
                    {}
                }
                case 10 -> menu = false;
            }
        }
    }
    
    private static void MenuLista() {
         boolean menu = true;
        int select;
        ListaDoble l = new ListaDoble();
        
        while (menu) 
        {            
            select = CheckOption(InputMessage("Seleccione una opción.", "¿Qué desea hacer?-Listas", JOptionPane.INFORMATION_MESSAGE, ListaMenu, ListaMenu[0]));
            switch (select) 
            {
                case 0 -> l.Agregar(InputMessage("Ingrese un dato"));
                case 1 -> {
                    StringBuilder str = new StringBuilder();
                    if(l.GetLongitud() > 0)
                    {
                        for(int i = 0; i <= l.GetLongitud()-1; i++)
                        {
                            str.append("Elemento ").append(i + 1).append(" : ").append(l.Get(i)).append("\n");
                        }
                        ShowMessage(str.toString());
                    }
                    else
                        ShowMessage("Lista vacia.");
                 }
                case 2 -> {
                    if(l.GetLongitud() > 0)
                    {
                        String[] elements = new String[l.GetLongitud()];
                        Object option;
                        for(int i = 0; i <= l.GetLongitud()-1; i++)
                        {
                            elements[i] = l.Get(i).toString();
                        }
                        option = (Object)InputMessage("Seleccione una opción.", "¿Qué elemento desea eliminar?-Listas", JOptionPane.INFORMATION_MESSAGE, elements, elements[0]);
                        if (l.Contiene(option)) 
                        {
                            l.Eliminar(option);
                            ShowMessage("Se eliminó " + option);
                        }
                        else
                            ShowMessage("No se eliminó.");
                    }
                    else
                        ShowMessage("No hay nada que eliminar.");
                 }

                case 3 -> {
                    l.limpiar();
                    ShowMessage("Se limpio la lista");
                 }
                case 10 -> menu = !menu;
            }
        }
    }
    
    
    private static int CheckOption(Object msg){
        try
        {
            String opt = (String)msg;
            return switch (opt) {
                case "Colas", "Agregar estudiante", "Agregar a la lista" -> 0;
                case "Pilas", "Mostrar contenido" -> 1;
                case "Listas", "Desapilar", "Desencolar", "Eliminar" -> 2;
                case "Limpiar" -> 3;
                case "Salir" -> 10;
                default -> -1;
            };
        }
        catch(Exception e)
        {
            return  10;
        }
    }
    private static String GetDatosCola(Cola n){
        StringBuilder str = new StringBuilder();
        Nodo temp = n.GetCabecera();
        
        while (temp != null) {            
            str.append("Código: ").append(((Estudiante)temp.GetObjecto()).GetCodigo()).append(", Nombre: ").append(((Estudiante)temp.GetObjecto()).GetNombre()).append(", Edad: ").append(((Estudiante)temp.GetObjecto()).GetEdad()).append("\n");
            temp = temp.GetSiguiente();
        }
        return str.toString();
    }
    private static String GetDatosPila(Pila p){
        Nodo temp = p.GetNodo();
        StringBuilder str = new StringBuilder();
        
        while (temp != null) {  
            str.append("Código: ").append(((Estudiante)temp.GetObjecto()).GetCodigo()).append(", Nombre: ").append(((Estudiante)temp.GetObjecto()).GetNombre()).append(", Edad: ").append(((Estudiante)temp.GetObjecto()).GetEdad()).append("\n");
            temp = temp.GetSiguiente();
        }
        return str.toString();
    }
    public static String InputMessage(String m){
        return JOptionPane.showInputDialog(m);
    }
    public static Object InputMessage(String titulo,String msg,int option,String[] array,String defaularrayoption){
        return JOptionPane.showInputDialog(null, titulo, msg, option, null, array, defaularrayoption);
    }
    public static void ShowMessage(String m){
        JOptionPane.showMessageDialog(null, m);
    }
}
