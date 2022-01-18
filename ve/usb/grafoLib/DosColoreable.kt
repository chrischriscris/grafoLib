/**
 * grafoLib is a simple library about Graphs
 * Copyright (C) 2022  Christopher Gómez & Ka Fung
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
 * Implementación de un algoritmo basado en Búsqueda en Profundidad
 * para determinar si un grafo dado es bipartito.
 * 
 * Se determina si un grafo es 2-coloreable o bipartito
 * al momento que se crea una instancia de la clase.
 * 
 * @param [g]: Grafo no dirigido sobre el que se ejecuta el algoritmo.
 */
public class DosColoreable(val g: GrafoNoDirigido) {
    // Propiedades de los vértices del grafo
    private val n = g.obtenerNumeroDeVertices()
    private val color = Array<Color>(n) { Color.BLANCO }
    private val bipartitoColor = BooleanArray(n)
    private var bipartito = true

    init {
        for (v in 0 until n) {
            if (color[v] == Color.BLANCO) {
                bipartito = bipartito && dfsVisit(g, v)
            }
        }
    }

    /**
     * Explora recursivamente todos los vértices alcanzables desde [u]
     * en el grafo [g].
     *
     * dfsVisit modificado para determinar si un grafo es bipartito.
     * 
     * Tiempo de ejecución: O(|E|).
     * Precondición: [g] es un grafo.
     *               [u] es un vértice perteneciente al grafo.
     * Postcondición: true
     */
    private fun dfsVisit(g: Grafo, u: Int): Boolean {
        // Se empieza a explorar u
        color[u] = Color.GRIS

        g.adyacentes(u).forEach {
            // Se selecciona el adyacente
            val v = it.elOtroVertice(u)

            if (color[v] == Color.BLANCO) {
                /* Si no se ha visitado el vértice se le
                colorea con el color opuesto al predecesor. */
                bipartitoColor[v] = !bipartitoColor[u]
                
                if (!dfsVisit(g, v)) return false
            } else if (bipartitoColor[u] == bipartitoColor[v]) {
                return false
            }
        }

        // Se termina de explorar u
        color[u] = Color.NEGRO
        return true
    }

    /**
     * Retorna un booleano indicando si [g] es un grafo bipartito.
     * Tiempo de ejecución: O(1).
     * Precondición: true.
     * Postcondición: [esDosColoreable] es -True si [g] cumple con las 
     *                                      propiedades de un grafo bipartito.
     *                                     -False de otra forma.
     */
    fun esDosColoreable(): Boolean = bipartito
}
