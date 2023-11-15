/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.github;

/**
 *
 * @author David
 */

 import java.util.Scanner;

public class Laberinto {

    public static void main(String[] args) {
        char[][] laberinto = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', 'E', '#'}
        };

        int fila = 1; // Posición inicial de fila del objeto
        int columna = 1; // Posición inicial de columna del objeto

        Scanner scanner = new Scanner(System.in);

        // Bucle principal del juego
        while (true) {
            // Imprimir el laberinto
            for (int i = 0; i < laberinto.length; i++) {
                for (int j = 0; j < laberinto[i].length; j++) {
                    System.out.print(laberinto[i][j]);
                }
                System.out.println();
            }

            // Verificar si el objeto llegó a la salida ('E')
            if (fila == laberinto.length - 1 && columna == laberinto[0].length - 2) {
	//¿qué estamos haciendo aquí?¿Qué pasa si cambiamos la E de sitio?¿Hackeamos el laberinto sin salir por E?
                System.out.println("Conseguido");
                break; // Salir del bucle si se ha alcanzado la salida
            }

            // Obtener la entrada del usuario
            System.out.print("Mueve el objeto (W/A/S/D): ");
            char movimiento = scanner.next().charAt(0);

            // Actualizar la posición del objeto
            switch (movimiento) {
                case 'W':
                    if (laberinto[fila - 1][columna] != '#') {
                        laberinto[fila][columna] = ' ';
                        fila--;
                        laberinto[fila][columna] = 'x';
                    }
                    break;
                case 'A':
                    if (laberinto[fila][columna - 1] != '#') {
                        laberinto[fila][columna] = ' ';
                        columna--;
                        laberinto[fila][columna] = 'x';
                    }
                    break;
                case 'S':
                    if (laberinto[fila + 1][columna] != '#') {
                        laberinto[fila][columna] = ' ';
                        fila++;
                        laberinto[fila][columna] = 'x';
                    }
                    break;
                case 'D':
                    if (laberinto[fila][columna + 1] != '#') {
                        laberinto[fila][columna] = ' ';
                        columna++;
                        laberinto[fila][columna] = 'x';
                    }
                    break;
                default:
                    System.out.println("Movimiento no válido.");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}

