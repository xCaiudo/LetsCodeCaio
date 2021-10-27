package br.com.letscode.java.clientrest.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

import lombok.*;

@Value
public class MovieMinimal {


    String imdbId;
    String title;
    Integer year;

    @JsonCreator
    public MovieMinimal(String imdbId, String title, String year){
        this.imdbId = imdbId;
        this.title = title;
        this.year = convertYear(year);
    }



    private int convertYear(final String year) {
        if (year.matches("\\d+")) {
            return Integer.parseInt(year);
        }
        return Arrays.stream(year.split("\\D"))
                .map(Integer::parseInt)
                .findFirst()
                .orElseThrow();
    }
}