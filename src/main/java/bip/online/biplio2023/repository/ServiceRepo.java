package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<ServiceEntity,Long> {
}
