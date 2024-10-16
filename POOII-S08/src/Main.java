import Utils.FileUtil;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        final String CIUDADESFILE = "./src/ciudades.txt";
        final String PAISESFILE = "./src/paises.txt";
        final String GENEROSFILE = "./src/generos.txt";
        final String DIRECTORESFILE = "./src/directores.txt";
        final String PELICULASFILE = "./src/peliculas.txt";

        FileUtil fu = new FileUtil();

        //Lista Ciudades mas pobladas por cada continente

        //CREAR CIUDADES
        List<String> cTxtLines = fu.readFile(CIUDADESFILE);
        List<Ciudad> ciudades = cTxtLines.stream().map(line -> line.split(","))
                .map(cdatos -> new Ciudad(
                        Integer.parseInt(cdatos[0]),
                        cdatos[1],
                        Integer.parseInt(cdatos[2]),
                        cdatos[3]
                )).toList();

        //CREAR PAISES
        List<String> pTxtLines = fu.readFile(PAISESFILE);
        List<Pais> paises = pTxtLines.stream().map(line -> line.split(","))
                .map(pdatos -> new Pais(
                        pdatos[0],
                        pdatos[1],
                        pdatos[2],
                        Double.parseDouble(pdatos[3]),
                        Integer.parseInt(pdatos[4]),
                        Integer.parseInt(pdatos[5]),
                        ciudades.stream().filter(ciudad -> ciudad.getCodCiudad().contains(pdatos[0])).toList()
                )).toList();


        Map<String, List<Ciudad>> ciudadesTop3PorContinente = paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::getNombreContinente,
                        Collectors.flatMapping(
                                pais -> pais.getCiudades().stream(),
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        listaCiudades -> listaCiudades.stream()
                                                .sorted(Comparator.comparingInt(Ciudad::getNroPoblacion).reversed())
                                                .limit(3)
                                                .collect(Collectors.toList())
                                )
                        )
                ));

        System.out.println("CiudadesTop: " + ciudadesTop3PorContinente.get("America").size());

        ciudadesTop3PorContinente.forEach((continente, ciudadesTop) -> {
            System.out.println("Continente: " + continente);
            ciudadesTop.forEach(ciudad ->
                    System.out.println(
                            "Ciudad: " + ciudad.getNombreCiudad() +
                                    ", Poblacion: " + ciudad.getNroPoblacion()
                    )
            );
        });

        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");

        //Ciudad mas poblada de todos los continentes

        Optional<Ciudad> ciudadMasPoblada = ciudades.stream().max(Comparator.comparingInt(Ciudad::getNroPoblacion));

        ciudadMasPoblada.ifPresent(ciudad -> System.out.println("Ciudad mas poblada entre todos los continentes: " + ciudad.getNombreCiudad()));

        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");

        //Encontrar la lista de las peliculas que contengan los generos de Drama y Comedia


        //CREAR GENEROS
        List<String> gTxtLines = fu.readFile(GENEROSFILE);
        List<Genero> generos = gTxtLines.stream().map(line -> line.split(","))
                .map(gdatos -> new Genero(
                        Integer.parseInt(gdatos[0]),
                        gdatos[1]
                )).toList();


        //CREAR DIRECTORES
        List<String> dTxtLines = fu.readFile(DIRECTORESFILE);
        List<Director> directores = dTxtLines.stream().map(line -> line.split(","))
                .map(ddatos -> new Director(
                        Integer.parseInt(ddatos[0]),
                        ddatos[1],
                        new ArrayList<>(Arrays.asList(ddatos[2], ddatos[3]))
                )).toList();


        //CREAR PELICULAS
        List<String> mTxtLines = fu.readFile(PELICULASFILE);
        List<Pelicula> peliculas = mTxtLines.stream().map(line -> line.split(","))
                .map(mdatos -> {

                        Pelicula p = new Pelicula(
                        Integer.parseInt(mdatos[0]),
                        mdatos[1],
                        Integer.parseInt(mdatos[2]),
                        mdatos[3],
                        new ArrayList<>(),
                        new ArrayList<>()
                        );

                        if (mdatos[1].contains("Avatar")) {
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Ciencia Ficción"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            directores.stream()
                                    .filter(director -> director.getNombreDirector().equals("James Cameron"))
                                    .findFirst()
                                    .ifPresent(director -> p.getDirectores().add(director));
                        }
                        if (mdatos[1].contains("Amigos Intocables")) {
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Drama"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Comedia"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            directores.stream()
                                    .filter(director -> director.getNombreDirector().equals("Olivier Nakache"))
                                    .findFirst()
                                    .ifPresent(director -> p.getDirectores().add(director));
                        }
                        if (mdatos[1].contains("La La Land")) {
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Drama"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Comedia"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            directores.stream()
                                    .filter(director -> director.getNombreDirector().equals("Damien Chazelle"))
                                    .findFirst()
                                    .ifPresent(director -> p.getDirectores().add(director));
                        }
                        if (mdatos[1].contains("The Truman Show")) {
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Drama"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            generos.stream()
                                    .filter(genero -> genero.getNombreGenero().equals("Comedia"))
                                    .findFirst()
                                    .ifPresent(genero -> p.getGeneros().add(genero));
                            directores.stream()
                                    .filter(director -> director.getNombreDirector().equals("Peter Weir"))
                                    .findFirst()
                                    .ifPresent(director -> p.getDirectores().add(director));
                        }

                        return p;
                        }).toList();


        List<Pelicula> peliculasFiltradas = peliculas.stream()
                .filter(p -> p.getGeneros().stream()
                        .anyMatch(genero -> genero.getNombreGenero().equals("Comedia")) &&
                        p.getGeneros().stream()
                                .anyMatch(genero -> genero.getNombreGenero().equals("Drama"))).toList();


        peliculasFiltradas.forEach(pelicula -> {
            String generosDC = pelicula.getGeneros().stream()
                    .map(Genero::getNombreGenero)
                    .collect(Collectors.joining(", "));
            System.out.println("Pelicula: " + pelicula.getTituloPelicula() + " tiene los generos: " + generosDC);
        });

    }
}