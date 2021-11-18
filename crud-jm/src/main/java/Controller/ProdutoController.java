package Controller;

import Dao.ProdutoDao;
import Model.Produto;

import java.util.List;

public class ProdutoController {
    public void criaTabela(){
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.criaTabela();
    }
    public void cadastraProduto(Produto p){
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.cadastraProduto(p);
    }
    public List<Produto> vizualiza(){
        ProdutoDao produtoDao = new ProdutoDao();
        return produtoDao.visualiza();
    }
    public Produto selecionaID(int id){
        ProdutoDao produtoDao = new ProdutoDao();
        return  produtoDao.selectId(id);
    }
    public void editaProduto(Produto produto){
        ProdutoDao productDao= new ProdutoDao();
        productDao.editaProduto(produto);
    }
}
