package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Company;

import java.util.List;

public interface CompanyService {

    void saveCompany(Company company);

    void updateCompany(Long id,Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompanyById(Long id);

}
