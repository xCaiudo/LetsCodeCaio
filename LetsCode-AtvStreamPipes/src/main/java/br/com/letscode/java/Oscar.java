package br.com.letscode.java;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Oscar {


    private int index;
    private int year;
    private int age;
    private String name;
    private String movieName;


    public Oscar(int index, int year, int age, String name, String movieName) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movieName = movieName;
    }



    public static Oscar converterEmAtores(String linhas) {
            String[] campos = linhas.split("; ");

            return new Oscar(Integer.parseInt(campos[0]), // campo 1 index
                    Integer.parseInt(campos[1]),//campo 2 ano
                    Integer.parseInt(campos[2]),//campo 3 age
                    campos[3],//campo 4 nome
                    campos[4]);//campo 5 nome do filme


        }

    }



