package br.com.biaconde.jogodavelha;

public class JogoDaVelha {

    private String[] tabuleiro =
            {
                    " ", " ", " ",
                    " ", " ", " ",
                    " ", " ", " "
            };

    public String[] getTabuleiro() {
        return this.tabuleiro;
    }

    public void playX(int posicao) {
        tabuleiro[posicao] = "X";
    }

    public void playO(int posicao) {
        tabuleiro[posicao] = "O";
    }

    public boolean isJogadaValida(int posicao) {
        if(posicao < 0 || posicao > 8) {
            return false;
        }
        return !posicaoPreenchida(posicao);
    }

    public boolean posicaoPreenchida(int posicao) {
        return tabuleiro[posicao] != " ";
    }

    public boolean isGameOver() {
        if( isJogador1Ganhou() || isJogador2Ganhou()) {
            return true;
        } else {
            return todasAsPosicoesPreenchidas();
        }
    }

    public boolean isJogador1Ganhou() {
        return  (tabuleiro[0].equals("O") && tabuleiro[1].equals("O") && tabuleiro[2].equals( "O")) ||
                (tabuleiro[3].equals("O") && tabuleiro[4].equals("O") && tabuleiro[5].equals( "O")) ||
                (tabuleiro[6].equals("O") && tabuleiro[7].equals("O") && tabuleiro[8].equals( "O")) ||

                (tabuleiro[0].equals("O") && tabuleiro[3].equals("O") && tabuleiro[6].equals( "O")) ||
                (tabuleiro[1].equals("O") && tabuleiro[4].equals("O") && tabuleiro[7].equals( "O")) ||
                (tabuleiro[2].equals("O") && tabuleiro[5].equals("O") && tabuleiro[8].equals( "O")) ||

                (tabuleiro[0].equals("O") && tabuleiro[4].equals("O") && tabuleiro[8].equals( "O")) ||
                (tabuleiro[2].equals("O") && tabuleiro[4].equals("O") && tabuleiro[6].equals( "O"));
    }

    public boolean isJogador2Ganhou() {
        return  (tabuleiro[0].equals("X") && tabuleiro[1].equals("X") && tabuleiro[2].equals( "X")) ||
                (tabuleiro[3].equals("X") && tabuleiro[4].equals("X") && tabuleiro[5].equals( "X")) ||
                (tabuleiro[6].equals("X") && tabuleiro[7].equals("X") && tabuleiro[8].equals( "X")) ||

                (tabuleiro[0].equals("X") && tabuleiro[3].equals("X") && tabuleiro[6].equals( "X")) ||
                (tabuleiro[1].equals("X") && tabuleiro[4].equals("X") && tabuleiro[7].equals( "X")) ||
                (tabuleiro[2].equals("X") && tabuleiro[5].equals("X") && tabuleiro[8].equals( "X")) ||

                (tabuleiro[0].equals("X") && tabuleiro[4].equals("X") && tabuleiro[8].equals( "X")) ||
                (tabuleiro[2].equals("X") && tabuleiro[4].equals("X") && tabuleiro[6].equals( "X"));
    }

    public boolean todasAsPosicoesPreenchidas() {
        int preenchidos = 0;
        for(int i = 0; i < tabuleiro.length; i++) {
            if(posicaoPreenchida(i)) {
                preenchidos++;
            } else {
                break;
            }
        }
        return preenchidos == tabuleiro.length;
    }

    public String toString() {
        return 	tabuleiro[0] + " | " + tabuleiro[1] + " | " + tabuleiro[2] + "\n" +
                "---------\n" +
                tabuleiro[3] + " | " + tabuleiro[4] + " | " + tabuleiro[5] + "\n" +
                "---------\n" +
                tabuleiro[6] + " | " + tabuleiro[7] + " | " + tabuleiro[8] + "\n";
    }
}
