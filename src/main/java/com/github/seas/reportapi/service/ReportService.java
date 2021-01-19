package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.domain.ReportRequest;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.QuestionarioRepository;
import com.github.seas.reportapi.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);
    private final QuestionarioRepository repository;

    public void extrairRelatorio(ReportRequest report) throws IOException {
        String extractionReference = String.format("Extração de relatorio do mês %d e ano %d", report.getMonth(), report.getYear());
        logger.info(extractionReference);
        List<Questionario> response = repository.findByDataBetween(
                LocalDate.of(report.getYear(), report.getMonth(), 1).with(TemporalAdjusters.firstDayOfMonth()),
                LocalDate.of(report.getYear(), report.getMonth(), 1).with(TemporalAdjusters.lastDayOfMonth()));

        try (ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter("/tmp/SEAS/relatorio.csv"),
                CsvPreference.STANDARD_PREFERENCE)) {

            final String[] header = AppConstants.GERAL_HEADER;

            beanWriter.writeHeader(header);

            for (final Questionario questionario : response) {
                beanWriter.write(questionario, AppConstants.GERAL_MAPPING);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        }

    }
}
