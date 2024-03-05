package com.example.bccom.controllers;

import com.example.bccom.models.Building;
import com.example.bccom.models.Client;
import com.example.bccom.models.Flat;
import com.example.bccom.services.BuildingService;
import com.example.bccom.services.ClientService;
import com.example.bccom.services.FlatService;
import com.example.bccom.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
@ComponentScan({"com.example.bccom.controllers", "com.example.bccom.models", "com.example.bccom.services",
        "com.example.bccom.repo"})

public class AppController implements ErrorController {

    private final BuildingService buildingService;
    private final ClientService clientService;
    private final OrderService orderService;
    private final FlatService flatService;

    @GetMapping("/")
    public String buildings(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("buildings", buildingService.listBuildings(name));
        return "buildings";
    }

    @GetMapping("/building/{id}")
    public String buildingInfo(@PathVariable Integer id, Model model){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "build-info";
    }

    @GetMapping("/add-building")
    public String addBuildings(){
        return "add-building";
    }

    @PostMapping("/building/add")
    public String addBuilding(Building building) throws SQLException {
        buildingService.saveBuilding(building);
        return "redirect:/add-building";
    }

    @GetMapping("/building/edit/{id}")
    public String editBuilding(@PathVariable Integer id, Model model){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "edit-building";
    }

    @PostMapping("/building/edit/{id}")
    public String updateBuilding(Building building){
        buildingService.editBuilding(building, building.getId());
        return "redirect:/";
    }

    @GetMapping("/building/add-flat")
    public String addFlat(@PathVariable Integer id, Model model){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "add-flat";
    }

    @PostMapping("/building/add-flat")
    public String saveFlat(Flat flat){
        flatService.saveFlat(flat);
        return "redirect:/building/{id}";
    }

    @PostMapping("/building/delete/{id}")
    public String deleteBuilding(@PathVariable Integer id) {
        buildingService.deleteBuilding(id);
        return "redirect:/";
    }

    @GetMapping("/flats/{id}")
    public String flat(@PathVariable Integer id, Model model){
        model.addAttribute("flat",flatService.getFlatById(id));
        return "flat-info";
    }

    @GetMapping("/flats/edit/{id}")
    public String editFlat(@PathVariable Integer id, Model model){
        model.addAttribute("flat", flatService.getFlatById(id));
        return "edit-flat";
    }

    @PostMapping("/flats/edit/{id}")
    public String updateFlat(Flat flat){
        flatService.editFlat(flat, flat.getId());
        return "redirect:/";
    }

    @GetMapping("/flats/delete/{id}")
    public String deleteFlat(@PathVariable Integer id){
        Integer bid = flatService.getFlatById(id).getBuilding().getId();
        flatService.deleteFlat(id);
        return "redirect:/building/${bid}";
    }

    @GetMapping("/clients")
    public String clients(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("clients", clientService.listClients(name));
        return "clients";
    }

    @GetMapping("/client/{id}")
    public String clientInfo(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "client-info";
    }

    @GetMapping("/client/add-client")
    public String addClient(){
        return "add-client";
    }

    @PostMapping("/client/add")
    public String newClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "edit-client";
    }

    @PostMapping("/client/edit/{id}")
    public String updateClient(Client client){
        clientService.editClient(client, client.getId());
        return "redirect:/clients";
    }

    @PostMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/{login}/orders")
    public String orders(@RequestParam(name = "id", required = false) Integer id, Model model){
        model.addAttribute("orders", orderService.listOrders(id));
        return "orders";
    }

}
