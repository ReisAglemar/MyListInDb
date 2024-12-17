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
        Fornecedor federal = new Fornecedor("Federal");
        repositoryFornecedor.save(federal);

        // Create and save Categoria
        Categoria eletronicos = new Categoria("Eletrônicos");
        repositoryCategoria.save(eletronicos);
        Categoria esportes = new Categoria("Esportes");
        repositoryCategoria.save(esportes);
        Categoria alimentacao = new Categoria("Alimentação");
        repositoryCategoria.save(alimentacao);

        //create and save Pedido
        Pedido pedido = new Pedido();
        repositoryPedido.save(pedido);

        //Create and save Produto
        Produto celular = new Produto("Celular", 1500.94, eletronicos, federal, pedido);
        repositoryProduto.save(celular);

        Produto bolaFutebol = new Produto("Bola Futebol", 165.99, esportes, federal, pedido);
        repositoryProduto.save(bolaFutebol);

        Produto picanha = new Produto("Picanha", 200.99, alimentacao, federal, pedido);
        repositoryProduto.save(picanha);





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
