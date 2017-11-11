package com.repository;

import com.bo.Pregunta;
import com.bo.Usuarios;
import com.dto.UsuarioDTO;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{

    @Query("SELECT U.id_user FROM Usuarios U WHERE U.email =:email AND U.password =:password")
    Integer findIdUsuario(@Param("email") String email,
                          @Param("password")String password);
}
