package componentes;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;



public class CDTeca {
    final static int MAX_CDS = 500;
    private CD[] meus_cd = null;
    private int numero_de_cd = 0;

    public CDTeca(String nome_do_ficheiro) throws IOException {
        assert nome_do_ficheiro != null;
        Scanner f;
        try {
            f = new Scanner(new File(nome_do_ficheiro));
        } catch (FileNotFoundException e) {
            return;
        }

        if (meus_cd == null){
            meus_cd = new CD[MAX_CDS];
        }

        if (f.hasNextInt()) {
            int n = f.nextInt(); //número de CD guardados
            numero_de_cd = n;
            f.nextLine();
            for (int i = 0; i < numero_de_cd; i++) {
                CD lido = new CD(f);
                meus_cd[i] = lido;
            }
        }
        f.close();
    }

    public void grava(String nome_do_ficheiro) {
        FileWriter f;
        try {
            f = new FileWriter(nome_do_ficheiro);

            // Escreve o total de CDs
            f.write(numero_de_cd+ "\n");

            for (int i=0; i<numero_de_cd; i++)
                meus_cd[i].escrever(f);
        } catch (IOException e) {
            System.out.println("Erro de escrita:" + e.getMessage());
            return;
        }
    }

    /* Ciclo principal de execução do programa */
    public void executar() {
        //As opções estão numeradas de 1 a 5 (ver classe Menu)
        String[] opcoes = {"Inserir", "Remover", "Mostrar", "Listar", "Listar Todos", "Sair"};
        Menu menu = new Menu(opcoes);
        final int SAIR = opcoes.length;
        int opcao = 0;
        do {
            //TODO: Clear console
            System.out.println("CDs na CDTeca " + numero_de_cd);
            Menu.mostrar();
            opcao = Menu.escolhaOpcao();
            if (opcao > 0 && opcao < SAIR)
                executar(opcao);
        } while (opcao != SAIR);
    }

    public void executar(int opcao) {
        switch(opcao) {
            case 1: {
                CD c = CD.leDoTeclado();
                int index = this.indiceDoCd(c.getTitulo());

                if (index == 1) {
                    c.mostra();
                    meus_cd[numero_de_cd] = c;
                    numero_de_cd++;
                }
                break;
            }

            case 2: {
                Scanner dados= new Scanner(System.in);
                System.out.println("Qual o título do CD a remover?");
                String tt=dados.nextLine();
                int index=this.indiceDoCd(tt);
                if (index !=1){
                    numero_de_cd--;

                    for (int i=index; i<numero_de_cd;i++)
                        meus_cd[i]=meus_cd[i+1];
                }
                break;
            }
            case 3: {
                this.listar();
                break;
            }

            case 4: {
                Scanner dados = new Scanner(System.in);
                System.out.println("Qual o título do CD a listar?");
                String tt = dados.nextLine();
                int index = this.indiceDoCd(tt);
                if (index != 1)
                    meus_cd[index].mostra();
                break;
            }

            case 5: {
                for (CD CDs: meus_cd){
                    if (CDs != null)
                        CDs.mostra();
                }
                break;
            }

            default: return;

        }
    }

    public void listar () {
        for(int i=0;i<numero_de_cd;i++)
            meus_cd[i].mostra();
    }

    public int indiceDoCd(String titulo) {
        for (int i=0; i<numero_de_cd;i++)
            if (meus_cd[i].getTitulo().compareTo(titulo)==0)
                return i;
        return 1;
    }

    public CD procurar(String titulo) {
        int i = indiceDoCd(titulo);
        if (i != -1) {
            assert i >= 0 && meus_cd != null &&
                    i < numero_de_cd && meus_cd[i] != null;
            return meus_cd[i];
        }
        return null;
    }
}
