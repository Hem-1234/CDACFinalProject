package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Assessment;

public interface IAssessmentRepository extends JpaRepository<Assessment, Long> {

}
