package View;

import Controller.ProdutoController;
import Model.Produto;

import javax.swing.*;
import java.util.Scanner;

public class ProdutoView {
    ProdutoController produtoController = new ProdutoController();
    Scanner leitor = new Scanner(System.in);

    public void cadastraProduto(){
        Produto produto = new Produto();

        System.out.println("Qual produto deseja cadastrar:");
        produto.setNome(leitor.next());

        System.out.println("Digite o valor do produto:");
        produto.setValor(leitor.nextDouble());

        produtoController.criaTabela();
        produtoController.cadastraProduto(produto);

    }
    public void vizualiza(){
        System.out.println(produtoController.vizualiza());
    }
    public Produto selecionaProduto(){
        this.vizualiza();
        System.out.println("Selecione um produto:");
        Produto pd = produtoController.selecionaID(leitor.nextInt());
        System.out.println(pd);
        return pd;
    }
    public void editaProduto() {
        Produto edita = new Produto();
        edita = this.selecionaProduto();
        System.out.println("Selecione o que deseja editar:");
        int opcao = leitor.nextInt();
        switch (opcao) {
            case 1:
                edita.setNome(leitor.next());
                break;
            case 2:
                edita.setValor(leitor.nextDouble());
                break;
            default:
                System.out.println("Opção inválida!");
        }
        produtoController.editaProduto(edita);
    }
}
