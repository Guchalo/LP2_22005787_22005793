## O Grande Jogo do DEISI

### Parte final

Na etapa final do projeto foi adicionada uma função para guardar o jogo, para carregar um jogo guardado anteriormente
e uma consola que permite ao jogador ver e alterar vários elementos do jogo. 

### Como funciona o jogo:
Na primeira parte os programadores já vão estar definidos, sendo constituídos por um id, nome, as suas
linguagens de programação favoritas e uma cor(Purple, Blue, Green, Brown).

Na segunda parte, introduzimos abismos e ferramentas. Os abismos consistem em certas casas do tabuleiro que têm um
certo tipo de comportamento, como recuar casas, ficar preso na casa, etc. As ferramentas consistem em certas casas
que ajudam os jogadores a evitar esses mesmos abismos.

Na terceira parte foi introduzida uma consola de controlo para o jogo. 

O jogo permite de 2 até 4 jogadores.

Por enquanto os programadores andam conforme o número de casas que sair no dado, por exemplo, se sair o número 6,
o programador que está a jogar anda 6 casas. Caso o programador ultrapasse a casa final do jogo, ele vai
recuar o número de casas em excesso.

Este jogo ainda conta com um método para reiniciar o tabuleiro, um método para mostrar uma janela com os créditos,
um método para para guardar o jogo e um método para para carregar um jogo guardado.

### Modelação:
Criamos uma classe Turn para gerir os turnos, uma classe HelpfullFunctions que tem funções que ajudam na execução do programa, uma classe BoardApps, em que
essa classe vai ser o Pai das classes Abyss e Tools.
Tanto a classe Abyss como a classe Tool têm um método que vai retornar uma mensagem e ao mesmo tempo executar a sua reação.
Decidimos modelar as classes do programa desta forma, para ser mais fácil agrupar os abismos e as ferramentas.

### Tema:
Decidimos fazer o projeto baseado na animação japonesa Kimetsu No Yaiba(Demon Slayer).
O jogo contém um exemplo em que os nomes dos programadores correspondem aos nomes dos personagens da série

### Link do vídeo:
https://youtu.be/od9J57DP7Tk


### Relação entre Abismos e Ferramentas:

![](tabela.png?raw=true "Tabela")

### Diagrama UML

![](diagrama.png?raw=true "Diagrama UML")

### Trabalho foi realizado por:

Gonçalo Nunes 22005787

Rafael Simões 22005793