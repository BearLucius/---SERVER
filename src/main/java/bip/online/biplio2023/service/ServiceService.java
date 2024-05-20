package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.ServiceEntity;
import bip.online.biplio2023.repository.ServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServiceService {

    private final ServiceRepo repo;

    public List<ServiceEntity> findAll() {
        return repo.findAll();
    }
    public Optional<ServiceEntity> findById(Long id) {
        return repo.findById(id);
    }
    public ServiceEntity save (ServiceEntity data) {
        return repo.save(data);
    }
    public void update (ServiceEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }
}

