[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/0sBgnME_)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18633499)
# PSP - Concurrencia

Completa el código proporcionado. Los test unitarios y los ficheros de salida de ejemplo te ayudarán a completar los detalles que no estén en estas especificaciones.

## Especificaciones:
Se trata de un sistema para regular el paso de Fiesteros por la única Puerta de una Discoteca. La Puerta de la Disco solo admite tráfico en un sentido de forma simultánea. El aforo de la discoteca está limitado.

Se deben utilizar los mecanismos de concurrencia adecuados para gestionar el correcto flujo de fiesteros a través de la puerta.

- Un Fiestero es una persona que quiere entrar en la discoteca a bailar. Se le identifica por un DNI (ficticio).
- Un Fiestero puede estar en 4 estados:
    - FUERA de la discoteca (antes de entrar, o después de salir)
    - ENTRANDO, mientras atraviesa la puerta en sentido entrada
    - BAILANDO, mientras está dentro de la discoteca
    - SALIENDO, mientras atraviesa la puerta en sentido salida
- Un Fiestero sabe por qué puerta debe entrar (aunque solo haya una).
- Todos los fiesteros hacen lo mismo:
    - Quieren entrar en la discoteca
    - Tardan un rato en cruzar la puerta (entre 0 y 500 ms)
    - Están un rato bailando dentro de la discoteca (entre 0 y 5500 ms)
    - Cuando terminan de bailar, quieren salir de la discoteca
    - Tardan un rato en cruzar la puerta (entre 0 y 500 ms)
- En este establecimiento se cumple lo de "Antes de entrar, dejen salir"
- Cada operación (empezar a entrar o salir, y llegar a estar dentro o fuera), se trazará, por la salida estándar, indicando: dni y estado del fiestero, acción en curso ("Entrando", "Saliendo", "Ha entrado" o "Ha salido"), el aforo actual del local, la lista de fiesteros (solo su dni) que están en el interior del local, la lista de fiesteros (dni + estado) que están en la cola de entrada y la lista de fiesteros (dni + estado) que están en la cola de salida, como se puede observar en el fichero hebras_salida_100en50.txt.
- Cuando un Fiestero se quede esperando, bien sea para entrar o para salir, se indicará, por la salida de error, su dni, su estado y "esperando...", como también se puede observar en el fichero hebras_salida_100en50.txt.

## Requisitos:
- Debes respetar el código proporcionado.
- Cuida la calidad de tu código y las convenciones Java.
- Utiliza correctamente el sistema de control de versiones, comiteando avances regularmente y con mensajes adecuados. Se recomienda comitear, al menos, tras cada avance en la superación de tests.
- Si haces cambios sobre los tests, no debes comitearlos.
- Si algún test "funciona en local", pero no en la plataforma, puedes adjuntar pruebas de ello (explicadas, completas y de fácil lectura) en una carpeta "pruebas", en la raíz del repositorio.
- El trabajo debe repartirse de forma equitativa entre los componentes del equipo.
- Saca partido del control de versiones: crea una rama por tarea y utiliza merge request para que el equipo la valide.

Se recomienda intentar superar los tests de uno a uno, y por el orden de numeración indicado.

Para cualquier aclaración adicional, se puede contactar con la profesora vía email.

### Hebras (24 puntos):
- T00 Fiestero: 1 pto
- T01 Solitario: 1 pto
- T02 Parejita: 2 pto
- T03 Grupo: 4 pto
- T04 Fiesta: 4 pto
- Revisión manual: 12 ptos (solo se realizará si se superan los 6 puntos en los tests automáticos)