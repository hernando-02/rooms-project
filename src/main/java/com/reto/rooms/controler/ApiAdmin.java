package com.reto.rooms.controler;


import com.reto.rooms.entidad.Admin;
import com.reto.rooms.entidad.Category;
import com.reto.rooms.entidad.Reservation;
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

    // get by id
    @GetMapping("/{id}")
    public Admin getAdmin(long id){
        return adminService.getAdmin(id);
    }

    // post
    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.status(204).build();
    }


}
