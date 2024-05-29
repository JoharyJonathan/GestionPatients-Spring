package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/new")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable long id, @ModelAttribute Patient patient) {
        patientService.updatePatient(id, patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
