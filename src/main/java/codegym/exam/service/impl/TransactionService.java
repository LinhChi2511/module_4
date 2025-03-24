package codegym.exam.service.impl;

import codegym.exam.model.Transaction;
import codegym.exam.repository.ITransactionRepository;
import codegym.exam.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepo;

    @Override
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    @Override
    public void save(Transaction s) {
        transactionRepo.save(s);
    }

    @Override
    public void update(Long id, Transaction s) {

    }

    @Override
    public void remove(Long id) {
        transactionRepo.deleteById(id);
    }


}

