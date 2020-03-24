package com.oldmutualnigeria.lifeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oldmutualnigeria.lifeinsurance.model.LifeInsuranceCustomer;

@Repository
public interface LifeInsuranceRepository extends JpaRepository<LifeInsuranceCustomer, Long> {

}
