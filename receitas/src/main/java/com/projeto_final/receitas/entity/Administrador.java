package com.projeto_final.receitas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter
@Getter
@Entity
@Table(name = "tb_administrador")
public class Administrador extends Usuario implements Serializable{
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Administrador extends Usuario {

>>>>>>> origin/usuarios
    private String token;
}
