package com.brunosam.vendas.domaim.repositorio;

import com.brunosam.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);


    List<Cliente> findAllByOrderByNomeDesc();
}
