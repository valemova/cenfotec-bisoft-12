import com.renta.peliculas.Disco;
import com.renta.peliculas.Pelicula;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscoTest {

    @Test
    public void getPelicula() {
        Pelicula testPeliculaNormal= new Pelicula("Pelicula de prueba",Pelicula.NORMAL);
        Disco testDiscoNormal = new Disco("123",testPeliculaNormal);
        Assert.assertEquals(0,testDiscoNormal.getPelicula().getCodigoPrecio());
    }

    @Test
    public void getNumeroSerie() {
        Pelicula testPeliculaNormal= new Pelicula("Pelicula de prueba",Pelicula.NORMAL);
        Disco testDiscoNormal = new Disco("123",testPeliculaNormal);
        Assert.assertEquals("123",testDiscoNormal.getNumeroSerie());
    }
}