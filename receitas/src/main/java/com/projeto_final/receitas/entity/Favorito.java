package com.projeto_final.receitas.entity;

import com.projeto_final.receitas.ChaveComposta.FavoritoId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode ( of = "id" )
@Entity
@Table(name = "tb_favorito")
public class Favorito implements Serializable {
    @EmbeddedId
    private FavoritoId id;


    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn( name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("receitaId")
    @JoinColumn( name = "receita_id")
    private Receita receita;

    @Column(name = "data_adicionado")
    private LocalDateTime dataAdicionado = LocalDateTime.now();

    public Favorito() {}

    public FavoritoId getId() {
        return id;
    }

    public void setId(FavoritoId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public LocalDateTime getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(LocalDateTime dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}
=======
package com.projeto_final.receitas.entity;

import com.projeto_final.receitas.ChaveComposta.FavoritoId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_favorito")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Favorito implements Serializable {

    @EmbeddedId
    private FavoritoId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("receitaId")
    @JoinColumn(name = "receita_id")
    private Receita receita;

    @Column(name = "data_adicionado")
    private LocalDateTime dataAdicionado;

    public Favorito(Usuario usuario, Receita receita) {
        this.usuario = usuario;
        this.receita = receita;
        this.id = new FavoritoId(usuario.getId(), receita.getId());
        this.dataAdicionado = LocalDateTime.now();
    }
}
>>>>>>> origin/usuarios
