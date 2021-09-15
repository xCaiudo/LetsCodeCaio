package br.com.letscode.java;


import java.text.*;
import java.util.*;


public class DesafioAnoMesDia {
    public static void  main(String[] args) throws ParseException {

        String stringDaData;
        Locale local = new Locale ("pt", "BR");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a data: yyyy/mm/dd");
        stringDaData = sc.next();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date data = df.parse(stringDaData);
        DateFormat dfExtenso = new SimpleDateFormat("EEEE , dd 'de' MMMM 'de' yyyy",local);
        DateFormat dfDiaExtenso = new SimpleDateFormat("EEEE",local);
        String diaExtenso = dfDiaExtenso.format(data);
        String[] dataArray = stringDaData.split("/");
        int ano = Integer.parseInt(dataArray[0]);

        Calendar cal = Calendar.getInstance();
        cal.set (Calendar.YEAR, ano);
        String eBissexto = "";

        if (cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365){
            eBissexto = "É ano bissexto!";
        }
        else {
            eBissexto = "Não é ano bissexto!";
        }

        String eFimDeSemana = "";

        if (diaExtenso.equals("sábado") || diaExtenso.equals("domingo")){
            eFimDeSemana = "é fim de semana!";
        }
        else {
            eFimDeSemana = "não é fim de semana :(";
        }
        System.out.println(dfExtenso.format (data));
        System.out.println(eFimDeSemana);
        System.out.println(eBissexto);
    }
}
