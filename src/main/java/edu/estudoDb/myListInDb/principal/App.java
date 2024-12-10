package edu.estudoDb.myListInDb.principal;

import edu.estudoDb.myListInDb.entity.Categoria;
import edu.estudoDb.myListInDb.entity.Pedido;
import edu.estudoDb.myListInDb.entity.Produto;
import edu.estudoDb.myListInDb.repository.RepositoryCategoria;
import edu.estudoDb.myListInDb.repository.RepositoryPedido;
import edu.estudoDb.myListInDb.repository.RepositoryProduto;

import java.util.ArrayList;
import java.util.List;

public class App {

    private RepositoryCategoria repositoryCategoria;
    private RepositoryPedido repositoryPedido;
    private RepositoryProduto repositoryProduto;
    private List<Categoria> categorias = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public App(RepositoryCategoria repositoryCategoria,
               RepositoryPedido repositoryPedido,
               RepositoryProduto repositoryProduto) {
        this.repositoryCategoria = repositoryCategoria;
        this.repositoryPedido = repositoryPedido;
        this.repositoryProduto = repositoryProduto;
    }

    public void init() {

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        repositoryCategoria.save(categoria);

        Pedido pedido = new Pedido();
        repositoryPedido.save(pedido);

        Produto produto = new Produto();
        produto.setNome("Produto 1");
        repositoryProduto.save(produto);

        categorias = repositoryCategoria.findAll();
        pedidos = repositoryPedido.findAll();
        produtos = repositoryProduto.findAll();

        categorias.forEach(System.out::println);
        pedidos.forEach(System.out::println);
        produtos.forEach(System.out::println);

    }
}
