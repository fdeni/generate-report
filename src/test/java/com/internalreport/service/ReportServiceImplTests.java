package com.internalreport.service;

import com.internalreport.Service.ReportServiceImpl;
import com.internalreport.entity.Period;
import com.internalreport.entity.Product;
import com.internalreport.entity.Transaction;
import com.internalreport.model.ReportRequest;
import com.internalreport.model.ReportResponse;
import com.internalreport.repository.PeriodRepository;
import com.internalreport.repository.ProductRepository;
import com.internalreport.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReportServiceImplTests {
    @InjectMocks
    private ReportServiceImpl reportService;
    @Mock
    private PeriodRepository periodRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private ProductRepository productRepository;


    @Test
    public void testGenerateReport() {
        ReportRequest request = new ReportRequest();
        request.setStartDate("2024-01-01");
        request.setEndDate("2024-03-01");

        Period period = new Period();
        period.setStartDate(request.getStartDate());
        period.setEndDate(request.getEndDate());

        when(periodRepository.findByStartDateAndEndDate(request.getStartDate(), request.getEndDate())).thenReturn(period);

        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setProductId(1L);
        transaction.setTotal(100.00);
        transaction.setMargin(10.0);
        transactions.add(transaction);

        when(transactionRepository.findByDateBetween(request.getStartDate(), request.getEndDate())).thenReturn(transactions);

        Product product = new Product();
        product.setName("Test Product");
        product.setType("Test Type");

        when(productRepository.findOneById(1L)).thenReturn(product);

        List<ReportResponse> reports = reportService.generateReport(request);

        assertEquals(1, reports.size());
        assertEquals(1L, reports.get(0).getNo());
        assertEquals(1L, reports.get(0).getProductId());
        assertEquals("Test Product", reports.get(0).getProductName());
        assertEquals("Test Type", reports.get(0).getProductType());
        assertEquals(100, reports.get(0).getPrice());
        assertEquals(10, reports.get(0).getMargin());
    }
}
