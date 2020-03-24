package com.oldmutualnigeria.lifeinsurance.service;

import com.oldmutualnigeria.lifeinsurance.model.LifeInsuranceCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class LifeInsuranceCustomerServiceImplTest {

//    @Autowired
    LifeInsuranceCustomerServiceImpl lifeInsuranceCustomerServiceImpl;

    ReadExcelFileService readExcelFileService;

    @BeforeEach
    void setUp() throws IOException {

        readExcelFileService = new ReadExcelFileService();
        readExcelFileService.setWorkBook("src/main/resources/TermAssuranceModel.xlsx");
        lifeInsuranceCustomerServiceImpl = new LifeInsuranceCustomerServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculatePremiumAmount() {
    }

    @Test
    void setCustomerLookUpDetailsTest01() {

        LifeInsuranceCustomer lifeInsuranceCustomer = new LifeInsuranceCustomer();
        lifeInsuranceCustomer.setCashBack("Yes");
        lifeInsuranceCustomer.setEscalation("No");
        lifeInsuranceCustomer.setGender("Male");
        lifeInsuranceCustomer.setTermOfCover(3);
        lifeInsuranceCustomer.setAge(43);
        String details = lifeInsuranceCustomerServiceImpl.getCustomerLookUpDetails(lifeInsuranceCustomer);
        assertThat(details).isEqualTo("UntestedNo EscalationCash BackMale43");

        System.out.println(details);
    }

    @Test
    void setCustomerLookUpDetailsTest02() {

        LifeInsuranceCustomer lifeInsuranceCustomer = new LifeInsuranceCustomer();
        lifeInsuranceCustomer.setCashBack("No");
        lifeInsuranceCustomer.setEscalation("No");
        lifeInsuranceCustomer.setGender("Male");
        lifeInsuranceCustomer.setTermOfCover(3);
        lifeInsuranceCustomer.setAge(43);

        String details = lifeInsuranceCustomerServiceImpl.getCustomerLookUpDetails(lifeInsuranceCustomer);

        assertThat(details).isEqualTo("UntestedNo EscalationNon Cash BackMale43");

        System.out.println(details.toString());
    }

    @Test
    void setCustomerLookUpDetailsTest03() {

        LifeInsuranceCustomer lifeInsuranceCustomer = new LifeInsuranceCustomer();
        lifeInsuranceCustomer.setCashBack("Yes");
        lifeInsuranceCustomer.setEscalation("Yes");
        lifeInsuranceCustomer.setGender("Male");
        lifeInsuranceCustomer.setTermOfCover(3);
        lifeInsuranceCustomer.setAge(43);

        String details = lifeInsuranceCustomerServiceImpl.getCustomerLookUpDetails(lifeInsuranceCustomer);

        assertThat(details).isEqualTo("UntestedEscalationCash BackMale43");

        System.out.println(details.toString());
    }

    @Test
    void setCustomerLookUpDetailsTest04() {

        LifeInsuranceCustomer lifeInsuranceCustomer = new LifeInsuranceCustomer();
        lifeInsuranceCustomer.setCashBack("No");
        lifeInsuranceCustomer.setEscalation("Yes");
        lifeInsuranceCustomer.setGender("Male");
        lifeInsuranceCustomer.setTermOfCover(3);
        lifeInsuranceCustomer.setAge(43);

//        lifeInsuranceCustomerServiceImpl.getCustomerLookUpDetails();

        String details = lifeInsuranceCustomerServiceImpl.getCustomerLookUpDetails(lifeInsuranceCustomer);

        assertThat(details).isEqualTo("UntestedEscalationNon Cash BackMale43");

        System.out.println(details.toString());
    }



    @Test
    void getPremiumAmountTest() throws IOException {

        LifeInsuranceCustomer lifeInsuranceCustomer = new LifeInsuranceCustomer();
        lifeInsuranceCustomer.setCashBack("No");
        lifeInsuranceCustomer.setEscalation("No");
        lifeInsuranceCustomer.setGender("Female");
        lifeInsuranceCustomer.setTermOfCover(7);
        lifeInsuranceCustomer.setAge(64);
        lifeInsuranceCustomer.setSumAssured(5_000_000);

        lifeInsuranceCustomerServiceImpl.setReadExcelFileService(readExcelFileService);

        Double result = lifeInsuranceCustomerServiceImpl.calculatePremiumAmount(lifeInsuranceCustomer);

        assertThat(result).isEqualTo(19450.00);

        System.out.println(result);
    }



}