package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
	private String nombre;
	
	public Cliente(String pNombre) {
        nombre = pNombre;
    }
	
    public String statement() {
        double montoTotal = 0;
        int puntosAlquilerFrecuente = 0;
        Iterator<Alquiler> iterator= alquileres.iterator();
        String result = "Alquileres de " + nombre + ":\n";
        while (iterator.hasNext()) {
            double montoAlquiler = 0;
            Alquiler alquiler = iterator.next();

            //determine amounts for each line
            switch (alquiler.getDisco().getPelicula().getCodigoPrecio()) {
                case Pelicula.NORMAL:
                    montoAlquiler += 2;
                    if (alquiler.getDiasAlquilado() > 2)
                        montoAlquiler += (alquiler.getDiasAlquilado() - 2) * 1.5;
                    break;
                case Pelicula.ESTRENO:
                    montoAlquiler += alquiler.getDiasAlquilado() * 3;
                    break;
                case Pelicula.INFANTIL:
                    montoAlquiler += 1.5;
                    if (alquiler.getDiasAlquilado() > 3)
                        montoAlquiler += (alquiler.getDiasAlquilado() - 3) * 1.5;
                    break;

            }
            montoTotal += montoAlquiler;

            puntosAlquilerFrecuente ++;
            // agregar bono por alquiler de pelicula "estreno"
            if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == Pelicula.ESTRENO) && alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;

            //mostrar datos
            result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(montoAlquiler) + "\n";

        }
        //fin del reporte
        result +=  "Monto total:  " + String.valueOf(montoTotal) + "\n";
        result += "Gano " + String.valueOf(puntosAlquilerFrecuente) + " puntos por alquiler frecuente";
        return result;

    }
	public String getNombre() {
		return nombre;
	}
    
    
    public void addRental(Alquiler arg) {
    	alquileres.add(arg);
    }
    public static Cliente get(String name) {
    	return (Cliente) Registrar.get("Clientes", name);
    }
    public void persist() {
    	Registrar.add("Clientes", this);
    }
    private ArrayList<Alquiler> alquileres= new ArrayList<>();
}
