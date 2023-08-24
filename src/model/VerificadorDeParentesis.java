package model;

import java.util.Stack;

public class VerificadorDeParentesis {
    public static boolean verificaBalance(String cadena) {

        Stack<Character> pila = new Stack<>();

        // Iteramos a través de cada carácter en la cadena
        for (char caracter : cadena.toCharArray()) {
            // Si encontramos un paréntesis de apertura, lo empujamos a la pila
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            }
            // Si encontramos un paréntesis de cierre
            else if (caracter == ')' || caracter == ']' || caracter == '}') {
                // Verificamos si la pila está vacía (no hay un paréntesis de apertura correspondiente)
                if (pila.isEmpty()) {
                    return false;
                }

                // Comparamos el paréntesis de cierre con el que está en la cima de la pila
                char tope = pila.pop();
                if ((caracter == ')' && tope != '(') ||
                        (caracter == ']' && tope != '[') ||
                        (caracter == '}' && tope != '{')) {
                    return false; // No coinciden, la cadena no está balanceada
                }
            }
        }

        // Al final, si la pila está vacía, la cadena está balanceada
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String cadena1 = "{[()]}";
        String cadena2 = "{[(])}";

        if (verificaBalance(cadena1)) {
            System.out.println("La cadena 1 está balanceada.");
        } else {
            System.out.println("La cadena 1 no está balanceada.");
        }

        if (verificaBalance(cadena2)) {
            System.out.println("La cadena 2 está balanceada.");
        } else {
            System.out.println("La cadena 2 no está balanceada.");
        }
    }

    private void verificaAnyBalance(String cadena) {
        if (verificaBalance(cadena)) {
            System.out.println("La cadena está balanceada.");
        } else {
            System.out.println("La cadena no está balanceada.");
        }
    }
}
