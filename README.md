# Object-Oriented-Programming
Repository containing all my projects of the discipline using Java.

## Jogo de Bozó 

  O Bozó é um jogo de dados em que cada jogador tenta preencher 10 posições de um tabuleiro com o maior número de pontos possvel.
  
## Regras 

  Em cada rodada, o jogador lança os 5 dados. Depois, pode escolher ficar com a pontuação que tirou ou escolher entre 1 e 5 dados para lançar novamente. Em seguida pode, se quiser, escolher mais uma vez alguns dos dados para lançar de novo.
  
  Ao final, deve escolher qual a posição do tabuleiro irá preencher. Uma posição já preenchida em rodada anterior, não pode ser utilizada de novo. A pontuação obtida depende da posição escolhida e da configuração final dos dados. 
  
  Nas posições externas devem ser colocadas as somas dos dados que apreesentam os números correspondentes à posição escolhida. Por exemplo, se o jogador seleciona a posição “# 3” e nos dados consguiu tirar 4 dados com a pontuação 3, então o valor a ser colocado é 12 (3*4).
  
  Nas posições internas, o jogador recebe uma pontuação fixa, se conseguir determina configuração dos dados e zero se os dados não apresentarem tal configuração. A primeira posição é um __full hand__ ou seja, três dados de determinado número e dois de outro (ou do mesmo) e vale 15 pontos. A segunda é uma __sequência__, ou seja, os dados têm todos os números de 1 a 5 ou de 2 a 6, valendo 20 pontos. A terceira é a posição da __quadra__ (30 pontos) e a última da __quina__, que vale 40 pontos.
  
  
  
