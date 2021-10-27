package br.com.letscode.java.clientrest.csv;

import br.com.letscode.java.clientrest.client.MovieMinimal;
import lombok.Value;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

@Value
public class SalvaCsv {
    String title;
    Integer total;
    Boolean response;
    MovieMinimal movieMinimal;

    public SalvaCsv(String title, Integer total, Boolean response, MovieMinimal movieMinimal) {
        this.title = title;
        this.total = total;
        this.response = response;
        this.movieMinimal = movieMinimal;
    }

    public SalvaCsv(String title, String total, String response, String imdbId, String movieTitle, String year){
        this(title, parseInt(total), parseBoolean(response), new MovieMinimal(imdbId,movieTitle,year));

    }

    public static SalvaCsv pelaLinha(String linha){
        final String[] split = linha.split(";");
        return new  SalvaCsv(split[0],split[1],split[2],split[3],split[4],split[5]);
    }



}
