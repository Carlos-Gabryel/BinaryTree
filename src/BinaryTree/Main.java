package BinaryTree;

import java.util.Scanner;

public class Main {
    private static TreeNode<Integer> raiz;
    private static Integer value;
    private static TreeNode<Integer> newNode;

    public static void main(String[] args) {
        BinaryTree<Integer> arvore = new BinaryTree();
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        int valor = 0;
        while (opcao != 12) {
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Percorrer em ordem");
            System.out.println("4 - Percorrer em nível");
            System.out.println("5 - Menor valor na arvore");
            System.out.println("6 - Maior valor na arvore");
            System.out.println("7 - Numero de nodes na arvore");
            System.out.println("8 - Numero de folhas na arvore");
            System.out.println("9 - Numero de nodes nao terminais na arvore");
            System.out.println("10 - Inserir nao recursivo");
            System.out.println("11 - Buscar nao recursivo");
            System.out.println("12 - Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido: ");
                    valor = input.nextInt();
                    arvore.insert(valor);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser buscado: ");
                    valor = input.nextInt();
                    System.out.println(arvore.find(valor));
                    break;
                case 3:
                    arvore.emOrdem();
                    break;
                case 4:
                    arvore.passeioPorNivel();
                    break;
                case 5:
                    System.out.println(arvore.menorValor());
                    break;
                case 6:
                    System.out.println(arvore.maiorValor());
                    break;
                case 7:
                    arvore.numeroNodes();
                    break;
                case 8:
                    arvore.numeroFolhas();
                    break;
                case 9:
                    System.out.println(arvore.numeroNodesNaoTerminais(raiz));
                    break;
                case 10:
                    System.out.println("Digite o valor a ser inserido: ");
                    valor = input.nextInt();
                    arvore.inserirNaoRecursivo(newNode);
                    break;
                case 11:
                    System.out.println("Digite o valor a ser buscado: ");
                    valor = input.nextInt();
                    System.out.println(arvore.buscarNaoRecursivo(valor));
                    break;
                case 12:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }
}