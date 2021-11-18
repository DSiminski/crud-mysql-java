import View.ProdutoView;

public class Main {
    public static void main(String args[])throws ClassNotFoundException {

        ProdutoView produtoView = new ProdutoView();
        produtoView.cadastraProduto();
        produtoView.vizualiza();
        produtoView.selecionaProduto();
        produtoView.editaProduto();
    }

}
