import componentes.CD;
import componentes.CDTeca;
import componentes.Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

      /*  // Teste do construtor básico
        System.out.println("=== Teste de criação de CD ===");
        CD cd1 = new CD("Nevermind", "Nirvana", 3558);

        // Teste do método toString e mostra
        System.out.println("\n=== Teste do método toString e mostra ===");
        System.out.println("toString: " + cd1.toString());
        System.out.print("mostra: ");
        cd1.mostra();

        // Teste de escrita em arquivo
        System.out.println("\n=== Teste de escrita em arquivo ===");
        try {
            FileWriter fw = new FileWriter("teste_cd.txt");
            cd1.escrever(fw);

            // Criar e escrever outro CD para testar múltiplas entradas
            CD cd2 = new CD("The Dark Side of the Moon", "Pink Floyd", 2585);
            cd2.escrever(fw);

            fw.close(); // Importante fechar o arquivo após a escrita
            System.out.println("CDs salvos com sucesso no arquivo 'teste_cd.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // Teste de leitura do arquivo
        System.out.println("\n=== Teste de leitura do arquivo ===");
        try {
            Scanner scanner = new Scanner(new File("teste_cd.txt"));

            CD cdLido1 = new CD(scanner);
            System.out.println("CD lido 1: ");
            cdLido1.mostra();

            CD cdLido2 = new CD(scanner);
            System.out.println("CD lido 2: ");
            cdLido2.mostra();

            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Opcional: Teste do método de leitura do teclado
        System.out.println("\n=== Teste de leitura do teclado ===");
        System.out.println("Deseja testar a leitura pelo teclado? (S/N)");
        Scanner scan = new Scanner(System.in);
        String resposta = scan.nextLine().trim().toUpperCase();

        if (resposta.equals("S")) {
            System.out.println("Informe os dados do CD:");
            CD cdTeclado = CD.leDoTeclado();
            System.out.println("\nCD criado a partir do teclado:");
            cdTeclado.mostra();


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
        }

        // Verificar se o CD foi salvo (opcional)
        System.out.println("\n=== Verificando conteúdo atual do arquivo ===");
        try {
            Scanner fileScanner = new Scanner(new File("teste_cd.txt"));
            int contador = 1;

            while (fileScanner.hasNextLine()) {
                try {
                    CD cdLido = new CD(fileScanner);
                    System.out.println("CD #" + contador + ": ");
                    cdLido.mostra();
                    contador++;
                } catch (IOException e) {
                    System.out.println("Erro ao ler CD: " + e.getMessage());
                    break;
                }
            }

            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir arquivo para verificação: " + e.getMessage());
        }

        scan.close();
        System.out.println("\n=== Testes concluídos ===");

*/

        CDTeca cdteca = new CDTeca("cdteca.txt");
        Menu menu = new Menu();
        menu.mostrar();
        int opt = menu.escolhaOpcao();
        cdteca.executar(opt);
        cdteca.grava("cdteca.txt");
        System.out.println("Itens após a escolha:");
        cdteca.listar(); // método usado para listar o conteúdo atual
    }
}