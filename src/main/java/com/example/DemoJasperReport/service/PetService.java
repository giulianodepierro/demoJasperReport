package com.example.DemoJasperReport.service;

import com.example.DemoJasperReport.model.Pet;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface PetService {
    List<Pet> findAll();
    Pet findById(Long id);
    Pet save(Pet pet);
    void deleteById(Long id);
    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;
}
