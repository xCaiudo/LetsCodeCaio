package br.com.letscode.java;

import java.util.Scanner;

class JogoDaVelha {

    public static void main(String[] args) {

        //Cria um array 3 por 3 que representa o jogo da velha
        char[][] mesa = new char[3][3];

        //Inicializa o tabuleiro com - para sinalziar que esta vazio
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                mesa[i][j] = '-';
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Bota Jogar!");
        System.out.print("Jogador 1, digite seu nome:  ");
        String jogador1 = sc.nextLine();
        System.out.print("Jogador 2, digite seu nome:  ");
        String jogador2 = sc.nextLine();

        //Variavel player 1 com valor true para sinalizar que é o turno do jogador 1, caso senha falsa é turno do
        // jogador numero 2
        boolean checaJogador = true;

        //Cria uma variavel para o fim do jogo dentro de um while
        boolean gameFim = false;
        while(!gameFim) {

            //Desenha a mesa
            desenhaMesa(mesa);

            //Informa de quem é o turno
            if(checaJogador) {
                System.out.println("Turno do " + jogador1 + "(x):");
            } else {
                System.out.println("Turno do "+ jogador2 + "(o):");
            }

            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            //cria a variavel que ou é X ou é O baseado no turno do jogador
            char jogadaXO = '-';
            if(checaJogador) {
                jogadaXO = 'x';
            } else {
                jogadaXO = 'o';
            }


            int linha = 0;
            int coluna = 0;

            //só escada do while se o usuario informar uma posição valida
            while(true) {

                //Informa qual é a posição da jogada do player para colocar o X ou O
                System.out.print("Insira o número da linha (0, 1, ou 2): ");
                linha = sc.nextInt();
                System.out.print("Insira o número da coluna (0, 1, ou 2): ");
                coluna = sc.nextInt();

                //if para checar se foi uma jogada valida
                if(linha < 0 || coluna < 0 || linha > 2 || coluna > 2) {
                    System.out.println("Posição invalida! Tente novamente.");

                    //Checa se a posição inserida esta vazia(possui um -) ou não
                } else if(mesa[linha][coluna] != '-') {
                    System.out.println("Esta posição já esta sendo usada! Tente novamente.");

                    //Quebra o loop já que vai se tornar uma posição valida.
                } else {
                    break;
                }

            }

            //Seleciona a posição no tabuleiro na linha, coluna para o caracter X e O registrado no jogadaXO
            mesa[linha][coluna] = jogadaXO;

            //verificador de vitória
            if(jogadorGanhou(mesa) == 'x') {
                System.out.println(jogador1 + " venceu!");
                gameFim = true;
            } else if(jogadorGanhou(mesa) == 'o') {
                System.out.println(jogador2 + " venceu!");
                gameFim = true;
            } else {

                //Verifica se a mesa está cheia, causando um empate.
                if(mesaCheia(mesa)) {
                    System.out.println("Vish, empatou =0");
                    gameFim = true;
                } else {
                    //Método de alternar entre jogador1 e jogador2
                    checaJogador = !checaJogador;
                }

            }

        }

        //Desenha a mesa no fim do jogo
        desenhaMesa(mesa);

    }
    
    //Método que server para desenhar o tabuleiro
    public static void desenhaMesa(char[][] mesa) {
        System.out.println("Tabuleiro:");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(mesa[i][j]);
            }
            System.out.println();
        }
    }

  
    //Método que verifica se alguem ganhou
    public static char jogadorGanhou(char[][] mesa) {

        //Checar cada linha
        for(int i = 0; i < 3; i++) {
            if(mesa[i][0] == mesa[i][1] && mesa[i][1] == mesa[i][2] && mesa[i][0] != '-') {
                return mesa[i][0];
            }
        }

        //Checar cada coluna
        for(int j = 0; j < 3; j++) {
            if(mesa[0][j] == mesa[1][j] && mesa[1][j] == mesa[2][j] && mesa[0][j] != '-') {
                return mesa[0][j];
            }
        }

        //Checa as diagonais
        if(mesa[0][0] == mesa[1][1] && mesa[1][1] == mesa[2][2] && mesa[0][0] != '-') {
            return mesa[0][0];
        }
        if(mesa[2][0] == mesa[1][1] && mesa[1][1] ==  mesa[0][2] && mesa[2][0] != '-') {
            return mesa[2][0];
        }

        //nenhuma das condições forem verdadeiras, então ninguem ganhou
        return ' ';

    }

    //Método que checa se todas a posições foram ocupada
    public static boolean mesaCheia(char[][] mesa) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(mesa[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
