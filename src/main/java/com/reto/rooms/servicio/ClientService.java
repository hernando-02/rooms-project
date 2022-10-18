package com.reto.rooms.servicio;


import com.reto.rooms.entidad.Client;
import com.reto.rooms.entidad.Room;
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

    // get id
    public Client getClient(long id){
        return repository.findById(id).orElse(null);
    }

    // peticion post
    public Client saveClient(Client client){
        return repository.save(client);
    }

    //put
    public Client updateClient(Client client){
        Client clientOld= getClient(client.getIdClient());
//        clientOld.setEmail(client.getEmail());
        clientOld.setPassword(client.getPassword());
        clientOld.setName(client.getName());
        clientOld.setAge(client.getAge());
        //roomOld.setMessages(room.getMessages());
        return  repository.save(clientOld);
    }

    //delete
    public void deleteClient(long id){
        repository.deleteById(id);
    }
}
