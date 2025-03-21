package componentes;

import java.io.FileWriter;
import java.io.IOException;

public class CD {
    private int indice;
    private String titulo;
    private String artista;
    private int duracao;

    public CD(int indice, String titulo, String artista, int duracao) {
        this.indice = indice +1;
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return indice + ": " + titulo + " - " + artista + " (" + duracao + "s)";
    }

    public void mostra(){
        System.out.println(toString());
    }

    public void escrever(FileWriter f) throws IOException {
        assert f != null;
        try {
            f.write(indice + "\n");
            f.write(titulo + "\n");
            f.write(artista + "\n");
            f.write(duracao + "\n");
            f.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever: " + e.getMessage());
            throw e;
        }
        // Não fechar o FileWriter aqui para permitir que mais CDs sejam escritos
    }

    public int getDuracao() {
        return duracao;
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }
}
