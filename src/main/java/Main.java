import componentes.CDTeca;
import componentes.Menu;


public class Main {
    public static void main(String[] args) {

        int opcao = 0;

        do{
           Menu menu = new Menu();
           menu.mostrar(Menu.Opts);
           opcao = menu.escolhaMenu();
           CDTeca.executar(opcao);
        }while (opcao > 0 && opcao < 6);

        System.out.println("Fim do programa");
    }
}