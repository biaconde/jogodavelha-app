package br.com.biaconde.jogodavelha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements TabuleiroObserver {
    private TabuleiroView tabuleiroView;

    private JogoDaVelha jogoDaVelha;

    private boolean jogador1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.tabuleiroView = new TabuleiroView(this);
        tabuleiroView.setBackgroundColor(Color.WHITE);
        setContentView(tabuleiroView);
        iniciarJogo();
    }

    protected void iniciarJogo() {
        jogoDaVelha = new JogoDaVelha();
        jogador1 = true;
        tabuleiroView.atualizarPecas(jogoDaVelha.getTabuleiro());
    }

    @Override
    public void jogou(int posicao) {
        if (!jogoDaVelha.isGameOver() && jogoDaVelha.isJogadaValida(posicao)) {
            if (jogador1) {
                jogoDaVelha.playO(posicao);
            } else {
                jogoDaVelha.playX(posicao);
            }
            tabuleiroView.atualizarPecas(jogoDaVelha.getTabuleiro());
            jogador1 = !jogador1;
        }

        if(jogoDaVelha.isGameOver()){
            StringBuilder msg = new StringBuilder("GAME OVER!!!\n");
            if(jogoDaVelha.isJogador1Ganhou()) {
                msg.append(" VENCEDOR : JOGADOR 1\n");
            } else if(jogoDaVelha.isJogador2Ganhou()) {
                msg.append(" VENCEDOR : JOGADOR 2\n");
            } else {
                msg.append(" DEU VELHA!!!\n");
            }
            gameOverAlert(this, msg.toString());
        }
    }

    public void gameOverAlert(Context context, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(mensagem);
        builder.setMessage("Deseja jogar novamente?");

        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iniciarJogo();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NÂO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.exit(0);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}