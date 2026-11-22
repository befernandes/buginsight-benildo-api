package com.buginsight.benildo.buginsight_benildo_api.service;

import com.buginsight.benildo.buginsight_benildo_api.entity.Bug;
import com.buginsight.benildo.buginsight_benildo_api.enums.BugStatus;
import com.buginsight.benildo.buginsight_benildo_api.repository.BugRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BugService {
    private final BugRepository bugRepository;
    
    public BugService (BugRepository bugRepository){
        this.bugRepository=bugRepository;
    }
    
    public Bug create(Bug bug){
        return bugRepository.save(bug);
    }

    public List<Bug> findAll(){
        return bugRepository.findAll();
    }

    public Bug findById(Long id){
        return bugRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Bug not found" + id));
    }

    public Bug updateStatus(Long id, BugStatus status){
        Bug bug = findById(id);
        bug.setStatus(status);
        return bugRepository.save(bug);
    }

    public void delete(Long id){
        Bug bug = findById(id);
        bugRepository.delete(bug);
    }
}
