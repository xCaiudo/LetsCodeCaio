package br.com.letscode.java;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicacao {

    private List<Oscar>listaAtores;

    public static void main(String[] args) {
        Aplicacao appHomem = new Aplicacao();
        Aplicacao appMulher = new Aplicacao();
        Aplicacao app = new Aplicacao();
        appHomem.testeLeituraArquivosCsv("oscar_age_male.csv");
        appMulher.testeLeituraArquivosCsv("oscar_age_female.csv");



//      1- Quem foi o ator mais jovem a ganhar um Oscar?
        System.out.println("O ator mais novo é: ");
        appHomem.findAtorMaisNovo();
        System.out.println();

//        2- Quem foi a atriz que mais vezes foi premiada?
        System.out.println("A atriz que recebeu mais premios foi: ");
        appMulher.findAtrizMaisPremiada();
        System.out.println();

//        3- Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?
        System.out.println("A(s) atriz(es) no range que teve mais premios: ");
        appMulher.findAtrizMaisPremiadaComRange(20,30);


//        4- Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes.
        List<Oscar> listaHomem = new ArrayList<>(appHomem.listaAtores);
        List<Oscar> listaMulher = new ArrayList<>(appMulher.listaAtores);
        List<List<Oscar>> listaCompleta = List.of(listaHomem, listaMulher);
        System.out.println();
        System.out.println("Atores com mais de um oscar: ");
        app.todosAtoresQueReceberamMaisDeumOscar(listaCompleta);



//        5-Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada
//        filme pelo qual foi premiado(a).
        System.out.println();
        app.findInfoDoAtor("Tom Hanks",listaCompleta);


    }

    private void findInfoDoAtor(String nome, List<List<Oscar>> list) {
        System.out.printf("As informações de %s são: ", nome);
        Stream.of(list)
                .flatMap(List::stream)
                .flatMap(List::stream)
                .filter(person -> person.getName().equals(nome))
                .forEach(System.out::println);


    }

    private void todosAtoresQueReceberamMaisDeumOscar(List<List<Oscar>> list) {
        Stream.of(list)
                .flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Oscar::getName, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toList())
                .stream()
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }

    private void findAtrizMaisPremiadaComRange(int rangeInicial, int rangeFinal) {
        this.listaAtores.stream()
                .filter(e -> e.getAge() >=rangeInicial && e.getAge() <= rangeFinal)
                .collect(Collectors.groupingBy(Oscar::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    private void findAtrizMaisPremiada() {
        this.listaAtores.stream()
                .collect(Collectors.groupingBy(Oscar::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    private void findAtorMaisNovo() {
    this.listaAtores.stream()
            .min(Comparator.comparingInt(Oscar::getAge))
            .ifPresent(System.out::println);
    }

    private void testeLeituraArquivosCsv(String filename) {
        String filepath = getFilapathFromResourceAsStream(filename);

        try(Stream<String> lines = Files.lines(Path.of(filepath))){
            this.listaAtores =lines.skip(1)
                    .map(Oscar::converterEmAtores)
                    .collect(Collectors.toList());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getFilapathFromResourceAsStream(String filename) {
        URL url = getClass().getClassLoader().getResource(filename);
        File file = new File(url.getFile());
        return file.getPath();

    }
}






