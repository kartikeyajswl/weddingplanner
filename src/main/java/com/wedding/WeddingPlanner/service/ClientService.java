package com.wedding.WeddingPlanner.service;


import com.wedding.WeddingPlanner.dto.ClientDto;
import com.wedding.WeddingPlanner.entity.Client;
import com.wedding.WeddingPlanner.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    private ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public ClientDto registerClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        Client save = clientRepository.save(client);
        return  modelMapper.map(save, ClientDto.class);

    }

    public ClientDto getClientDetailsById(long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new RuntimeException("Client not found with id: " + clientId));
                return modelMapper.map(client, ClientDto.class);

    }

    public List<ClientDto> getClientList() {
        List<Client> all = clientRepository.findAll();
        return all.stream().map(s -> modelMapper.map(s, ClientDto.class)).collect(Collectors.toList());

    }


    public List<ClientDto> findByWeddingDate(String weddingDate) {
        List<Client> weddingOfClient = clientRepository.findByWeddingDate(weddingDate);
        return weddingOfClient.stream().map(s->modelMapper.map(s,ClientDto.class)).collect(Collectors.toList());

    }



    public List<ClientDto> findByBudgetRange(double minBudgetRange, double maxBudgetRange) {
        List<Client> byBudgetRangeClientList = clientRepository.findByBudgetRange(minBudgetRange, maxBudgetRange);
        return byBudgetRangeClientList.stream().map(s->modelMapper.map(s,ClientDto.class)).collect(Collectors.toList());
    }

}