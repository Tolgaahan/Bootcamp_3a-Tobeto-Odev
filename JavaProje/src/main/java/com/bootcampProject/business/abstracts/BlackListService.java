package com.bootcampProject.business.abstracts;


import com.bootcampProject.business.requests.create.blackList.CreateBlackListRequest;
import com.bootcampProject.business.responses.create.blackList.CreateBlackListResponse;
import com.bootcampProject.business.responses.get.blackList.GetAllBlackListResponse;
import com.bootcampProject.core.utilities.results.DataResult;


import java.util.List;

public interface BlackListService {

    DataResult<CreateBlackListResponse>add(CreateBlackListRequest request);
    DataResult<Void> delete(int id);
    DataResult<Void> update(CreateBlackListRequest request);
    DataResult<GetAllBlackListResponse> createBlackList(CreateBlackListRequest request);
    DataResult<List<GetAllBlackListResponse>> getAll();
    DataResult<GetAllBlackListResponse> getById(int id);
}
