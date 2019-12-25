package com.thiagonascimento.saleservice.analyze;

import com.thiagonascimento.saleservice.analyze.dto.AnalizeDTO;
import com.thiagonascimento.saleservice.analyze.mapper.AnalizeMapper;
import com.thiagonascimento.saleservice.analyze.service.AnalizeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/analize")
public class AnalizeController {

    private AnalizeService service;

    @GetMapping
    public Mono<AnalizeDTO> analize() {
        return service.analize().map(AnalizeMapper::mapToDTO);
    }
}
