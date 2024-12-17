package edu.estudoDb.myListInDb.principal;

import edu.estudoDb.myListInDb.entity.Categoria;
import edu.estudoDb.myListInDb.entity.Fornecedor;
import edu.estudoDb.myListInDb.entity.Pedido;
import edu.estudoDb.myListInDb.entity.Produto;
import edu.estudoDb.myListInDb.repository.RepositoryCategoria;
import edu.estudoDb.myListInDb.repository.RepositoryFornecedor;
import edu.estudoDb.myListInDb.repository.RepositoryPedido;
import edu.estudoDb.myListInDb.repository.RepositoryProduto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private RepositoryCategoria repositoryCategoria;
    private RepositoryPedido repositoryPedido;
    private RepositoryProduto repositoryProduto;
    private RepositoryFornecedor repositoryFornecedor;
    private List<Categoria> categorias = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public App(RepositoryCategoria repositoryCategoria,
               RepositoryPedido repositoryPedido,
               RepositoryProduto repositoryProduto,
               RepositoryFornecedor repositoryFornecedor) {
        this.repositoryCategoria = repositoryCategoria;
        this.repositoryPedido = repositoryPedido;
        this.repositoryProduto = repositoryProduto;
        this.repositoryFornecedor = repositoryFornecedor;
    }

    public void init() {

        String encerrar;

        //create and save Forncedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Federal");
        repositoryFornecedor.save(fornecedor);

        // Create and save Categoria
        Categoria categoria1 = new Categoria();
        categoria1.setNome("Eletronicos");
        repositoryCategoria.save(categoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Esportes");
        repositoryCategoria.save(categoria2);

        Categoria categoria3 = new Categoria();
        categoria3.setNome("Alimentacao");
        repositoryCategoria.save(categoria3);

        //create and save Pedido
        Pedido pedido = new Pedido();
        repositoryPedido.save(pedido);

        //Create and save Produto
        Produto produto1 = new Produto();
        produto1.setNome("celular");
        produto1.setPreco(1500.54);
        produto1.setCategoria(categoria1);
        produto1.setFornecedor(fornecedor);
        repositoryProduto.save(produto1);

        Produto produto2 = new Produto();
        produto2.setNome("bola futebol");
        produto2.setPreco(250.90);
        produto2.setCategoria(categoria2);
        produto2.setFornecedor(fornecedor);
        repositoryProduto.save(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("picanha");
        produto3.setPreco(199.99);
        produto3.setCategoria(categoria3);
        produto3.setFornecedor(fornecedor);
        repositoryProduto.save(produto3);

        //Created lists with data of DB
        categorias = repositoryCategoria.findAll();
        pedidos = repositoryPedido.findAll();
        produtos = repositoryProduto.findAll();

        //Read lists
        categorias.forEach(System.out::println);
        pedidos.forEach(System.out::println);
        produtos.forEach(System.out::println);

        System.out.println("Pressione 'Enter' Para Encerrar!");

       encerrar = in.nextLine();



    }
}
