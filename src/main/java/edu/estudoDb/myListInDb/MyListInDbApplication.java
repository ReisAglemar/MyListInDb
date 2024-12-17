package edu.estudoDb.myListInDb;

import edu.estudoDb.myListInDb.principal.App;
import edu.estudoDb.myListInDb.repository.RepositoryCategoria;
import edu.estudoDb.myListInDb.repository.RepositoryFornecedor;
import edu.estudoDb.myListInDb.repository.RepositoryPedido;
import edu.estudoDb.myListInDb.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;

@SpringBootApplication
public class MyListInDbApplication implements CommandLineRunner {

    //injeção de dependências
    @Autowired
    private RepositoryCategoria repositoryCategoria;


    @Autowired
    private RepositoryPedido repositoryPedido;

    @Autowired
    private RepositoryProduto repositoryProduto;

    @Autowired
    private RepositoryFornecedor repositoryFornecedor;


    private final ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

    public MyListInDbApplication(ProjectInfoAutoConfiguration projectInfoAutoConfiguration) {
        this.projectInfoAutoConfiguration = projectInfoAutoConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyListInDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        App app = new App(repositoryCategoria, repositoryPedido, repositoryProduto, repositoryFornecedor);
        app.init();
    }
}
