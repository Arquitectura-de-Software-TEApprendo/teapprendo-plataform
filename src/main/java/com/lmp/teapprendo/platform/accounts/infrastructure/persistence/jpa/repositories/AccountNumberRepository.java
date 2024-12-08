package com.lmp.teapprendo.platform.accounts.infrastructure.persistence.jpa.repositories;

import com.lmp.teapprendo.platform.accounts.domain.processors.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountNumberRepository extends JpaRepository<AccountNumber, Long> {
    Optional<AccountNumber> getByNumber(String number);
}
