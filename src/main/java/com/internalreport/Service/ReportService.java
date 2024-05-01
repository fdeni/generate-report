package com.internalreport.Service;

import com.internalreport.model.ReportRequest;
import com.internalreport.model.ReportResponse;

import java.util.Date;
import java.util.List;


public interface ReportService {
    List<ReportResponse> generateReport(ReportRequest req);
}
