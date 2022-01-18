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
 * Clase que implementa un Lado correspondiente a un grafo no dirigido.
 *
 * @param [v] Entero no negativo que representa uno de los vértices de la arista.
 * @param [u] Entero no negativo que representa el otro vértice de la arista.
 * @param [peso](opcional) Real que representa el peso de la arista.
 *
 * @throws [RuntimeException] [v] < 0 o [u] < 0, o [v] == [u].
 */
public class Arista(
     val v: Int,
     val u: Int,
     val peso: Double = 0.0
     ): Comparable<Arista>, Lado(v, u) {

     init {
          if (v < 0 || u < 0) {
               throw RuntimeException("Los vértices deben ser mayores o iguales a 0.")
          }
          
          // No pueden existir bucles en los grafos no dirigidos.
          if (u == v) {
               throw RuntimeException("Los vértices deben ser distintos.")
          }
     }
     
     /**
      * Retorna el peso asociado a la arista.
      *
      * Tiempo de ejecución: O(1).
      * Precondición: true.
      * Postcondición: [peso] es un real con el peso asociado a la arista.
      */
     fun peso(): Double = peso

     /** 
      * Retorna la representación en String de la arista y su peso
      * asociado, como un par (<v, u>, peso).
      *
      * Tiempo de ejecución: O(1).
      * Precondición: true.
      * Postcondición: [toString] es una representación de la arista como una cadena 
      *                de caracteres.
      */
     override fun toString(): String = "(<$v, $u>, $peso)"

     /**
      * Compara la arista con [other] con respecto a su peso.
      * 
      * Tiempo de ejecución: O(1).
      * Precondición: [other] es una Arista.
      * Postcondición: [compareTo] es:  1  si [this.peso()] > [other.obtenerPiso()].
      *                                -1 si [this.peso()] > [other.obtenerPiso()].
      *                                 0 de otra forma. 
      */
     override fun compareTo(other: Arista): Int {
          return if (this.peso() > other.peso()) {
               1 
          } else if (this.peso() < other.peso()) {
               -1
          } else {
               0
          }
     }

     /**
      * Define la igualdad de la Arista con [other], con respecto a sus vértices.
      * 
      * Tiempo de ejecución: O(1).
      * Precondición: true.
      * Postcondición: [equals] es -True si [other] es Arista y tiene los
      *                             mismo vértices.
      *                            -False de otra forma.
      */
     override fun equals(other: Any?): Boolean {
          if (other == null || other !is Arista) return false

          val u1 = this.cualquieraDeLosVertices()
          val u2 = this.elOtroVertice(u1)

          val v1 = other.cualquieraDeLosVertices()
          val v2 = other.elOtroVertice(v1) 
          
          return (
               (u1 == v1 && u2 == v2) ||
               (u1 == v2 && u2 == v1)
          )
     }
}