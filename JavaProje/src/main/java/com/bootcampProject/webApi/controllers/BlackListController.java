package com.bootcampProject.webApi.controllers;

import com.bootcampProject.business.abstracts.BlackListService;
import com.bootcampProject.business.requests.create.blackList.CreateBlackListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklist")
public class BlackListController extends BaseController {

    private final BlackListService blackListService;

    @Autowired
    public BlackListController(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBlackListEntry(@RequestBody CreateBlackListRequest request) {
        return handleDataResult(blackListService.add(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBlackListEntryById(@PathVariable int id) {
        return handleDataResult(blackListService.getById(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllBlackListEntries() {
        return handleDataResult(blackListService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBlackListEntry(@RequestBody CreateBlackListRequest request) {
        return handleDataResult(blackListService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlackListEntry(@PathVariable int id) {
        return handleDataResult(blackListService.delete(id));
    }

   /* @GetMapping("/sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto) {
        return handleDataResult(blackListService.getAllPage(pageDto));
    }*/
}
