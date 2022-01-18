# grafoLib

**grafoLib** es una librería de grafos programada desde cero en Kotlin que implementa numerosos algoritmos sobre grafos dirigidos y no dirigidos.

Realizada con fines académicos para el curso de CI-2693 de la Universidad Simón Bolívar (Sartenejas, Venezuela), dictado por el profesor Guillermo Palma (gvpalma@usb.ve) en el periodo Septiembre-Diciembre 2021.

## Especificaciones

La carpeta de Especificaciones contiene las especificaciones seguidas a para la implementación cada clase de la librería, donde se indican qué métodos y algoritmo debían ser implementado, junto a indicaciones adicionales del profesor del curso.

La librería fue construida siguiendo las especificaciones contenidas en los archivos de la carpeta, a lo largo de nueve laboratorios y dos proyectos.

## Estudios

La carpeta incluye dos estudios sobre algoritmos:

+ **AlgoritmosMTS**: Estudio sobre la eficiencia y los resultados de los algoritmos implementados en la librería para hallar componentes conexas y árboles mínimos cobertores en grafos no dirigidos. En específico, compara:
  - **Para hallar componentes conexas**:
    - Un algoritmo basado en Búsqueda en Profundidad (DFS), implementado de forma recursiva e iterativa.
    - Un algoritmo basado en la estructura de datos de conjuntos disjuntos, implementada usando las heurísticas de compresión de camino y de compresión por rango.
  - **Para hallar árboles mínimos cobertores**:
    - El algoritmo de Kruskal, que usa la estructura de conjuntos disjuntos.
    - El algoritmo de Prim, usando una cola de prioridad basada en binary heap, implementada como clase interna.

+ **Solución RPP**: Estudio sobre la implementación realizada en la clase HeuristicaRPP de un algorito heurístico propuesto por Pearn y Wu para resolver el [problema del cartero rural](https://es.wikipedia.org/wiki/Problema_del_cartero_chino#Variantes), o RPP (Rural Postman Problem). Se explica la solución y los detalles de implementación pertinentes, y se incluye un análisis comparativo de los resultados, comparando la eficacia y eficiencia del algoritmo usando dos algoritmos heurísticos para hallar apareamientos perfectos de costo mínimo aproximado:
  - Un algoritmo ávido descrito en el archivo correspondiente al Proyecto 2 en la carpeta de especificaciones.
  - El algoritmo Vertex-Scan propuesto por David Avis.

## Compilación

Se incluye un _Makefile_ que compila la librería entera con el comando
```
> make
```

## Descripción

La librería entera es construida usando como base la interfaz `Grafo` y la clase abstracta `Lado`. Las clases que implementan `Grafo` son `GrafoNoDirigido` y `GrafoDirigido`, y las implementaciones de `Lado` se encuentran en `Arista` y `Arco`, como los lados de `GrafoNoDirigido` y `GrafoDirigifo`, respectivamente.

## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

---
⌨️ con ❤️ por [chrischriscris](https://github.com/chrischriscris) 😊
