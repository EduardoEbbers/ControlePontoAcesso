package com.dio.live.repository;

import com.dio.live.model.BancoHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHoraRepository extends JpaRepository<BancoHora, Long> {
}
