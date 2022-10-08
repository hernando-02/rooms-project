package com.reto.rooms.controler;


import com.reto.rooms.entidad.Admin;
import com.reto.rooms.servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Admin")
public class ApiAdmin {

    @Autowired
    private AdminService adminService;

    // get
    @GetMapping("/all")
    public List<Admin> getAllAdmin(){
        return adminService.getAdmins();
    }

    // post
    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }


}
