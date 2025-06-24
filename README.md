# 📚 Projetos de Técnicas de Programação

Este repositório contém uma coleção de projetos Java que demonstram diferentes técnicas de programação, todos organizados em uma estrutura compartilhada.

## 🏗️ Estrutura do Projeto

```
Projetos-TecnicasDeProgramacao/
├── src/
│   └── br/
│       └── com/
│           ├── appBiblioteca/     # Sistema de Biblioteca
│           ├── appFrutaria/       # Sistema de Frutaria
│           ├── appFilmes/         # Sistema de Filmes
│           ├── appCursos/         # Sistema de Cursos
│           └── appSuplementos/    # Sistema de Suplementos
├── ProjetoBiblioteca/             # Projeto original (mantido para referência)
├── ProjetoFrutaria/               # Projeto original
├── ProjetoFilmes/                 # Projeto original
├── ProjetoCursos/                 # Projeto original
├── ProjetoSuplementos/            # Projeto original
└── README.md
```

## 📦 Estrutura de Cada Aplicação

Cada aplicação segue o padrão MVC (Model-View-Controller) com a seguinte estrutura:

```
app[Nome]/
├── [AppNome].java          # Classe principal
├── model/
│   └── [Entidade].java     # Classe de modelo
├── service/
│   └── Estoque.java        # Lógica de negócio
└── view/
    ├── Interface.java       # Interface do usuário
    └── Editar.java         # Métodos de edição
```

## 🎯 Aplicações Disponíveis

### 📚 App Biblioteca
- **Entidade**: `Livro`
- **Atributos**: nome, autor, gênero, editora, páginas, quantidade
- **Funcionalidades**: Cadastrar, visualizar, remover e editar livros

### 🍎 App Frutaria
- **Entidade**: `Fruta`
- **Atributos**: nome, preco, quantidade
- **Funcionalidades**: Cadastrar, visualizar, remover e editar frutas

### 🎬 App Filmes
- **Entidade**: `Filme`
- **Atributos**: título, gênero, duração, ano de lançamento, quantidade
- **Funcionalidades**: Cadastrar, visualizar, remover e editar filmes

### 🎓 App Cursos
- **Entidade**: `Curso`
- **Atributos**: nome, duração (horas), coordenador, nível, vagas
- **Funcionalidades**: Cadastrar, visualizar, remover e editar cursos

### 💊 App Suplementos
- **Entidade**: `Suplemento`
- **Atributos**: nome, preço, quantidade, marca
- **Funcionalidades**: Cadastrar, visualizar, remover e editar suplementos

## 🚀 Como Executar

### Compilação Individual
Para compilar e executar cada aplicação individualmente:

```bash
# Biblioteca
javac -cp src src/br/com/appBiblioteca/*.java src/br/com/appBiblioteca/*/*.java
java -cp src br.com.appBiblioteca.AppBiblioteca

# Frutaria
javac -cp src src/br/com/appFrutaria/*.java src/br/com/appFrutaria/*/*.java
java -cp src br.com.appFrutaria.AppFrutaria

# Filmes
javac -cp src src/br/com/appFilmes/*.java src/br/com/appFilmes/*/*.java
java -cp src br.com.appFilmes.AppFilmes

# Cursos
javac -cp src src/br/com/appCursos/*.java src/br/com/appCursos/*/*.java
java -cp src br.com.appCursos.AppCursos

# Suplementos
javac -cp src src/br/com/appSuplementos/*.java src/br/com/appSuplementos/*/*.java
java -cp src br.com.appSuplementos.AppSuplementos
```

### Compilação Completa
Para compilar todos os projetos de uma vez:

```bash
javac -cp src src/br/com/*/*.java src/br/com/*/*/*.java
```

## 🎨 Características dos Projetos

### Padrões Utilizados
- **MVC (Model-View-Controller)**: Separação clara entre dados, lógica e interface
- **POO (Programação Orientada a Objetos)**: Encapsulamento, herança e polimorfismo
- **Collections**: Uso de ArrayList para gerenciamento de dados
- **Static Methods**: Controle de contadores globais

### Funcionalidades Comuns
- ✅ Cadastro de entidades
- ✅ Visualização detalhada
- ✅ Remoção com confirmação
- ✅ Edição de atributos
- ✅ Controle de estoque/quantidade
- ✅ Interface de console interativa
- ✅ Validação de entrada de dados

### Funcionalidades Específicas
- **Biblioteca**: Controle de páginas e editoras
- **Frutaria**: Controle de cores e sabores
- **Filmes**: Controle de duração e ano de lançamento
- **Cursos**: Controle de vagas e coordenadores
- **Suplementos**: Controle de preços e marcas

## 📝 Notas Técnicas

- **Linguagem**: Java
- **Versão**: Compatível com Java 8+
- **Estrutura**: Pacotes organizados por domínio
- **Interface**: Console interativo
- **Persistência**: Memória (ArrayList)