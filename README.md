# CRUD de Jogos em Java

Aplicação de console desenvolvida em Java para praticar operações CRUD e persistência de dados em arquivo.

## Funcionalidades

- Cadastrar um jogo com nome e preço.
- Listar os jogos cadastrados.
- Atualizar nome e preço de um jogo.
- Remover um jogo.
- Salvar e carregar os dados por serialização em arquivo local.

## Tecnologias

- Java
- Java Collections (`List` e `ArrayList`)
- `Scanner` para entrada pelo terminal
- `ObjectInputStream` e `ObjectOutputStream` para persistência

## Estrutura

```text
CRUD/
└── src/
    └── Lgames.java
```

## Como executar

Com um JDK instalado:

```bash
cd CRUD
javac -d out src/Lgames.java
java -cp out Lgames
```

O programa cria o arquivo `jogos.txt` durante o uso para armazenar os dados localmente. Esse arquivo é ignorado pelo Git.

## Contexto

Projeto acadêmico voltado à prática de CRUD, manipulação de coleções e persistência de dados em Java.
