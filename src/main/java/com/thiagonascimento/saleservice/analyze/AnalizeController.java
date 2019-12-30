package com.thiagonascimento.saleservice.analyze;

import com.thiagonascimento.saleservice.analyze.dto.AnalizeDTO;
import com.thiagonascimento.saleservice.analyze.mapper.AnalizeMapper;
import com.thiagonascimento.saleservice.analyze.service.AnalyzeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/analyze")
public class AnalizeController {

    private AnalyzeService service;

    @GetMapping
    public Mono<AnalizeDTO> analyze() {
        return service.analyze().map(AnalizeMapper::mapToDTO);
    }
}
