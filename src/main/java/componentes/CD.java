package componentes;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CD {
    private String titulo;
    private String artista;
    private int duracao;

    public CD(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    public static CD leDoTeclado(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o título: ");
        String titulo = teclado.nextLine().trim();
        if(titulo.equals(""))
            titulo = teclado.nextLine().trim();

        System.out.println("Insira o nome do artista: ");
        String artista = teclado.nextLine().trim();
        System.out.println("Insira a duracao do album em segundos: ");
        int duracao = teclado.nextInt();
        return new CD(titulo, artista, duracao);
    }

    public CD(Scanner f) throws IOException {
        //leitura das varáveis membro de um ficheiro, cada linha do ficehiro contém uma variável diferente

        try {
            titulo = f.nextLine();
            artista = f.nextLine();
            duracao = Integer.parseInt(f.nextLine());
        } catch (Exception e) {
            throw new IOException("Erro ao ler dados do CD: " + e.getMessage());
        }
    }

    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return titulo + ": " + artista + " (" + duracao + "s)";
    }

    public void mostra(){
        System.out.println(toString());
    }

    public void escrever(FileWriter f) throws IOException {
        assert f != null;
        try {
            f.write(titulo + "\n");
            f.write(artista + "\n");
            f.write(duracao + "\n");
            f.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever: " + e.getMessage());
            throw e;
        }
        // Não fecha o FileWriter aqui para permitir que mais CDs sejam escritos
    }
}
