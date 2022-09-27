package com.ajay.wallet.repository;

import com.ajay.wallet.model.Transaction;
import com.ajay.wallet.model.Wallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("SELECT T FROM Transaction T where T.wallet.walletId = :walletId ORDER BY T.timestamp DESC")
    Iterable<Transaction> listTransactionsByWalletId(Long walletId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Transaction T where T.wallet = :wallet")
    void deleteTransactionsByWalletId(Wallet wallet);
}
