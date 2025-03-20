package componentes;

import java.util.Scanner;

public class Menu {
   static String[] Opts = {};

    public Menu() {
        Opts = new String[5];
        Opts[0]="Inserir novo CD na colecção (se já houver esse CD na colecção não faz nada)";
        Opts[1]="Remover CD da colecção (se não existir não faz nada)";
        Opts[2]="Listar todos os CD da colecção";
        Opts[3]="Listar todos os CD de um autor (se não existir nenhum não faz nada)";
        Opts[4]="Sair";
    }

    public Menu(final String[] opcoes) {
        Opts = new String[opcoes.length];
        for (int i = 0; i < opcoes.length; i++) {
            Opts[i] = opcoes[i];
        }
    }

    public static void mostrar() {
        for (int i = 0; i < Opts.length; i++) {
            System.out.println(i+1 + " - " + Opts[i]);
        }

    }

    public static int escolhaOpcao() {
        int opt;
        Scanner dados = new Scanner(System.in);
        System.out.println("Indique o número da sua opção?");
        opt = dados.nextInt();
        return opt;
    }

}
