package model;

import java.util.Stack;

public class ValidadorExpresionMatematica {

    public static boolean validaExpresion(String expresion) {
        Stack<Character> pila = new Stack<>();

        // Iteramos a través de cada carácter en la expresión
        for (char caracter : expresion.toCharArray()) {
            // Si encontramos un paréntesis de apertura, lo empujamos a la pila
            if (caracter == '(') {
                pila.push(caracter);
            }
            // Si encontramos un paréntesis de cierre
            else if (caracter == ')') {
                // Verificamos si la pila está vacía (no hay un paréntesis de apertura correspondiente)
                if (pila.isEmpty()) {
                    return false;
                }
                // Si la pila no está vacía, sacamos un paréntesis de apertura de la pila
                pila.pop();
            }
        }

        // Al final, si la pila está vacía, la expresión está balanceada
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String expresion1 = "((2 + 3) * 5)";
        String expresion2 = "((2 + 3) * 5))";

        if (validaExpresion(expresion1)) {
            System.out.println("La expresión 1 es válida.");
        } else {
            System.out.println("La expresión 1 no es válida.");
        }

        if (validaExpresion(expresion2)) {
            System.out.println("La expresión 2 es válida.");
        } else {
            System.out.println("La expresión 2 no es válida.");
        }
    }
}
