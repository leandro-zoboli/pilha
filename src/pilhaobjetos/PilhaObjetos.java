package pilhaobjetos;

import java.util.Scanner;

class Livro {

    int id;
    String nome;
    Livro proximo;
}

public class PilhaObjetos {

    static Livro topen = null;

    public static int pedeInt(String msg, int min, int max) {
        int ret = min - 1;
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.nextInt();
                if (ret < min || ret > max) {
                    menu();
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret < min || ret > max || erro);
        return ret;
    }

    public static String pedeString(String msg, int min, int max) {
        String ret = "";
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.next();
                if (ret.length() < min || ret.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret.length() < min || ret.length() > max || erro);
        return ret;
    }

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int resp = 0;
        do {
            System.out.println("---------------------------");
            System.out.println("1- Empilhar um livro");
            System.out.println("2- Desempilhar o livro do topo");
            System.out.println("3- Mostrar pilha");
            resp = pedeInt("Informe a opção desejada", 1, 3);
            switch (resp) {
                case 1:
                    empilhaLivro();
                    break;
                case 2:
                    desempilhaLivro();
                    break;
                case 3:
                    mostraPilha();
                    break;
            }
        } while (resp < 1 && resp > 3);
    }

    private static void empilhaLivro() {
        Livro novo = new Livro();
        novo.id = pedeInt("Informe o codigo do livro", 1, 100);
        novo.nome = pedeString("Informe o nome do livro", 1, 100);
        if (topen == null) {
            topen = novo;
            novo.proximo = null;
        } else {
            novo.proximo = topen;
            topen = novo;
        }
        menu();
    }

    private static void desempilhaLivro() {
        if (topen == null) {
            System.out.println("Não existe nenhum livro empilhado!");
        } else {
            System.out.println(topen.nome + " excluído da pilha");
            topen = topen.proximo;
            menu();
        }
    }

    private static void mostraPilha() {
        if (topen == null) {
            System.out.println("Não existe nenhum livro empilhado!");
        } else {
            Livro atual = new Livro();
            atual = topen;
            while (atual != null) {
                System.out.println(atual.id + " - " + atual.nome);
                atual = atual.proximo;
            }
        }
        menu();
    }

}
