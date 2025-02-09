package com.adambahri.mypmtool.service;


import com.adambahri.mypmtool.domain.Contributor;
import com.adambahri.mypmtool.repository.ContributorRepository;
import com.adambahri.mypmtool.web.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContributorService {
    @Autowired
    private ContributorRepository contributorRepository;

    public List<Contributor> getAllContributors() {
        return contributorRepository.findAll();
    }

    public Contributor getContributorById(Long id) {
        return contributorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contributor not found with id " + id));
    }

    public Contributor createContributor(Contributor contributor) {
        contributor.setCreated(new Date());
        return contributorRepository.save(contributor);
    }

    public Contributor updateContributor(Long id, Contributor contributorDetails) {
        Contributor contributor = contributorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contributor not found with id " + id));
        contributor.setTeam(contributorDetails.getTeam());
        contributor.setMemberId(contributorDetails.getMemberId());
        contributor.setUserToken(contributorDetails.getUserToken());
        contributor.setBotToken(contributorDetails.getBotToken());
        contributor.setCreated(new Date());
        return contributorRepository.save(contributor);
    }

    @Transactional
    public void deleteContributor(Long id) {
        contributorRepository.deleteById(id);
    }
}