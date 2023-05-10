# Jogo da Velha App
Aplicativo Android do Clássico Jogo da Velha  

## Sobre o Jogo
O jogo foi implementado como exercício para o Colégio Leonardo da Vinci (Asa Sul).

Ele é um aplicativo para dispositivos Android, feito na linguagem Java, utilizando como ferramenta o Android Studio.

Ele possui 3 classes principais : JogoDaVelha, TabuleiroView e MainActivity

### Classe JogoDaVelha.java

A classe JogoDavelha contém todas as regras dos jogo e mantém uma representação interna do tabuleiro. Possui regras para identificar se as jogadas são válidas, se o jogo terminou com algum jogador ganhando ou se terminou em "velha".

### Classe TabuleiroView

Representa o tabuleiro que é exibido durante o jogo. Exibe as peças no tabuleiro e repassa os eventos para a classe MainActivity.

### Classe MainActivty

É a classe que inicia o aplicativa. Trata os eventos da tela (da classe TabuleiroView) e repassa para a classse JogoDaVelha.

## Posíveis Melhorias

1. Melhorar a interface gráfica
2. Possibilitar jogar contra o "computador"
3. Permitir jogar contra outro jogador online (em rede)
