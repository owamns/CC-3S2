## Respuestas

### Pruebas en sotware - parte1

**Ejercicio 1**

Aquí hay un método con errores:

``` 
/**
 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo
 */
boolean andAll(boolean[] bits) {
  boolean result = bits[0];
  for (int i = 1; i < 31; i++) {
    result = result && bits[i];
  }
  return result;
}

``` 
Abejita, quien escribió este método y cree que debería funcionar, lo prueba en un par de casos de prueba elegidos al azar que se muestran a continuación. ¿Cuál es el resultado de cada caso de prueba? 

- `andAll([true, true, true, ..., true, true]) // 32 valores true` 
```
R: True
```
- `andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true ` 
```
R: False
```
- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error?
```
R: for (int i = 1; i < 31; i++)
```
- ¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?
```
R: se necesitarían todos los posibles casos de entrada, que en este caso son 2^32 posibles combinaciones de valores true y false en el arreglo de 32 bits. Por lo tanto, se requerirían 2^32 casos de prueba para una prueba exhaustiva.
```

**Ejercicio 2**

En la década de 1990, el vehículo de lanzamiento Ariane 5, diseñado y construido para la Agencia Espacial Europea, se autodestruyó 37 segundos después de su primer lanzamiento. El motivo fue un error del software de control que no se detectó. El software de guía del Ariane 5 se reutilizó del Ariane 4, que era un cohete más lento. Cuando el cálculo de la velocidad se convirtió de un número de coma flotante de 64 bits (el mismo que un número en TypeScript, aunque este software no se escribió en TypeScript) a un número entero con signo de 16 bits, desbordó el número entero pequeño y provocó una excepción. El controlador de excepciones se había deshabilitado por razones de eficiencia, por lo que el software de guía se bloqueó. Sin guía, el cohete también se estrelló. El costo de la falla fue de mil millones de dólares. 

 ¿Qué ideas demuestra esta historia? 

- Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.
- Probar todas las entradas posibles es la mejor solución a este problema. 
- El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente. 
- La verificación de tipos estáticos podría haber detectado este error.
```
R: 
- Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.
- El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente. 
```

**Ejercicio 3**

Un conjunto de pruebas es correcto si: 

- Todos sus casos de prueba fallan cuando se ejecutan en una implementación con errores 
- Algún caso de prueba falla cuando se ejecuta en una implementación con errores
- Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal 
- algunos casos de prueba pasan cuando se ejecutan en una implementación legal 
```
R: 
-Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal.
- algunos casos de prueba pasan cuando se ejecutan en una implementación legal.
```

**Ejercicio 4**

Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es: 

- Correcto 
- Exhaustivo 
- Pequeña

```
R: Correcto
```

**Ejercicios 5**

Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:

```
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.

```
// particion: x < 0; x >= 0
```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
R: Los subdominios están completos.
```

```
// particion: x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto

```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
R: Los subdominios están completos.
```

// particion: x=0, x=1, x=7, x=16
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
R: Los subdominios son correctos.
```

**Ejercicio 6**

Ahora considera esta especificación:

```
/**
 * @param x un entero 
 * @param y un entero, donde x, y no son ambos 0
 * @retorna el GCD de x e y
 */
/
public static int gcd(int x, int y);
```

Evalúa cada una de las siguientes particiones candidatas para gcd.

```
// particion: x e y no son  0
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
R: Los subdominios están completos.
```

```
// particion: x es divisible por y; y es divisible por x; x e y son primeros relativos
```
- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
R: Los subdominios son correctos.
```

**Ejercicio 7**

Para esta función: 

```
/**`
 * @param winsAndLosses una cadena de a lo más 5 de consistiendo de los caracteres 'W' o 'L'
 * @retorna la fraccion de caracteres en winsAndLosses que son 'W'
 */

double winLossRatio(String winsAndLosses);
```
¿Cuáles son los valores límite apropiados para probar esta función?

```
R:
-""
-"WWWWW"
-"LLLLL"
-"WL
```

**Ejercicio 8**

Considera la partición de `a` anterior:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición en realidad combina varios intereses distintos: el signo de `a`, la magnitud de `a` (pequeño o grande) y los valores límite 0 y 1. Podemos pensar en estos intereses como particiones independientes.
De entre las opciones a continuación, elija un subconjunto que serían particiones legales y que juntas captarían los mismos intereses.

- particion en a: `0, 1`
- particion en a: `0`
- particion en a: `1`
- particion en a: `0`, positivo, negativo
- particion en a: positivo, negativo
- particion en a: `1, !=1`
- particion en a: (donde "pequeño" encaja en long y "grande" no)

```
R:
-particion en a: 0, positivo, negativo
-particion en a: (donde "pequeño" encaja en long y "grande" no)
```

**Ejercicio 9**

Considera nuevamente esta partición `a` en un desde arriba:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición tiene 6 subdominios, por lo que pueden cubrirla 6 valores diferentes de `a`, uno elegido para cada subdominio. 

Supongamos que usamos estas tres particiones de a en su lugar:

```
// particion en a: 0, positivo, negativo
// particion en a: 1, !=1
// particion on a: donde "pequeño" encaja en long y "grande" no)
```

Si solo queremos cubrir cada subdominio de las tres particiones, ¿cuántos valores diferentes de a necesitaríamos?.

```
R: Dado que las 3 particiones cubren el mismo interes que la particion original y dado que en esta hay 6 subdominios, entonces deberiamos encontrar 6 valores de a para caca uno de ellos. Por lo tanto necesitamos al menos 6 valores de a. Para cubrir cada subdominio de las 3 particiones necesitamos encontrar 2 valores diferentes para particion, lo que da un total de 6.
```

**Ejercicio 10**

A veces es conveniente pensar y escribir una partición de espacio de entrada en términos de la salida de la función, porque las variaciones en el comportamiento pueden ser más visibles allí. Por ejemplo: 

```
// particion en a.multiply(b): 0, positivo, negativo

```
es la abreviatura de la partición de tres subdominios que consta de:

```
 { (a,b) | a.multiply(b) = 0 }
 { (a,b) | a.multiply(b) > 0 }
 { (a,b) | a.multiply(b) < 0 }

```
Con este enfoque, ¿cuántos casos de prueba se necesitan para cubrir las siguientes tres particiones? 

```
// particion en a: 0, positivo, negativo
// particion en b: 0, positive, negativo
// particion en a.multiply(b): 0, positivo, negativo
````

```
R:
-Para la particion en a: 0, positivo, negativo necesitamos un valor de a para cada subdominio (3 valores)
-Para la particion en b: 0, positivo, negativo necesitamos un valor de b para cada subdominio (3 valores)
-Para la particion en a.multiply(b): 0, positivo, negativo necesitamos un par de (a,b) para cada subdominio (3 valores)
Un total de 9 casos de prueba.
```
