package com.oldmutualnigeria.lifeinsurance.service;

import com.oldmutualnigeria.lifeinsurance.model.LifeInsuranceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static java.lang.Integer.sum;
import static org.apache.commons.math3.analysis.FunctionUtils.multiply;


@Service
public class LifeInsuranceCustomerServiceImpl implements LifeInsuranceCustomerService {


    @Autowired
    ReadExcelFileService readExcelFileService;

    StringBuilder customerLookUpDetails = new StringBuilder();;

    private Integer sheetIndex = 1;

    private Integer columnLookUpIndex = 6;

    public void setReadExcelFileService(ReadExcelFileService readExcelFileService){
        this.readExcelFileService = readExcelFileService;
    }

    @Override
    public Double calculatePremiumAmount(LifeInsuranceCustomer lifeInsuranceCustomer) throws IOException {

        Double product = null;

        if(sum(lifeInsuranceCustomer.getAge(), lifeInsuranceCustomer.getTermOfCover()) > 76){

            return 0.0;
        }else{

            product= ((getLookUpValue(lifeInsuranceCustomer) / 1000) * lifeInsuranceCustomer.getSumAssured()) ;

            return product;

        }

    }

    public Double getLookUpValue(LifeInsuranceCustomer lifeInsuranceCustomer) throws IOException {

        Object rowNum = readExcelFileService.findValueInRows(this.sheetIndex,columnLookUpIndex,
                getCustomerLookUpDetails(lifeInsuranceCustomer));

        Integer cellIndex = (5+lifeInsuranceCustomer.getTermOfCover()+1);

        Object result = readExcelFileService.
                getCellValueByRowNum((Integer)rowNum, cellIndex,sheetIndex);

        return (Double)result;
    }


    @Override
    public String getCustomerLookUpDetails(LifeInsuranceCustomer lifeInsuranceCustomer){


        customerLookUpDetails.append("Untested");

        //customer escalation
        if(lifeInsuranceCustomer.getEscalation().equals("Yes")) {
            customerLookUpDetails.append("Escalation");
        }
        else if(lifeInsuranceCustomer.getEscalation().equals("No")){
            customerLookUpDetails.append("No Escalation");
        }

        //customer cashback value
        if(lifeInsuranceCustomer.getCashBack().equals("Yes")){
            customerLookUpDetails.append("Cash Back");
        }
        else if(lifeInsuranceCustomer.getCashBack().equals("No")){
            customerLookUpDetails.append("Non Cash Back");
        }

        //customer gender
        if(lifeInsuranceCustomer.getGender().equals("Male")){

            customerLookUpDetails.append("Male");
        }
        else if(lifeInsuranceCustomer.getGender().equals("Female")){
            customerLookUpDetails.append("Female");
        }

        customerLookUpDetails.append(lifeInsuranceCustomer.getAge());

        return customerLookUpDetails.toString();
    }

}
