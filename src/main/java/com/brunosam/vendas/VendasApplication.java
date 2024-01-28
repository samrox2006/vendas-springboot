package com.brunosam.vendas;

import com.brunosam.vendas.domaim.repositorio.Clientes;
import com.brunosam.vendas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando clientes..");
			clientes.save(new Cliente("Douglas"));
			clientes.save(new Cliente("Bruno"));
			clientes.save(new Cliente("Breno"));

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes..");
			todosClientes.forEach(c->{
				c.setNome(c.getNome()+ " aluatlizado.");
				clientes.save(c);
			});

			boolean existe = clientes.existsByNome("Douglas");
			System.out.println("existe um cliente com o nome Douglas?"+ existe);


			todosClientes = clientes.findAllByOrderByNomeDesc();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");
			}else{
				todosClientes.forEach(System.out::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
