package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Admin;
import com.reto.rooms.entidad.Score;
import com.reto.rooms.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Admin getAdmin(long id){
        return  adminRepository.findById(id).orElse(null);
    }

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin){
        Admin adminOld = getAdmin(admin.getIdAdmin());
        adminOld.setPassword(admin.getPassword());
        adminOld.setName(admin.getName());
        return adminRepository.save(adminOld);
    }

    public void deleteAdmin(long id){
        adminRepository.deleteById(id);
    }
}
