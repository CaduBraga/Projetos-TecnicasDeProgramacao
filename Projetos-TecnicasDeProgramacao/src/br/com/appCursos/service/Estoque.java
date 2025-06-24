package br.com.appCursos.service;

import java.util.ArrayList;
import java.util.List;

import br.com.appCursos.model.Curso;
import br.com.appCursos.view.Interface;

public class Estoque {
    List<Curso> estoqueCurso;
    Interface tela;

    public Estoque() {
        estoqueCurso = new ArrayList<>();
        tela = new Interface();
    }

    public Estoque(List<Curso> estoqueCurso) {
        this.estoqueCurso = estoqueCurso;
    }

    public void setCurso(List<Curso> estoqueCurso) {
        this.estoqueCurso = estoqueCurso;
    }

    public List<Curso> getEstoqueCurso() {
        return estoqueCurso;
    }

    public void gerenciarEstoque() {
        int escolhaInicial = 0;
        while (escolhaInicial != 5) {
            escolhaInicial = tela.menuPrincipal();
            switch (escolhaInicial) {

                case 1:
                    Curso curso = tela.cadastrar();
                    estoqueCurso.add(curso);
                    break;

                case 2:
                    tela.detalhar(estoqueCurso);
                    break;

                case 3:
                    tela.remover(estoqueCurso);
                    break;

                case 4:
                    tela.editar(estoqueCurso);
                    break;

                case 5:
                    tela.encerrar();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }
        }
    }
} 