package BinaryTree;

import Queue.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> raiz;

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public T find(T value) {
        if (this.isEmpty() == true) {
            return null;
        } else {
            return raiz.findNode(value);
        }
    }

    public void insert(T value) {
        if (this.isEmpty() == true) {
            this.raiz = new TreeNode(value);
        } else {
            raiz.insertNode(value);
        }
    }

    public void passeioPorNivel() {
        Queue<TreeNode<T>> fila;
        TreeNode<T> aux;
        if (this.isEmpty() == false) {
            fila = new Queue();
            fila.enqueue(raiz);
            while (fila.isEmpty() == false) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                }
                System.out.print(aux.getInfo() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Árvore vazia");
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerEmOrdem(raiz);
        }
    }

    private void percorrerEmOrdem(TreeNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getEsq());
            System.out.println(r.getInfo() + " ");
            percorrerEmOrdem(r.getDir());
        }
    }

    private TreeNode<T> menorNode(TreeNode<T> raiz) {
        if (raiz.getEsq() == null) {
            return raiz;
        } else {
            return menorNode(raiz.getEsq());
        }
    }

    public T menorValor() {
        if (!this.isEmpty()) {
            return this.menorNode(this.raiz).getInfo();
        } else {
            System.out.println("Árvore vazia");
            return null;
        }
    }

    private TreeNode<T> maiorNode(TreeNode<T> raiz) {
        if (raiz.getDir() == null) {
            return raiz;
        } else {
            return maiorNode(raiz.getDir());
        }
    }

    public T maiorValor() {
        if (!this.isEmpty()) {
            return this.maiorNode(this.raiz).getInfo();
        } else {
            System.out.println("Árvore vazia");
            return null;
        }
    }

    public void numeroNodes() {
        Queue<TreeNode<T>> fila;
        TreeNode<T> aux;
        int qtd = 0;
        if (this.isEmpty() == false) {
            fila = new Queue();
            fila.enqueue(raiz);
            while (fila.isEmpty() == false) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                }
                qtd++;
            }
            System.out.println(qtd);
        } else {
            System.out.println("Árvore vazia");
        }
    }

    public void numeroFolhas() {
        Queue<TreeNode<T>> fila;
        TreeNode<T> aux;
        int qtd = 0;
        if (this.isEmpty() == false) {
            fila = new Queue();
            fila.enqueue(raiz);
            while (fila.isEmpty() == false) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                    qtd++;
                } else if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                    qtd++;
                }
            }
            System.out.println(qtd);
        } else {
            System.out.println("Árvore vazia");
        }
    }

    /*
     * public void numeroNodesNaoTerminais(TreeNode<Integer> raiz) {
     * Queue<TreeNode<Integer>> fila;
     * TreeNode<Integer> aux;
     * int qtd =0;
     * if (this.isEmpty() == false) {
     * fila = new Queue();
     * fila.enqueue(raiz);
     * while (fila.isEmpty() == false) {
     * aux = fila.dequeue();
     * if (aux.getEsq() != null) {
     * fila.enqueue(aux.getEsq());
     * }
     * if (aux.getDir() != null) {
     * fila.enqueue(aux.getDir());
     * }
     * qtd++;
     * }
     * System.out.println(qtd);
     * } else {
     * System.out.println("Árvore vazia");
     * }
     * }
     */
    public int numeroNodesNaoTerminais(TreeNode<Integer> raiz) {
        if (raiz == null) {
            return 0;
        }
        int res = 0;
        if (raiz.getEsq() != null && raiz.getDir() != null) {
            res++;
        }
        res += (numeroNodesNaoTerminais(raiz.getEsq()) + numeroNodesNaoTerminais(raiz.getDir()));
        return res;
    }

    public void inserirNaoRecursivo(TreeNode<T> newNode) {
        if (this.raiz == null) {
            this.raiz = newNode;
        } else {
            TreeNode<T> curr = this.raiz;
            while (curr != null) {
                if (newNode.getInfo().compareTo(curr.getInfo()) < 0) {
                    if (curr.getEsq() == null) {
                        curr.setEsq(newNode);
                        break;
                    } else {
                        curr = curr.getEsq();
                    }
                } else {
                    if (curr.getDir() == null) {
                        curr.setDir(newNode);
                        break;
                    } else {
                        curr = curr.getDir();
                    }
                }
            }
        }
    }

    public T buscarNaoRecursivo(T info) {
        if(!this.isEmpty()) {
            Queue<TreeNode<T>> queue = new Queue<>();
            queue.enqueue(this.raiz);
            while(!queue.isEmpty()) {
                TreeNode<T> curr = queue.dequeue();
                if(curr.getInfo().equals(info)) {
                    return curr.getInfo();
                } else {
                    if(curr.getEsq() != null) {
                        queue.enqueue(curr.getEsq());
                    }
                    if(curr.getDir() != null) {
                        queue.enqueue(curr.getDir());
                    }
                }
            }
        }

        return null;
    }
}