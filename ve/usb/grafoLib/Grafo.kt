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
 * Interfaz para la implementación de la estructura de datos
 * Grafo.
 *
 * Se refiere a V y E como el conjunto de vértices y lados del
 * grafo, respectivamente.
 */ 
interface Grafo {
    /**
     * Retorna el número de lados en el grafo.
     *
     * Precondición: true.
     * Postcondición: [obtenerNumeroDeLados] = |E|
     */
    fun obtenerNumeroDeLados(): Int

    /**
     * Retorna el número de vértices del grafo.
     *
     * Precondición: true.
     * Postcondición: [obtenerNumeroDeVertices] = |V|
     */
    fun obtenerNumeroDeVertices(): Int

    /**                 
     * Retorna los lados adyacentes al vértice [v].
     *
     * @throws [RuntimeException] El vértice está fuera del intervalo [0..|V|).
     * 
     * Precondición: [v] pertenece al conjunto de vértices del grafo.
     * Postcondición: [adyacentes] es un objeto iterable que contiene
     *                todos los lados del grafo adyacentes al vértice [v].
     */
    fun adyacentes(v: Int): Iterable<Lado>

    /** 
     * Retorna el grado del vértice [v] del grafo.
     * 
     * @throws [RuntimeException] El vértice está fuera del intervalo [0..|V|).
     *
     * Precondición: [v] pertenece al conjunto de vértices del grafo.
     * Postcondición: [grado] es un entero con el grado de [v].
     */
    fun grado(v: Int): Int
}