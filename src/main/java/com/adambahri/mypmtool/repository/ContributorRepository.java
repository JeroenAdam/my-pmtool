package com.adambahri.mypmtool.repository;
import com.adambahri.mypmtool.domain.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}