package test;

import com.renta.peliculas.*;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class ClienteTest {

    Cliente testCliente = new Cliente("Cliente de prueba");


    /*
    * Formulas de calculo de puntos
    * Si Infantil -> alquiler aumenta en 1.5 (por 3 dias), si los dias es mayor a 3 entonces se suma esa diferencia x 1.5
    * Si Estreno -> alquiler aumenta 3 x todos los dias
    * Si Normal -> alquiler aumenta en 2 (por 2 dias), si los dias es mayor a 2, se suma la diferencia x 1.5
    *
    * Bono de cliente frequente si alquila estrenos con una diferencia menor de 1 dia (1 pto extra(
    * */

    @Test

    public void testAlquileresInfantiles(){

        Pelicula testPeliculaInfantil = new Pelicula("Pelicula de prueba",Pelicula.INFANTIL);
        Disco testDiscoInfantil = new Disco("123",testPeliculaInfantil);
        Alquiler testAlquilerTresDias = new Alquiler(testDiscoInfantil,3);
        Alquiler testAlquilerCincoDias = new Alquiler(testDiscoInfantil,5);

        Alquiler testAlquilerDiezDias = new Alquiler(testDiscoInfantil,10);

        testCliente.statement();
        testCliente.addRental(testAlquilerTresDias);
        Assert.assertEquals("Cliente de prueba",testCliente.getNombre());
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t1.5\n" +
                "Monto total:  1.5\n" +
                "Gano 1 puntos por alquiler frecuente", testCliente.statement());

        testCliente.addRental(testAlquilerCincoDias);
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t1.5\n" +
                "\tPelicula de prueba\t4.5\n" +
                "Monto total:  6.0\n" +
                "Gano 2 puntos por alquiler frecuente", testCliente.statement());

        testCliente.addRental(testAlquilerDiezDias);
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t1.5\n" +
                "\tPelicula de prueba\t4.5\n" +
                "\tPelicula de prueba\t12.0\n" +
                "Monto total:  18.0\n" +
                "Gano 3 puntos por alquiler frecuente", testCliente.statement());
    }

    @Test
    public void testAlquileresNormales(){

        Pelicula testPeliculaNormal= new Pelicula("Pelicula de prueba",Pelicula.NORMAL);
        Disco testDiscoNormal = new Disco("123",testPeliculaNormal);
        Alquiler testAlquilerTresDias = new Alquiler(testDiscoNormal,3);
        Alquiler testAlquilerCincoDias = new Alquiler(testDiscoNormal,5);
        Alquiler testAlquilerDiezDias = new Alquiler(testDiscoNormal,10);

        testCliente.statement();
        testCliente.addRental(testAlquilerTresDias);
        Assert.assertEquals("Cliente de prueba",testCliente.getNombre());
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t3.5\n" +
                "Monto total:  3.5\n" +
                "Gano 1 puntos por alquiler frecuente", testCliente.statement());

        testCliente.addRental(testAlquilerCincoDias);
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t3.5\n" +
                "\tPelicula de prueba\t6.5\n" +
                "Monto total:  10.0\n" +
                "Gano 2 puntos por alquiler frecuente", testCliente.statement());

        testCliente.addRental(testAlquilerDiezDias);
        Assert.assertEquals("Alquileres de Cliente de prueba:\n" +
                "\tPelicula de prueba\t3.5\n" +
                "\tPelicula de prueba\t6.5\n" +
                "\tPelicula de prueba\t14.0\n" +
                "Monto total:  24.0\n" +
                "Gano 3 puntos por alquiler frecuente", testCliente.statement());
    }

    @Test
    public void testTiposPeliculas(){
        Pelicula testPeliculaInfantil = new Pelicula("Pelicula de prueba Infantil",Pelicula.INFANTIL);
        Pelicula testPeliculaEstreno = new Pelicula("Pelicula de prueba Estreno",Pelicula.ESTRENO);
        Pelicula testPeliculaNormal = new Pelicula("Pelicula de prueba Normal",Pelicula.NORMAL);

        Disco testDiscoInfantil = new Disco("1",testPeliculaInfantil);
        Disco testDiscoEstreno = new Disco("2",testPeliculaEstreno);
        Disco testDiscoNormal = new Disco("3",testPeliculaNormal);

        Alquiler testAlquilerInfantil = new Alquiler(testDiscoInfantil,3);
        Alquiler testAlquilerNormal = new Alquiler(testDiscoNormal,3);
        Alquiler testAlquilerEstreno = new Alquiler(testDiscoEstreno,3);


        Assert.assertEquals(2,testAlquilerInfantil.getDisco().getPelicula().getCodigoPrecio());
        Assert.assertEquals(0,testAlquilerNormal.getDisco().getPelicula().getCodigoPrecio());
        Assert.assertEquals(1,testAlquilerEstreno.getDisco().getPelicula().getCodigoPrecio());
    }

    @Test
    public void testPersistAndGet() {
        testCliente.persist();
        Assert.assertEquals(testCliente,Cliente.get("Cliente de prueba"));
        Assert.assertEquals(testCliente.getNombre(),Cliente.get("Cliente de prueba").getNombre());
    }

    @Test
    public void testPersistAndGetWithAlquileres(){

        Cliente persistentClient = new Cliente("Persistente");
        Pelicula testPeliculaNormal= new Pelicula("AlphaGo",Pelicula.NORMAL);
        Disco testDiscoNormal = new Disco("NetflixDocumentary01234",testPeliculaNormal);
        Alquiler testAlquilerTresDias = new Alquiler(testDiscoNormal,3);
        Alquiler testAlquilerCincoDias = new Alquiler(testDiscoNormal,5);
        Alquiler testAlquilerDiezDias = new Alquiler(testDiscoNormal,10);

        persistentClient.addRental(testAlquilerTresDias);
        persistentClient.addRental(testAlquilerCincoDias);
        persistentClient.addRental(testAlquilerDiezDias);


        persistentClient.persist();
        Assert.assertEquals("Alquileres de Persistente:\n" +
                "\tAlphaGo\t3.5\n" +
                "\tAlphaGo\t6.5\n" +
                "\tAlphaGo\t14.0\n" +
                "Monto total:  24.0\n" +
                "Gano 3 puntos por alquiler frecuente", Cliente.get("Persistente").statement());
    }

    @Test
    public void testClienteFacade(){
        ClienteFacade fachadaTest = new ClienteFacade("Fachada de interfaz");
        Pelicula testPeliculaNormal= new Pelicula("AlphaGo",Pelicula.NORMAL);
        Disco testDiscoNormal = new Disco("NetflixDocumentary01234",testPeliculaNormal);
        Alquiler testAlquilerTresDias = new Alquiler(testDiscoNormal,3);
        Alquiler testAlquilerCincoDias = new Alquiler(testDiscoNormal,5);
        Alquiler testAlquilerDiezDias = new Alquiler(testDiscoNormal,10);

        fachadaTest.addRental(testAlquilerTresDias);
        fachadaTest.updateInternalAlquileresData();
        Assert.assertEquals(3.5,fachadaTest.getMontosAlquileres().get(0),0.0001);

        fachadaTest.addRental(testAlquilerCincoDias);
        fachadaTest.updateInternalAlquileresData();
        Assert.assertEquals(6.5,fachadaTest.getMontosAlquileres().get(1),0.0001);

        fachadaTest.addRental(testAlquilerDiezDias);
        fachadaTest.updateInternalAlquileresData();
        Assert.assertEquals(14.0,fachadaTest.getMontosAlquileres().get(2),0.0001);

        Assert.assertEquals(24.0,fachadaTest.getMontoTotalAlquieres(),0.0001);
        Assert.assertEquals(3,fachadaTest.getPuntosAlquileresFrecuentes());

    }

}