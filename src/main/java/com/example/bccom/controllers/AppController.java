package com.example.bccom.controllers;

import com.example.bccom.models.Building;
import com.example.bccom.services.BuildingService;
import com.example.bccom.services.ClientService;
import com.example.bccom.services.FlatService;
import com.example.bccom.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String buildings(@RequestParam(name = "district", required = false) String district, Model model){
        model.addAttribute("buildings", buildingService.listBuildings(district));
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
    public String addBuilding(Building building){
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
        return "redirect:/building/{id}";
    }

    @PostMapping("/building/delete/{id}")
    public String deleteBuilding(@PathVariable Integer id) {
        buildingService.deleteBuilding(id);
        return "redirect:/";
    }

    @GetMapping("/clients")
    public String clients(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("clients", clientService.listClients(name));
        return "clients";
    }

    @GetMapping("/client/{id}")
    public String clientInfo(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "client-info";
    }

    @GetMapping("/orders")
    public String orders(@RequestParam(name = "id", required = false) Integer id, Model model){
        model.addAttribute("orders", orderService.listOrders(id));
        return "orders";
    }

//    private final static String PATH = "/error";
//    @RequestMapping(PATH)
//    @ResponseBody
//    public String getErrorPath() {
//        // TODO Auto-generated method stub
//        return "No Mapping Found";
//    }

}
