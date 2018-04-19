import com.renta.peliculas.Alquiler;
import com.renta.peliculas.Disco;
import com.renta.peliculas.Pelicula;
import org.junit.Assert;
import org.junit.Test;

public class AlquilerTest {

    Pelicula testPeliculaNormal= new Pelicula("Pelicula de prueba",Pelicula.NORMAL);
    Disco testDiscoNormal = new Disco("123",testPeliculaNormal);
    Alquiler testAlquilerTresDias = new Alquiler(testDiscoNormal,3);

    @Test
    public void getDiasAlquilado() {
        Assert.assertEquals(3,testAlquilerTresDias.getDiasAlquilado());
    }

    @Test
    public void getDisco() {
        Assert.assertEquals(testDiscoNormal,testAlquilerTresDias.getDisco());
    }
}
