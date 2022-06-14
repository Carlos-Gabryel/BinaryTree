package BinaryTree;
class TreeNode <T extends Comparable<T>>{  // A classe TreeNode tem visibilidade de pacote
    
    private TreeNode<T> esq;
    private T info;
    private TreeNode<T> dir;

    TreeNode (T valor) {
        this.info = valor;
    }
    void setInfo(T valor) {
        this.info = valor;
    }
    void setEsq (TreeNode<T> novaEsq) {
        this.esq = novaEsq;
    }
    void setDir (TreeNode<T> novaDir) {
        this.dir = novaDir;
    }
    T getInfo() {
        return this.info;
    }
    TreeNode<T> getEsq () {
        return this.esq;
    }
    TreeNode<T> getDir () {
        return this.dir;
    }
    
    T findNode (T value) {
        if (value.compareTo(this.info) == 0) {
            return this.info;
        }
        else if (value.compareTo(this.info) < 0) {
            if (this.esq == null){
                return null;
            }
            else {
                return this.esq.findNode (value);
            }
        }
        else {
            if (this.dir == null){
                return null;
            }
            else {
                return this.dir.findNode (value);
            }
        }
    }
    
    void insertNode (T value){
        if (value.compareTo(this.getInfo()) == 0) {
            System.out.println("Valor repetido.");
        }
        else if (value.compareTo(this.getInfo()) < 0) {
            if (this.esq == null){
                this.esq = new TreeNode (value);
            }
            else {
                this.esq.insertNode (value);
            }
        }
        else {
            if (this.dir == null){
                this.dir = new TreeNode (value);
            }
            else {
                this.dir.insertNode (value);
            }
        }
    }
}