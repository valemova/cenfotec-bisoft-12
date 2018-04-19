package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

public class ClienteFacade extends Cliente {

    private int puntosAlquileresFrecuentes;
    private double montoTotalAlquileres;
    private ArrayList<Double> montosAlquileres= new ArrayList<>();

    public ClienteFacade(String name) {
        this.nombre = name;
    }

    public int getPuntosAlquileresFrecuentes() {
        return puntosAlquileresFrecuentes;
    }

    public double getMontoTotalAlquieres() {
        return montoTotalAlquileres;
    }

    public ArrayList<Double> getMontosAlquileres() {
        return montosAlquileres;
    }

    public void updateInternalAlquileresData() {
        double montoTotal = 0;
        int puntosAlquilerFrecuente = 0;
        Iterator<Alquiler> iterator= alquileres.iterator();
        montosAlquileres.clear();
        while (iterator.hasNext()) {
            double montoAlquiler = 0;
            Alquiler alquiler = iterator.next();

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

            if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == Pelicula.ESTRENO) && alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;
            montosAlquileres.add(montoAlquiler);
        }

        this.montoTotalAlquileres = montoTotal;
        this.puntosAlquileresFrecuentes = puntosAlquilerFrecuente;
    }

    private String showMovieListWithAlquiler(String header){
        Iterator<Alquiler> iterator = alquileres.iterator();
        Iterator<Double> montosIterator = montosAlquileres.iterator();
        while (iterator.hasNext()) {
            Alquiler alquiler = iterator.next();
            double montoPelicula = montosIterator.next();
            header += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(montoPelicula) + "\n";
        }
        return header;
    }

    private String showStatementData(String header, double puntos, int total){
        header +=  "Monto total:  " + String.valueOf(total) + "\n";
        header += "Gano " + String.valueOf(puntos) + " puntos por alquiler frecuente";
        return header;
    }

    public String generateClientReport(){
        String report = "Alquileres de " + nombre + ":\n";
        report += showMovieListWithAlquiler(report);
        report += showStatementData(report, this.montoTotalAlquileres, this.puntosAlquileresFrecuentes);
        return report;
    }
}
