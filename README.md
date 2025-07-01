# 📚 Projetos de Técnicas de Programação

Este repositório reúne cinco sistemas Java independentes, cada um simulando um domínio diferente (Biblioteca, Frutaria, Filmes, Cursos e Suplementos), todos organizados em uma estrutura modular e padronizada.

## 🏗️ Estrutura do Projeto

```
Projetos-TecnicasDeProgramacao/
├── compilar.bat
├── README.md
└── src/
    └── br/
        └── com/
            ├── appBiblioteca/
            ├── appFrutaria/
            ├── appFilmes/
            ├── appCursos/
            └── appSuplementos/
```

Cada subpasta representa um sistema independente, com sua própria estrutura MVC (Model-View-Controller/Service).

## 📦 Estrutura de Cada Aplicação

```
app[Nome]/
├── App[Nome].java           # Classe principal (main)
├── model/
│   └── [Entidades].java     # Classes de domínio (ex: Livro, Produto, Fruta, etc)
│   └── verduras/            # (Frutaria) Subpacote para tipos de verduras
├── service/
│   ├── Estoque.java         # Lógica de estoque e menu principal
│   └── CarrinhoCompras.java # Lógica de compras
└── view/
    ├── Interface.java       # Interface de interação principal
    ├── InterfaceCompra.java # Interface de interação do carrinho
    ├── Editar.java          # Métodos de edição de entidades
    ├── Menus.java           # Menus auxiliares
    └── Relatorio.java       # Relatórios do sistema
```

## 🎯 Aplicações Disponíveis

### 📚 App Biblioteca
- **Entidade principal:** `Livro`
- **Atributos:** nome, autor, gênero, editora, páginas, quantidade, preço
- **Funcionalidades:** Cadastro, visualização, remoção, edição, compras, relatório detalhado

### 🍎 App Frutaria
- **Entidades:** `Produto` (base), `Fruta`, `Verdura` (com enum `TipoVerdura`)
- **Atributos:** nome, preço, quantidade, peso (fruta), tipo (verdura)
- **Funcionalidades:** Cadastro, visualização, remoção, edição, compras, relatório detalhado

### 🎬 App Filmes
- **Entidade principal:** `Filme`
- **Atributos:** título, gênero, duração, ano de lançamento, diretor, quantidade, preço
- **Funcionalidades:** Cadastro, visualização, remoção, edição, compras, relatório detalhado

### 🎓 App Cursos
- **Entidade principal:** `Curso`
- **Atributos:** nome, duração (horas), coordenador, nível, vagas, preço
- **Funcionalidades:** Cadastro, visualização, remoção, edição, compras, relatório detalhado

### 💊 App Suplementos
- **Entidade principal:** `Suplemento`
- **Atributos:** nome, preço, quantidade, marca
- **Funcionalidades:** Cadastro, visualização, remoção, edição, compras, relatório detalhado

## 🚀 Como Compilar e Executar

### Compilação automática (recomendada)

Use o script incluso para compilar todos os sistemas de uma vez:

```bat
compilar.bat
```

Após a compilação, execute o sistema desejado:

```bat
java -cp src br.com.appBiblioteca.AppBiblioteca
java -cp src br.com.appFrutaria.AppFrutaria
java -cp src br.com.appFilmes.AppFilmes
java -cp src br.com.appCursos.AppCursos
java -cp src br.com.appSuplementos.AppSuplementos
```

### Compilação manual (exemplo para Biblioteca)

```bat
javac -cp src src/br/com/appBiblioteca/AppBiblioteca.java src/br/com/appBiblioteca/model/Livro.java src/br/com/appBiblioteca/service/Estoque.java src/br/com/appBiblioteca/service/CarrinhoCompras.java src/br/com/appBiblioteca/view/Interface.java src/br/com/appBiblioteca/view/Editar.java src/br/com/appBiblioteca/view/Relatorio.java
java -cp src br.com.appBiblioteca.AppBiblioteca
```

## 📝 Funcionalidades Gerais

- **Menu interativo:** Todas as aplicações possuem menus de fácil navegação pelo console.
- **Relatórios:** Todos os sistemas (exceto Frutaria) possuem opção de relatório no menu principal.
- **Carrinho de compras:** Simulação de compra/remoção de itens.
- **Edição e remoção:** Edição e remoção de entidades com validação.
- **Relatórios detalhados:** Estatísticas e ordenação dos itens por quantidade/vagas.

## 🎨 Padrões e Técnicas

- **MVC:** Separação entre dados, lógica e interface.
- **POO:** Encapsulamento, herança (ex: Produto, Fruta, Verdura), polimorfismo.
- **Coleções:** Uso de ArrayList para gerenciamento dinâmico.
- **Métodos estáticos:** Controle de totais globais por entidade.

## 💡 Observações

- **Requisitos:** Java 8 ou superior.
- **Persistência:** Todos os dados são mantidos apenas em memória (não há banco de dados).
- **Execução:** Apenas via terminal/console.
- **Estrutura modular:** Cada sistema é independente, mas compartilha padrões e estrutura.