@echo off
REM ========================================
REM Por que existe esse arquivo .bat?
REM - Temos 5 projetos Java diferentes (Biblioteca, Frutaria, Filmes, Cursos, Suplementos)
REM - Cada projeto precisa ser compilado individualmente com comandos específicos
REM - Sem este .bat, seria necessário digitar pelo menos 25 linhas de comando manualmente
REM - Este script automatiza todo o processo, evitando erros e economizando tempo
REM ========================================

echo ========================================
echo    Compilando Projetos Java
echo ========================================
echo.

echo Compilando App Biblioteca...
javac -cp src src/br/com/appBiblioteca/AppBiblioteca.java src/br/com/appBiblioteca/model/Livro.java src/br/com/appBiblioteca/service/Estoque.java src/br/com/appBiblioteca/view/Interface.java src/br/com/appBiblioteca/view/Editar.java src/br/com/appBiblioteca/view/Relatorio.java
if %errorlevel% equ 0 (
    echo [OK] App Biblioteca compilado com sucesso!
) else (
    echo [ERRO] Falha na compilação do App Biblioteca
)

echo.
echo Compilando App Frutaria...
javac -cp src src/br/com/appFrutaria/AppFrutaria.java src/br/com/appFrutaria/model/Fruta.java src/br/com/appFrutaria/service/Estoque.java src/br/com/appFrutaria/view/Interface.java src/br/com/appFrutaria/view/Editar.java
if %errorlevel% equ 0 (
    echo [OK] App Frutaria compilado com sucesso!
) else (
    echo [ERRO] Falha na compilação do App Frutaria
)

echo.
echo Compilando App Filmes...
javac -cp src src/br/com/appFilmes/AppFilmes.java src/br/com/appFilmes/model/Filme.java src/br/com/appFilmes/service/Estoque.java src/br/com/appFilmes/view/Interface.java src/br/com/appFilmes/view/Editar.java src/br/com/appFilmes/view/Relatorio.java
if %errorlevel% equ 0 (
    echo [OK] App Filmes compilado com sucesso!
) else (
    echo [ERRO] Falha na compilação do App Filmes
)

echo.
echo Compilando App Cursos...
javac -cp src src/br/com/appCursos/AppCursos.java src/br/com/appCursos/model/Curso.java src/br/com/appCursos/service/Estoque.java src/br/com/appCursos/view/Interface.java src/br/com/appCursos/view/Editar.java src/br/com/appCursos/view/Relatorio.java
if %errorlevel% equ 0 (
    echo [OK] App Cursos compilado com sucesso!
) else (
    echo [ERRO] Falha na compilação do App Cursos
)

echo.
echo Compilando App Suplementos...
javac -cp src src/br/com/appSuplementos/AppSuplementos.java src/br/com/appSuplementos/model/Suplemento.java src/br/com/appSuplementos/service/Estoque.java src/br/com/appSuplementos/view/Interface.java src/br/com/appSuplementos/view/Editar.java src/br/com/appSuplementos/view/Relatorio.java
if %errorlevel% equ 0 (
    echo [OK] App Suplementos compilado com sucesso!
) else (
    echo [ERRO] Falha na compilação do App Suplementos
)

echo.
echo ========================================
echo    Compilação Concluída!
echo ========================================
echo.
echo Para executar os programas, use:
echo.
echo Biblioteca:    java -cp src br.com.appBiblioteca.AppBiblioteca
echo Frutaria:      java -cp src br.com.appFrutaria.AppFrutaria
echo Filmes:        java -cp src br.com.appFilmes.AppFilmes
echo Cursos:        java -cp src br.com.appCursos.AppCursos
echo Suplementos:   java -cp src br.com.appSuplementos.AppSuplementos
echo.
pause 