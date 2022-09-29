package com.reto.rooms.servicio;


import com.reto.rooms.entidad.Client;
import com.reto.rooms.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired // es como hacer una instancia
    private ClientRepository repository;

    //    peticion get
    public List<Client> getClientes(){
        return repository.findAll();
    }
    // peticion post
    public Client saveClient(Client client){
        return repository.save(client);
    }

}
