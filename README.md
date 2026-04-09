# Atividade Pilha e Fila em Java

**Aluno:** Thiago Saggiorato Longo  
**Disciplina:** Estruturas de Dados  
**Tema:** Implementação manual de pilha e fila usando arrays

## Descrição do projeto

Este projeto foi desenvolvido em Java para demonstrar, na prática, o funcionamento das estruturas de dados **pilha** e **fila** sem utilizar classes prontas da linguagem, como `Stack`, `Queue`, `ArrayList` ou `LinkedList`.

O sistema funciona totalmente pelo terminal e possui um menu interativo para testar cada estrutura separadamente. Além das operações obrigatórias da atividade, o projeto também inclui melhorias extras para deixar a demonstração mais completa e visualmente mais forte.

## Conceitos resumidos

### Pilha

A pilha segue a regra **LIFO** (*Last In, First Out*), ou seja, o último elemento que entra é o primeiro que sai.  
No projeto, ela foi implementada com um array e uma variável de controle chamada `topo`, que aponta para a última posição ocupada.

### Fila

A fila segue a regra **FIFO** (*First In, First Out*), ou seja, o primeiro elemento que entra é o primeiro que sai.  
No projeto, ela foi implementada com um array circular e variáveis de controle chamadas `inicio`, `fim` e `quantidade`.

## Funcionalidades implementadas

### Pilha

- `push()` para empilhar um elemento
- `pop()` para desempilhar um elemento
- `peek()` para visualizar o topo
- `isEmpty()` para verificar se a pilha está vazia
- `isFull()` para verificar se a pilha está cheia
- `display()` para exibir todos os elementos
- limpeza completa da pilha
- exibição da quantidade atual de elementos

### Fila

- `enqueue()` para inserir um elemento
- `dequeue()` para remover um elemento
- `front()` para visualizar o primeiro elemento
- `isEmpty()` para verificar se a fila está vazia
- `isFull()` para verificar se a fila está cheia
- `display()` para exibir todos os elementos
- limpeza completa da fila
- exibição da quantidade atual de elementos
- implementação em **fila circular**

### Extras para destacar o projeto

- escolha da capacidade da pilha e da fila no início do programa
- interface diferenciada no terminal com molduras, painel visual e destaque dos estados
- visualização da memória interna do array para ajudar na explicação do vídeo
- comentários nos métodos principais para facilitar a apresentação
- validação de entradas digitadas pelo usuário

## Estrutura do projeto

```text
Trabalho-Pilha-Fila/
|-- src/
|   |-- Main.java
|   |-- PilhaArray.java
|   |-- FilaArray.java
|-- README.md
```

## Como compilar e executar

### Requisitos

- Java JDK 11 ou superior

### Compilação

No terminal, dentro da pasta do projeto, execute:

```powershell
javac -encoding UTF-8 -d out src\*.java
```

### Execução

Depois de compilar, execute:

```powershell
java -cp out Main
```

Se o seu terminal do Windows não exibir acentos corretamente, execute antes:

```powershell
chcp 65001
```

## Link do vídeo

Adicione aqui o link do vídeo no YouTube após a gravação:  
`Cole aqui o link do vídeo`

## Sugestão para a apresentação

Durante o vídeo, você pode explicar:

- o que é uma pilha e por que ela usa LIFO
- o que é uma fila e por que ela usa FIFO
- como o array foi usado nas duas estruturas
- como funcionam as variáveis `topo`, `inicio`, `fim` e `quantidade`
- como o menu interativo ajuda a visualizar as operações
- a diferença entre o estado lógico da estrutura e a memória interna exibida na tela
