package componentes;

import java.util.Scanner;

public class Menu {
    public static String[] Opts;


    public Menu() {

        System.out.println("\n=== Menu ===");

        Opts = new String[6];
        Opts[0]="Inserir novo CD na colecção (se já houver esse CD na colecção não faz nada)";
        Opts[1]="Remover CD da colecção (se não existir não faz nada)";
        Opts[2]="Listar todos os CD da colecção";
        Opts[3]="Listar todos os CD de um autor (se não existir nenhum não faz nada)";
        Opts[4]="Limpar ficheiro (Essa ação apagará todos os dados do ficheiro)";
        Opts[5]="Sair";

    }

    public static void mostrar(String[] Opts) {
        for (int i = 0; i < Opts.length; i++) {
            System.out.println(i+1 + " - " + Opts[i]);
        }
    }

    public static int escolhaMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQual é a sua escolha? ");
        return sc.nextInt();
    }
}
