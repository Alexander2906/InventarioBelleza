package Proyecto.InventarioBelleza.service.impl;

import Proyecto.InventarioBelleza.entity.Cliente;
import Proyecto.InventarioBelleza.repository.ClienteRepository;
import Proyecto.InventarioBelleza.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceimpl implements ClienteService {
    private final ClienteRepository repository;

    @Override
    public List<Cliente> findAll() { return repository.findAll();}

    @Override
    public Cliente save(Cliente cliente) { return repository.save(cliente);}

    @Override
    public Cliente update(Cliente cliente) {return repository.save(cliente);}

    @Override
    public Cliente finByid(Integer id) {return repository.findById(id).orElseThrow();}

    @Override
    public void delete(Integer id) { repository.deleteById(id);}
}
