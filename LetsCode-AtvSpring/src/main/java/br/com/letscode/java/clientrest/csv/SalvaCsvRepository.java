package br.com.letscode.java.clientrest.csv;

import br.com.letscode.java.clientrest.client.MovieMinimal;
import br.com.letscode.java.clientrest.client.ResultSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalvaCsvRepository {

    private String path;
    private List<SalvaCsv> listaInformacaoSalva;

    public SalvaCsvRepository() {
        this.path = Optional.ofNullable((getClass().getClassLoader().getResource("cache.csv")))
                .map(url -> new File(url.getFile()).getPath())
                .orElseThrow();
        this.updateListaInformacaoSalva();
    }

    //realiza um refresh na lista toda vez que fazemos uma busca
    private void updateListaInformacaoSalva(){
        try(Stream<String> lines = Files.lines(Paths.get(this.path))){
            this.listaInformacaoSalva = lines
                    .map(SalvaCsv::pelaLinha)
                    .collect(Collectors.toList());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //search pelo arquivo csv
    public List<MovieMinimal> busca(String title){
        return this.listaInformacaoSalva.stream()
                .filter(cr -> cr.getTitle().equalsIgnoreCase(title) && cr.getResponse())
                .map(SalvaCsv::getMovieMinimal)
                .collect(Collectors.toList());
    }

    //escrita com o arquivo csv
    public void escrever(String title, ResultSearch resultSearch){
        int total = resultSearch.getTotal();
        boolean response = resultSearch.getResponse();
        resultSearch.getResultList()
                .forEach(e -> this.escreverLinha(title,total,response,e.getImdbId(),e.getTitle(),e.getYear()));
        this.updateListaInformacaoSalva();
    }

    private void escreverLinha(String title, int total, boolean response, String imdbId, String tituloFilme, Integer year) {
        String lineStringToReturn = title + ";" + total + ";" + response + ";" + imdbId + ";" + tituloFilme + ";" + year + "\n";
        try{Files.writeString(Path.of(this.path), lineStringToReturn, StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
