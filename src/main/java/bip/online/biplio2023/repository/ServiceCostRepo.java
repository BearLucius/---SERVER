package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.ServiceCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ServiceCostRepo extends JpaRepository<ServiceCostEntity,Long> {
}
