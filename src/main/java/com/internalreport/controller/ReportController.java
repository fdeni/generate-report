package com.internalreport.controller;

import com.internalreport.Service.ReportService;
import com.internalreport.model.BaseResponse;
import com.internalreport.model.ReportRequest;
import com.internalreport.model.ReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/generate-report")
    private BaseResponse<List<ReportResponse>> generateReport(@RequestBody  ReportRequest req)  {
        return BaseResponse.<List<ReportResponse>>builder()
                .data(reportService.generateReport(req))
                .status(HttpStatus.OK.value())
                .build();
    }
}
