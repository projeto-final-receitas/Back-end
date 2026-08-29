package com.projeto_final.receitas.service;

import java.util.List;
import java.util.Optional;
import com.projeto_final.receitas.entity.Administrador;
import com.projeto_final.receitas.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository repository;
    public Administrador create(Administrador obj){
        return repository.save(obj);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
    public Administrador getId (Long id){
        Optional<Administrador> obj = repository.findById(id);
        return obj.get();
    }

    public List<Administrador> getAll(){
        return repository.findAll();
    }

    public Administrador update (Administrador obj){
        Optional<Administrador> newObj = repository.findById(obj.getId());
        updateAdministrador (newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateAdministrador (Optional<Administrador> newObj, Administrador obj){
        newObj.get().setNome(obj.getNome());
    }
}
