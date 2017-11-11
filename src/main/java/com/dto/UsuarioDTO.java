package com.dto;

import com.bo.Usuarios;

import javax.print.DocFlavor;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1506459580616529727L;

    private Integer id_user;
    private String nombre;
    private String apellido;
    private String email;
    private Integer id_usertype;

    public UsuarioDTO () {super();}

    public UsuarioDTO (Usuarios usuario){
        super();
        this.id_user = usuario.getId_user();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.id_usertype = usuario.getId_usertype();
    }

    public UsuarioDTO(Integer id_user, String nombre, String apellido, String email, Integer id_usertype) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.id_usertype = id_usertype;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_usertype() {
        return id_usertype;
    }

    public void setId_usertype(Integer id_usertype) {
        this.id_usertype = id_usertype;
    }

}
