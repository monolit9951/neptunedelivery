package com.neptunes.repository;

import com.neptunes.domain.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    @Query("SELECT voucher FROM Voucher voucher WHERE voucher.code = :code" )
    Optional<Voucher> findVoucherByCode(String code);
}
