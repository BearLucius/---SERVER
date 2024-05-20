package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity,Long> {

}
