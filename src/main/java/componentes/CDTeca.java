package componentes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CDTeca {
    static CD[] meus_cd = new CD[100];
    static int numero_de_cds = contarCDsNoFicheiro(false);


    public static void executar(int opcao) {
        Scanner dados= new Scanner(System.in);
        String titulo = "";
        String artista = "";
        int duracao = 0;
        int indice;

        switch(opcao) {
            case 1:  //inserir CD

                System.out.println("Informe os dados do CD:");
                System.out.println("Insira o título: ");
                titulo = dados.nextLine().trim();
                System.out.println("Insira o nome do artista: ");
                artista = dados.nextLine().trim();
                System.out.println("Insira a duracao do album em segundos: ");
                duracao = dados.nextInt();
                indice = numero_de_cds;
                CD cdTeclado = new CD(indice, titulo, artista, duracao);
                System.out.println("\nCD criado a partir do teclado: " + cdTeclado);
                cdTeclado.mostra(); //mostra o que foi inserido

                // Salvar o CD introduzido pelo teclado no arquivo
                try {
                    // Abrimos em modo append (true) para não sobrescrever os CDs anteriores
                    FileWriter fw = new FileWriter("teste_cd.txt", true);
                    cdTeclado.escrever(fw);
                    fw.close();
                    System.out.println("CD do teclado salvo com sucesso no arquivo 'teste_cd.txt'");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar CD do teclado: " + e.getMessage());
                }
                meus_cd[numero_de_cds] = cdTeclado;
                numero_de_cds++;

                break;

            case 2:  //remover CD
                System.out.println("Qual o título do CD a remover?");
                String tituloProcurado = dados.nextLine().trim();

                procurado(tituloProcurado, opcao);
                break;

            case 3:  //Listar todos os cds do ficheiro
                contarCDsNoFicheiro(true);
                System.out.println("\n=====================\n");
                for (CD CDs: meus_cd){
                    if (CDs != null) {
                        CDs.mostra();
                    }
                }
                break;

            case 4:  // listar todos os cds do mesmo autor
                System.out.println("Qual o nome do autor?");
                String nomeAutor = dados.nextLine().trim();
                procurado(nomeAutor, opcao);
                break;

            case 5:  //Limpar todos os cds do ficheiro
                limparFicheiro();
                break;

        }
    }

    public static void procurado(String Procurado, int opcao){
        ArrayList<CD> cds = new ArrayList<>();
        boolean removido = false;
        try (Scanner sc = new Scanner(new File("teste_cd.txt"))) {
            while (sc.hasNextLine()) {


                // Lê a linha do índice e converte para inteiro
                String lineIndice = sc.nextLine().trim();
                int indice = Integer.parseInt(lineIndice);

                // Lê as próximas 3 linhas (título, artista e duração)
                String titulo = sc.hasNextLine() ? sc.nextLine().trim() : "";
                String artista = sc.hasNextLine() ? sc.nextLine().trim() : "";
                String duracao = sc.hasNextLine() ? sc.nextLine() : "";
                int duracaoInt = Integer.parseInt(duracao);

                if (!removido && titulo.equalsIgnoreCase(Procurado) && opcao == 2) {
                    System.out.println("Apagando CD com indice: " + indice);
                    removido = true;
                } else {
                    cds.add(new CD(indice, titulo, artista, duracaoInt));

                }
                if (artista.equalsIgnoreCase(Procurado) && opcao == 4) {
                    System.out.println("Indice: " + indice);
                    System.out.println("titulo: " + titulo);
                    System.out.println("Artista: " + artista);
                    System.out.println("duracao: " + duracao);
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }

        if (opcao == 2) {
            // Regrava o ficheiro com os registros restantes
            try (FileWriter fw = new FileWriter("teste_cd.txt", false)) {
                int novoIndice = 1;
                for (CD cd : cds) {
                    fw.write(novoIndice++ + "\n");
                    fw.write(cd.getTitulo() + "\n");
                    fw.write(cd.getArtista() + "\n");
                    fw.write(cd.getDuracao() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o ficheiro: " + e.getMessage());
            }
        }
    }

    public static void limparFicheiro() {
        File ficheiro = new File("teste_cd.txt");
        try (FileWriter fw = new FileWriter(ficheiro, false)) {
            // Escreve uma string vazia para limpar o ficheiro
            fw.write("");
            System.out.println("Ficheiro limpo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar ficheiro: " + e.getMessage());
        }
    }


    public static int contarCDsNoFicheiro(boolean imprimir) {
        int contador = 0;
        File ficheiro = new File("teste_cd.txt");
        try (Scanner sc = new Scanner(ficheiro)) {
            while (sc.hasNextLine()) {

                // Lê a linha do índice e converte para inteiro
                String lineIndice = sc.nextLine().trim();
                int indice = Integer.parseInt(lineIndice);

                // Lê as próximas 3 linhas (título, artista e duração)
                String titulo = sc.hasNextLine() ? sc.nextLine().trim() : "";
                String artista = sc.hasNextLine() ? sc.nextLine().trim() : "";
                String duracao = sc.hasNextLine() ? sc.nextLine().trim() : "";

                if(imprimir)

                    System.out.println(indice + ": " + titulo + " - " + artista + " (" + duracao + ")");

                contador++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
        return contador;
    }

}
