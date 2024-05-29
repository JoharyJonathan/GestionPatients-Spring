package com.example.demo.service;

import com.example.demo.model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    
    private final String filePath = "patients.json";
    private List<Patient> patients = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        loadPatients();
    }

    public List<Patient> getAllPatients()
    {
        return patients;
    }

    public Optional<Patient> getPatientById(long id)
    {
        return patients.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Patient createPatient(Patient patient)
    {
        patient.setId(patients.size() + 1);
        patients.add(patient);
        savePatients();
        return patient;
    }

    public Patient updatePatient(long id, Patient patientDetails)
    {
        Patient patient = getPatientById(id).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        patient.setNom(patientDetails.getNom());
        patient.setAge(patientDetails.getAge());
        patient.setDatedenaissance(patientDetails.getDatedenaissance());
        patient.setEmail(patientDetails.getEmail());
        patient.setGenre(patientDetails.getGenre());
        savePatients();
        return patient;
    }

    public void deletePatient(long id)
    {
        Patient patient = getPatientById(id).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        patients.remove(patient);
        savePatients();
    }

    private void loadPatients()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            patients = objectMapper.readValue(new File(filePath), new TypeReference<List<Patient>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePatients()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), patients);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
