import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("John", "Marias", "Alex", "Rolando", "Kevin");
        Predicate<String> contieneO = name -> name.contains("o");

        names.stream().filter(contieneO).forEach(System.out::println);

        //Lista Ciudades mas pobladas por cada continente
        //Ciudad mas poblada de todos los continentes
        //Encontrar la lista de las peliculas que contengan los generos de Drama y Comedia

        //AMERICA

        Ciudad ac1 = new Ciudad();
        ac1.setNombreCiudad("Ciudad de México");
        ac1.setNroPoblacion(23000000);

        Pais p1 = new Pais();
        p1.setNombrePais("Mexico");
        p1.setCiudades(List.of(ac1));
        p1.setNombreContinente("America");

        Ciudad ac2 = new Ciudad();
        ac2.setNombreCiudad("Sao Paulo");
        ac2.setNroPoblacion(21000000);

        Pais p2 = new Pais();
        p2.setNombrePais("Brasil");
        p2.setCiudades(List.of(ac2));
        p2.setNombreContinente("America");

        //AFRICA

        Ciudad afc1 = new Ciudad();
        afc1.setNombreCiudad("El Cairo");
        afc1.setNroPoblacion(20000000);

        Pais afp1 = new Pais();
        afp1.setNombrePais("Egipto");
        afp1.setCiudades(List.of(ac1));
        afp1.setNombreContinente("Africa");

        Ciudad afc2 = new Ciudad();
        afc2.setNombreCiudad("Lagos");
        afc2.setNroPoblacion(13000000);

        Pais afp2 = new Pais();
        afp2.setNombrePais("Nigeria");
        afp2.setCiudades(List.of(ac2));
        afp2.setNombreContinente("Africa");


        //OCEANIA

        //EUROPA


        //ASIA



        System.out.println("################################################################################################################################");


        List<Pais> listaPaises = pais -> pais

        paisNames.stream().filter().forEach(sout    )

    }
}