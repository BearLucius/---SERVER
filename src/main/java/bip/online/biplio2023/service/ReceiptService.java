package bip.online.biplio2023.service;
import bip.online.biplio2023.entity.ReceiptEntity;
import bip.online.biplio2023.repository.ReceiptRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ReceiptService {
    private final ReceiptRepo repo;

    public List<ReceiptEntity> findAll() {
        return repo.findAll();
    }
    public Optional<ReceiptEntity> findById(Long id) {
        return repo.findById(id);
    }
    public ReceiptEntity save (ReceiptEntity data) {
        return repo.save(data);
    }
    public void update (ReceiptEntity data) {
        repo.save(data);
    }

    public List<ReceiptEntity> getReceiptName(String bookName){
        return repo.findByBookName(bookName);
    }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}


