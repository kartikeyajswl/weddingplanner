package com.wedding.WeddingPlanner.controller;


import com.wedding.WeddingPlanner.dto.ClientDto;
import com.wedding.WeddingPlanner.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cli")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto) {
        ClientDto clientDto1 = clientService.registerClient(clientDto);
        return ResponseEntity.ok(clientDto1);

    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<ClientDto> getClientDetailsById(@PathVariable long clientId) {
        ClientDto clientDetailsById = clientService.getClientDetailsById(clientId);
        return ResponseEntity.ok(clientDetailsById);

    }

    @GetMapping("/list/clientId")
    public ResponseEntity<List<ClientDto>> getClientList(@RequestParam long clientId) {
        List<ClientDto> clientList = clientService.getClientList();
        return ResponseEntity.ok(clientList);
}

    @GetMapping("/weddingDate/lists")
    public ResponseEntity<List<ClientDto>> findByWeddingDate(@RequestParam String weddingDate){
        List<ClientDto> byWeddingDate = clientService.findByWeddingDate(weddingDate);
        return ResponseEntity.ok(byWeddingDate);
    }

    @GetMapping("budget/lists")
     public ResponseEntity<List<ClientDto>> findByBudgetRange(
             @RequestParam double minBudgetRange,
             @RequestParam double maxBudgetRange
             ) {
        List<ClientDto> byBudgetRange = clientService.findByBudgetRange(minBudgetRange, maxBudgetRange);
        return ResponseEntity.ok(byBudgetRange);


    }



}
