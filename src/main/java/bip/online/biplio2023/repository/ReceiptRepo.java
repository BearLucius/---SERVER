package bip.online.biplio2023.repository;


import bip.online.biplio2023.entity.ReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepo extends JpaRepository<ReceiptEntity,Long> {
  List<ReceiptEntity>findByBookName(String bookName);
}