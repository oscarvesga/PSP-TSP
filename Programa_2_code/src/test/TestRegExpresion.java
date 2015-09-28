/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * Clase para probar las diferentes expresiones regulares
 *
 * @author Oscar Vesga
 * @version 1.0
 * @since 28-08-2015
 */
public class TestRegExpresion
{

    /**
     * Ejemplo de como usar las expresiones regulares
     * @param args
     */
    public static void main(String args[])
    {
        String Str = new String("Welcome to Tutorialspoint.com");

        System.out.print("Return Value :");
        System.out.println(Str.matches("(.*)Tutorials(.*)"));

        System.out.print("Return Value :");
        System.out.println(Str.matches("Tutorials"));

        System.out.print("Return Value :");
        System.out.println(Str.matches("Welcome(.*)"));
    }
}
