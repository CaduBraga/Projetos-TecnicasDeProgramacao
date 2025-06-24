package br.com.appCursos;

import br.com.appCursos.view.Interface;
import br.com.appCursos.service.Estoque;

public class AppCursos {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueCurso = new Estoque();

        estoqueCurso.gerenciarEstoque();
    }
} 