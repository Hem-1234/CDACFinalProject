package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Feedback;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

}
