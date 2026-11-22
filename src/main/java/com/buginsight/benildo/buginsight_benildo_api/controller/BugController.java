package com.buginsight.benildo.buginsight_benildo_api.controller;

import com.buginsight.benildo.buginsight_benildo_api.dto.BugRequestDTO;
import com.buginsight.benildo.buginsight_benildo_api.dto.BugResponseDTO;
import com.buginsight.benildo.buginsight_benildo_api.dto.BugStatusUpdateDTO;
import com.buginsight.benildo.buginsight_benildo_api.entity.Bug;
import com.buginsight.benildo.buginsight_benildo_api.service.BugService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    private final BugService bugService;

    public BugController (BugService bugService){
        this.bugService=bugService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BugResponseDTO create (@Valid @RequestBody BugRequestDTO requestDTO){

        Bug bug = new Bug();
        bug.setTitle(requestDTO.title());
        bug.setDescription(requestDTO.description());
        bug.setStackTrace(requestDTO.stackTrace());
        bug.setSeverity(requestDTO.severity());

        return  toResponse(bugService.create(bug));
    }

    @GetMapping
    public List<BugResponseDTO> findAll(){
        return bugService.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public BugResponseDTO findById(@PathVariable Long id) {
        return toResponse(bugService.findById(id));
    }

    @PatchMapping("/{id}/status")
    public BugResponseDTO updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody BugStatusUpdateDTO request ){
        return toResponse(
                bugService.updateStatus(id, request.status())
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        bugService.delete(id);
    }

    private BugResponseDTO toResponse (Bug bug){
        return new BugResponseDTO(
                bug.getId(),
                bug.getTitle(),
                bug.getDescription(),
                bug.getStackTrace(),
                bug.getSeverity(),
                bug.getStatus(),
                bug.getAiAnalysis(),
                bug.getCreatedAt());
    }
}
