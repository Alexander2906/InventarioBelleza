package Proyecto.InventarioBelleza.service.impl;

import Proyecto.InventarioBelleza.entity.Categoria;
import Proyecto.InventarioBelleza.repository.CategoriaRepository;
import Proyecto.InventarioBelleza.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {return repository.findAll();}

    @Override
    public Categoria save(Categoria categoria) { return repository.save(categoria);}

    @Override
    public Categoria update(Categoria categoria) { return repository.save(categoria);}

    @Override
    public Categoria finByid(Integer id) { return repository.findById(id).orElseThrow();}

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
