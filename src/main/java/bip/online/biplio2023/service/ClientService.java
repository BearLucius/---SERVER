package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.ClientEntity;
import bip.online.biplio2023.repository.ClientRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class ClientService {
    private final ClientRepo repo;

    public List<ClientEntity> findAll() {
return repo.findAll();
    }
    public Optional<ClientEntity> findById(Long id) {
        return repo.findById(id);
    }
        public ClientEntity save (@Valid ClientEntity data) {
            return repo.save(data);
        }
            public void update (ClientEntity data) {
                repo.save(data);
            }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}
