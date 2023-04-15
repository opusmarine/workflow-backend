package com.opus.workflow.repository;

import com.opus.workflow.models.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottosRepository extends JpaRepository<Lotto, Long> {
}
