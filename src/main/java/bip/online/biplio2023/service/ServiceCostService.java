package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.ServiceCostEntity;
import bip.online.biplio2023.repository.ServiceCostRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServiceCostService {

    private final ServiceCostRepo repo;

    public List<ServiceCostEntity> findAll() {
        return repo.findAll();
    }
    public Optional<ServiceCostEntity> findById(Long id) {
        return repo.findById(id);
    }
    public ServiceCostEntity save (ServiceCostEntity data) {
        return repo.save(data);
    }
    public void update (ServiceCostEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}


