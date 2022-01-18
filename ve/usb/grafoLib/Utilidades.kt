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
import kotlin.Double.Companion.POSITIVE_INFINITY

/**
 * Retorna el grafo inverso de [g].
 * 
 * Tiempo de ejecución: O(|V| + |E|) en el peor caso.
 * Precondición: [g] es un grafo dirigido.
 * Postcondición: El grafo resultante es un grafo inverso de g.
 */
fun dígrafoInverso(g: GrafoDirigido): GrafoDirigido {
    val gInverso = GrafoDirigido(g.obtenerNumeroDeVertices())

    g.arcos().forEach {
        gInverso.agregarArco(Arco(it.sumidero(), it.fuente()))
    }

    return gInverso
}

/**
 * Retorna la matriz de costos asociada al grafo g.
 *
 * Tiempo de ejecución: O(V²)
 * Precondición: [g] es un grafo dirigido.
 * Postcondición: [matrizDeCostos] es la matriz de costos asociada a g.
 */
fun matrizDeCostos(g: GrafoDirigido): Array<Array<Double>> {
    val n = g.obtenerNumeroDeVertices()

    val W = Array<Array<Double>>(n) { i ->
        Array<Double>(n) { j ->
            if (i == j) 0.0 else POSITIVE_INFINITY
        }
    }

    g.arcos().forEach {
        val i = it.fuente()
        val j = it.sumidero()

        if (i != j) W[i][j] = it.peso()
    }

    return W
}