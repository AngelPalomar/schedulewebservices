package com.example.schedulewebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedulewebservices.dao.ServiceDao;
import com.example.schedulewebservices.models.Service;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceDao serviceDao;

    @GetMapping("")
    public List<Service> get() {
        return serviceDao.findAll();
    }

    @GetMapping("/{service_name}")
    public Service getByUser_Name(@PathVariable String service_name) {
        return serviceDao.findByName(service_name);
    }

    @PostMapping("")
    public ResponseEntity<Service> post(@RequestBody Service service) {
        try {
            Service newService = serviceDao.save(service);
            return new ResponseEntity<Service>(newService, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{service_name}")
    public ResponseEntity<Service> put(@PathVariable String service_name, @RequestBody Service service) {
        Service serviceStored = serviceDao.findByName(service_name);
        if (serviceStored != null) {
            try {
                serviceStored.setName(service.getName());
                serviceStored.setDescription(service.getDescription());
                serviceDao.save(serviceStored);

                return new ResponseEntity<Service>(serviceStored, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{service_name}")
    public ResponseEntity<Service> delete(@PathVariable String service_name) {
        Service serviceStored = serviceDao.findByName(service_name);
        if (serviceStored != null) {
            try {
                serviceDao.delete(serviceStored);
                return new ResponseEntity<Service>(serviceStored, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
