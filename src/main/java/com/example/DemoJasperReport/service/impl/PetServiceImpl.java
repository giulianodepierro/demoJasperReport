package com.example.DemoJasperReport.service.impl;

import com.example.DemoJasperReport.model.Pet;
import com.example.DemoJasperReport.repository.PetRepository;
import com.example.DemoJasperReport.service.PetService;
import com.example.DemoJasperReport.util.PetReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetReportGenerator petReportGenerator;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return petReportGenerator.exportToPdf(petRepository.findAll());
    }

    @Override
    public byte[] exportXls() throws JRExcept, FileNotFoundException {
        return petReportGenerator.exportToXls(petRepository.findAll());
    }
}
