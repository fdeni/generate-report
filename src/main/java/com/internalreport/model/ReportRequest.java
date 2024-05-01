package com.internalreport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportRequest {
    @JsonProperty(value = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @JsonProperty(value = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;
}
