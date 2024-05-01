package com.internalreport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportResponse {
    @JsonProperty(value = "no")
    private Long no;

    @JsonProperty(value = "productId")
    private Long productId;

    @JsonProperty(value = "productName")
    private String productName;

    @JsonProperty(value = "productType")
    private String productType;

    @JsonProperty(value = "price")
    private Double price;

    @JsonProperty(value = "margin")
    private Double margin;
}
