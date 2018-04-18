package com.renta.peliculas;

public class Disco {
    public Pelicula getPelicula() {
    	return pelicula;
    }
    
    public Disco(String pNumeroSerie, Pelicula pPelicula) {
    	setNumeroSerie(pNumeroSerie);
    	pelicula = pPelicula;
    }
    
    public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	private String numeroSerie; 
    private Pelicula pelicula;
}
