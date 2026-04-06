package Proyecto.InventarioBelleza.service;

import Proyecto.InventarioBelleza.entity.Categoria;
import Proyecto.InventarioBelleza.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public Cliente update(Cliente cliente);
    public Cliente finByid(Integer id);
    public void delete(Integer id);
}
