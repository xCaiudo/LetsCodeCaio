package br.com.letscode.java.clientrest.rest;

import br.com.letscode.java.clientrest.client.ResultSearch;
import br.com.letscode.java.clientrest.csv.SalvaCsvRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.letscode.java.clientrest.client.*;

import java.util.List;

@RestController
public class SearchRestController  {

    private final MovieMinimalRestRepository restRepository;
    private final SalvaCsvRepository salvaCsvRepository;

    public SearchRestController(MovieMinimalRestRepository restRepository){
        this.restRepository = restRepository;
        this.salvaCsvRepository = new SalvaCsvRepository();
    }

    //Equivale ao /search?title= , ele é o RequestParam onde pega o parametro do title para fazer a busca.
    @GetMapping("/search")
    public ResultSearch search(@RequestParam String title ){
        final List<MovieMinimal> movieMinimalList = this.salvaCsvRepository.busca(title);
        if (movieMinimalList.isEmpty()) {
            final ResultSearch resultSearch = this.restRepository.search(title);
            if (resultSearch.getResponse()) {
                this.salvaCsvRepository.escrever(title, resultSearch);
            }
            return resultSearch;
        } else {
            return new ResultSearch(movieMinimalList, movieMinimalList.size(), true);
        }
    }
}