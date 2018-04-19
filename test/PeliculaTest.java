import com.renta.peliculas.Pelicula;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliculaTest {

    Pelicula testPeliculaInfantil = new Pelicula("Finding Nemo",Pelicula.INFANTIL);
    Pelicula testPeliculaEstreno = new Pelicula("Dunkirk",Pelicula.ESTRENO);
    Pelicula testPeliculaNormal = new Pelicula("Kill Bill",Pelicula.NORMAL);

    @Test
    public void getCodigoPrecio() {
        Assert.assertEquals(0,testPeliculaNormal.getCodigoPrecio());
        Assert.assertEquals(2,testPeliculaInfantil.getCodigoPrecio());
        Assert.assertEquals(1,testPeliculaEstreno.getCodigoPrecio());
    }

    @Test
    public void getNombre() {
        Assert.assertEquals("Kill Bill", testPeliculaNormal.getNombre());
    }

    @Test
    public void setNombre() {
        String expected = "Kill Bill vol. 2";
        testPeliculaNormal.setNombre(expected);
        Assert.assertEquals(expected, testPeliculaNormal.getNombre());
    }

    @Test
    public void testPersistAndGet() {
        testPeliculaEstreno.persist();
        Assert.assertEquals(testPeliculaEstreno,Pelicula.get("Dunkirk"));

        testPeliculaInfantil.persist();
        Assert.assertEquals(testPeliculaInfantil,Pelicula.get("Finding Nemo"));

        testPeliculaNormal.persist();
        Assert.assertEquals(testPeliculaNormal,Pelicula.get("Kill Bill vol. 2"));
    }
}