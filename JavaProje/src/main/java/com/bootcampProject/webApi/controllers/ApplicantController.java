package com.bootcampProject.webApi.controllers;

import com.bootcampProject.business.abstracts.ApplicantService;
import com.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.bootcampProject.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//anatasyon denir
@RequestMapping("/api/applicants")
public class ApplicantController extends BaseController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplicant(@RequestBody CreateApplicantRequest request) {
        return handleDataResult(applicantService.add(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getApplicantById(@PathVariable int id) {
        return handleDataResult(applicantService.getById(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllApplicants() {
        return handleDataResult(applicantService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateApplicant(@RequestBody CreateApplicantRequest request) {
        return handleDataResult((DataResult<?>) applicantService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApplicant(@PathVariable int id) {
        return handleDataResult((DataResult<?>) applicantService.delete(id));
    }
}
