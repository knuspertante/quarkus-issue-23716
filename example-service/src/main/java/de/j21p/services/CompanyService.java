/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package de.j21p.services;

import de.j21p.model.Company;
import de.j21p.repository.CompanyRepository;
import de.j21p.repository.aws.CompanyRepositoryAws;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author JohannesSummerer
 */
@ApplicationScoped
public class CompanyService {

  private final CompanyRepository repository;

  String region = ConfigProvider.getConfig().getValue("dynamodb.region", String.class);

  public CompanyService() {
    this.repository = new CompanyRepositoryAws(region);
  }

  public Company createItem() {
    return this.repository.createCompany();
  }

  public Company findByID(String id) {
    return this.repository.findByID(id);
  }

  public Company putItem(Company company) {
    return this.repository.put(company);
  }
}
