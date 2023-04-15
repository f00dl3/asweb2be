package asweb2.backend.repository.Core;

import asweb2.backend.entity.Core.JobApplications2023;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplications2023Repository extends JpaRepository<JobApplications2023, Integer> {
}
