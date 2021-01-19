package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.ReportRequest;
import com.github.seas.reportapi.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("extrair/mensal")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService service;

    @PostMapping(value = "/geral", produces = "application/json")
    public void gerarRelatorio(@RequestBody ReportRequest reportTime) throws Exception {
        service.extrairRelatorio(reportTime);
    }
}
