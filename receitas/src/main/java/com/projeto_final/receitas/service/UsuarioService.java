package com.projeto_final.receitas.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.projeto_final.receitas.entity.Usuario;
import com.projeto_final.receitas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario create(Usuario obj){
        return repository.save(obj);
    }


    public Usuario login(String email, String senha) {

        Optional<Usuario> usuario = repository.findByEmail(email);

        if (usuario.isPresent()) {

            if (usuario.get().getPassword().equals(senha)) {
                return usuario.get();
            }

        }

        return null;
    }


    public void delete (Long id){
        repository.deleteById(id);
    }

    public Usuario getId (Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();
    }

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario update (Usuario obj){
        Optional<Usuario> newObj = repository.findById(obj.getId());
        updateUsuario (newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateUsuario (Optional<Usuario> newObj, Usuario obj){
        newObj.get().setName(obj.getName());
    }
}
