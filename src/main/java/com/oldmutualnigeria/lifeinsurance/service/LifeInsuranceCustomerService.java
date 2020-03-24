package com.oldmutualnigeria.lifeinsurance.service;

import com.oldmutualnigeria.lifeinsurance.model.LifeInsuranceCustomer;

import java.io.IOException;
import java.util.List;

public interface LifeInsuranceCustomerService {

    public Double calculatePremiumAmount(LifeInsuranceCustomer lifeInsuranceCustomer) throws IOException;

    public String getCustomerLookUpDetails(LifeInsuranceCustomer lifeInsuranceCustomer);

}