package com.br.vms.projeto.Interface;



import org.springframework.data.jpa.repository.JpaRepository;

import com.br.vms.projeto.model.Usuario;

public interface UsuariosInterface extends JpaRepository<Usuario, Long>   {

}
