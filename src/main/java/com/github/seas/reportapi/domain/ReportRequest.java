package com.github.seas.reportapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportRequest {
    private Integer month;
    private Integer year;
}
