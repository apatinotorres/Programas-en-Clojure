# Terminología

**Concurrencia:** Cuando varios threads estan realizando trabajo, ya sea en paralelismo o time-slicing.

**Paralelismo:** Condición cuando al menos dos threads se estan ejecutando simultáneamente.

**Estado compartido (Shared state):** cuando varios threads tienen que modificar variables, identidades etc

**Concurrency hazards:** su nombre lo indica.


Clojure fue diseñado con la concurrencia en mente, el uso de inmutable data structures hace posible compartir estas estrcuturas entre threads eliminando varios concurrency hazards.

> Changing variables  in Clojure happens differently from many other languages; in ways that are predictable from the concurrency perspective and which eliminate many concurrency hazards.


## Identity/Value separation


















Fuentes: http://clojure-doc.org/articles/language/concurrency_and_parallelism.html
