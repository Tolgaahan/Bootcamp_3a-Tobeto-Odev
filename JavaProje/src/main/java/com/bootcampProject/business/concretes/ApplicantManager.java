package com.bootcampProject.business.concretes;

import com.bootcampProject.business.abstracts.ApplicantService;
import com.bootcampProject.business.constants.ApplicantMessages;
import com.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.bootcampProject.business.responses.create.applicants.CreateApplicantResponse;
import com.bootcampProject.business.responses.get.applicants.GetAllApplicantResponse;
import com.bootcampProject.business.responses.get.applicants.GetApplicantResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.paging.PageDto;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.bootcampProject.entities.concretes.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantManager implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ModelMapperService mapperService;

    @Autowired
    public ApplicantManager(ApplicantRepository applicantRepository, ModelMapperService mapperService) {
        this.applicantRepository = applicantRepository;
        this.mapperService = mapperService;
    }

    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest request) {
        Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
        applicant.setCreatedDate(LocalDateTime.now());
        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse()
                .map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<>(response, ApplicantMessages.applicantAdded);
    }

    @Override
    public DataResult<Void> delete(int id) {
        applicantRepository.deleteById(id);
        return new SuccessDataResult<>(null, ApplicantMessages.applicantDeleted);
    }

    @Override
    public DataResult<Void> update(CreateApplicantRequest request) {
        int applicantId = request.getId();
        Applicant existingApplicant = applicantRepository.findById(applicantId).orElse(null);

        if (existingApplicant == null) {
            return new SuccessDataResult<>(null, ApplicantMessages.applicantNotFound);
        }
        mapperService.forRequest().map(request, existingApplicant);
        applicantRepository.save(existingApplicant);
        return new SuccessDataResult<>(null, ApplicantMessages.applicantUpdated);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();
        List<GetAllApplicantResponse> applicantResponses = applicants.stream()
                .map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(applicantResponses, ApplicantMessages.applicantsListed);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant applicant = applicantRepository.getById(id);
        GetApplicantResponse response = mapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<>(response, ApplicantMessages.applicantListed);
    }


    @Override
    public DataResult<List<GetApplicantResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Applicant> aplicants = applicantRepository.findAll(pageable);
        List<GetApplicantResponse> responses = aplicants.getContent().stream()
                .map(applicant -> mapperService.forResponse().map(applicant, GetApplicantResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }
}