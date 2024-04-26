package com.clinicamedica.api.controller;

import com.clinicamedica.api.medico.DadosCadastroMedico;
import com.clinicamedica.api.medico.DadosListagemMedico;
import com.clinicamedica.api.medico.Medico;
import com.clinicamedica.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
