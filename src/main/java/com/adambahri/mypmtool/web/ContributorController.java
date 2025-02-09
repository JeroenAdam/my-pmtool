package com.adambahri.mypmtool.web;


import com.adambahri.mypmtool.domain.Contributor;
import com.adambahri.mypmtool.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributors")
public class ContributorController {
    @Autowired
    private ContributorService contributorService;

    @GetMapping
    public List<Contributor> getAllContributors() {
        return contributorService.getAllContributors();
    }

    @GetMapping("/{id}")
    public Contributor getContributorById(@PathVariable Long id) {
        return contributorService.getContributorById(id);
    }

    @PostMapping
    public Contributor createContributor(@RequestBody Contributor contributor) {
        return contributorService.createContributor(contributor);
    }

    @PutMapping("/{id}")
    public Contributor updateContributor(@PathVariable Long id, @RequestBody Contributor contributorDetails) {
        return contributorService.updateContributor(id, contributorDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContributor(@PathVariable Long id) {
        contributorService.deleteContributor(id);
        return ResponseEntity.noContent().build();
    }
}
