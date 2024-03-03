package com.bootcampProject.business.concretes;

import com.bootcampProject.business.abstracts.BlackListService;
import com.bootcampProject.business.constants.BlackListMessages;
import com.bootcampProject.business.requests.create.blackList.CreateBlackListRequest;
import com.bootcampProject.business.responses.create.blackList.CreateBlackListResponse;
import com.bootcampProject.business.responses.get.blackList.GetAllBlackListResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.ErrorDataResult;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.dataAccess.abstracts.BlackListRepository;
import com.bootcampProject.entities.concretes.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service//anatasyon denir
public class BlackListManager implements BlackListService {

    private final BlackListRepository blackListRepository;
    private final ModelMapperService mapperService;

    @Autowired
    public BlackListManager(BlackListRepository blackListRepository, ModelMapperService mapperService) {
        this.blackListRepository = blackListRepository;
        this.mapperService = mapperService;
    }

    @Override
    public DataResult<CreateBlackListResponse> add(CreateBlackListRequest request) {
        return null;
    }

    @Override
    public DataResult<Void> delete(int id) {
        blackListRepository.deleteById(id);
        return new SuccessDataResult<>(null, BlackListMessages.blackListDeleted);
    }

    @Override
    public DataResult<Void> update(CreateBlackListRequest request) {
        return null;
    }

    @Override
    public DataResult<GetAllBlackListResponse> createBlackList(CreateBlackListRequest request) {
        BlackList blackListEntry = mapperService.forRequest().map(request, BlackList.class);
        blackListEntry.setDate(LocalDate.now());
        BlackList savedEntry = blackListRepository.save(blackListEntry);
        GetAllBlackListResponse response = mapperService.forResponse().map(savedEntry, GetAllBlackListResponse.class);
        return new SuccessDataResult<>(response, "Blacklist entry created successfully.");
    }

    @Override
    public DataResult<List<GetAllBlackListResponse>> getAll() {
        List<BlackList> blackListEntries = blackListRepository.findAll();
        List<GetAllBlackListResponse> responses = blackListEntries.stream()
                .map(entry -> mapperService.forResponse().map(entry, GetAllBlackListResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, "All blacklist entries listed successfully.");
    }

    @Override
    public DataResult<GetAllBlackListResponse> getById(int id) {
        Optional<BlackList> blackListOpt = blackListRepository.findById(id);
        if (blackListOpt.isPresent()) {
            GetAllBlackListResponse response = mapperService.forResponse().map(blackListOpt.get(), GetAllBlackListResponse.class);
            return new SuccessDataResult<>(response, "Blacklist entry found.");
        } else {
            return new ErrorDataResult<>("Blacklist entry not found with id: " + id);
        }
    }



}