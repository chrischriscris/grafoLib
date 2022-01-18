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
 * Implementación del algoritmo de Kruskal que determina el árbol mínimo
 * cobertor de un grafo no dirigido.
 * 
 * Se basa en la estructura de Conjuntos Disjuntos.
 * 
 * Se determina el árbol minimo cobertor con la creación de una instancia
 * de la clase.
 * 
 * @param [g]: grafo no dirigido sobre el que se ejecuta el algoritmo.
 */
public class ArbolMinimoCobertorKruskal(val g: GrafoNoDirigido) {

    private val dSet = ConjuntosDisjuntos(g.obtenerNumeroDeVertices())
    private val amc = mutableSetOf<Arista>()
    private var w = 0.0

    init {
        val aristasOrdenadas = g.aristas().sorted()

        aristasOrdenadas.forEach {
            val u = it.cualquieraDeLosVertices()
            val v = it.elOtroVertice(u)

            if (dSet.encontrarConjunto(u) != dSet.encontrarConjunto(v)) {
                amc.add(it)
                dSet.union(u, v)
            }
        }
        amc.forEach { w += it.peso() }
    }

    /**
     * Retorna un objeto iterable con los lados del árbol mínimo cobertor
     * hallado.
     * 
     * Tiempo de ejecución: O(1).
     * Precondición: true.
     * Postcondición: [obtenerLados] es un objeto iterable de <Aristas> con
     *                un árbol mínimo cobertor del grafo [g].
     */
    fun obtenerLados(): Iterable<Arista> = amc
    
    /**
     * Retorna el peso del árbol mínimo cobertor hallado.
     * 
     * Tiempo de ejecución: O(1).
     * Precondición: true.
     * Postcondición: [obtenerPeso] es un Double con el peso del
     *                árbol mínimo cobertor de obtenerLados().
     */
    fun obtenerPeso(): Double = w
}
