package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository {

    void saveCompany(Company company);

    void updateCompany(Long id,Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompanyById(Long id);
}