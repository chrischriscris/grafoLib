/**
 * grafoLib is a simple library about Graphs
 * Copyright (C) 2022  Christopher Gómez
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ve.usb.grafoLib

/**
 * Clase abstracta que representa un lado de la interfaz Grafo.
 */
abstract class Lado(val a: Int, val b: Int) {

    /**
     * Retorna el vertice [a] del lado
     *
     * Tiempo de ejecución: O(1).
     * Precondición: true.
     * Postcondición: [cualquieraDeLosVertices] es un entero con uno de los vértices
     *                de la arista.
     */
    fun cualquieraDeLosVertices(): Int = a

    /**
     * Retorna el vértice de la arista que es distinto a [w].
     *
     * @throws [RuntimeException] [w] no es un vértice del lado.
     *
     * Tiempo de ejecución: O(1).
     * Precondición: [w] es un vértice del lado.
     * Postcondición: [elOtroVertice] != [w] y [elOtroVertice] es un vértice del lado.
     */
    fun elOtroVertice(w: Int): Int {
         return if (w == a) {
              b
         } else if (w == b) {
              a
         } else {
              throw RuntimeException("El vértice $w no se encuentra en el lado.")
         }
    }
}
