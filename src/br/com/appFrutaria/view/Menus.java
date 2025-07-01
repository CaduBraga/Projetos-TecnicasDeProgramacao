package br.com.appFrutaria.view;

import java.util.Scanner;

public class Menus {
    static Scanner input = new Scanner(System.in);

    public static int menuPrincipal() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    🍎 SISTEMA FRUTARIA 🥬                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  O que você deseja fazer?                                   ║");
        System.out.println("║                                                              ║");
        System.out.println("║  1 ➤ Inserir produto                                       ║");
        System.out.println("║  2 ➤ Ver produtos                                          ║");
        System.out.println("║  3 ➤ Remover produto                                       ║");
        System.out.println("║  4 ➤ Editar produto                                        ║");
        System.out.println("║  5 ➤ Solicitar relatório da frutaria                       ║");
        System.out.println("║  6 ➤ Iniciar compras                                       ║");
        System.out.println("║  7 ➤ Sair do programa                                      ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("  Digite sua escolha: ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();
        return escolha;
    }

    public static int menuTipoProduto() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    📝 CADASTRO DE PRODUTO                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Qual tipo de produto?                                      ║");
        System.out.println("║                                                              ║");
        System.out.println("║  1 ➤ 🍎 Fruta                                              ║");
        System.out.println("║  2 ➤ 🥬 Verdura                                            ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("  Digite sua escolha: ");
        int tipo = input.nextInt();
        input.nextLine();
        System.out.println();
        return tipo;
    }
} 