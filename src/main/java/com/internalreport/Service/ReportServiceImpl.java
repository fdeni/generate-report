package com.internalreport.Service;

import com.internalreport.entity.Period;
import com.internalreport.entity.Product;
import com.internalreport.entity.Transaction;
import com.internalreport.model.ReportRequest;
import com.internalreport.model.ReportResponse;
import com.internalreport.repository.PeriodRepository;
import com.internalreport.repository.ProductRepository;
import com.internalreport.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PeriodRepository periodRepository;

    @Override
    public List<ReportResponse> generateReport(ReportRequest req) {
        List<ReportResponse> reports = new ArrayList<>();

        Period period = periodRepository.findByStartDateAndEndDate(req.getStartDate(),req.getEndDate());
        if (period == null) {
            throw new RuntimeException("Invalid Period");
        }

        List<Transaction> transactionList = transactionRepository.findByDateBetween(req.getStartDate(),req.getEndDate());
        for(Transaction transaction: transactionList) {
            Product product = productRepository.findOneById(transaction.getProductId());
            ReportResponse reportResponse = new ReportResponse();
            reportResponse.setNo(transaction.getId());
            reportResponse.setProductId(transaction.getProductId());
            reportResponse.setProductName(product.getName());
            reportResponse.setProductType(product.getType());
            reportResponse.setPrice(transaction.getTotal());
            reportResponse.setMargin(transaction.getMargin());
            reports.add(reportResponse);
        }
        return reports;
    }
}
