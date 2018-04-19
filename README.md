# cenfotec-bisoft-12
Programacion con Patrones

## Errores encontrados

* La clase registrar funciona bien para los clientes pero no para las peliculas

## Correcion tomada

* Reescribir el metodo Peliculas.get() para que la coleccion sea igual a lo que el Registrar espera para objetos tipo Pelicula
* Agregar punto de retorno en Registrar.add() para que el if sea valido y no se agregue un objeto Cliente incorrecto

## Screenshot
![alt text](https://i.imgur.com/i2pO2a0.png)


## Patrones validos

* Fachada, para separar el reporte del Cliente en una interfaz y que hacer TDD a este sea mas facil y este desacoplado.
  Los valores del reporte deberian venir crudos y no en un string

![alt text](https://i.imgur.com/6ezX7FP.png)


