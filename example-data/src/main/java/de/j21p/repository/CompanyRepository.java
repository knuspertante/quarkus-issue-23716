package de.j21p.repository;

import de.j21p.model.Company;
import de.j21p.util.ValidationUtil;

public interface CompanyRepository {
  Company findByID(String id);

  Company put(Company company) throws ValidationUtil.ValidationException;

  Company createCompany();

  Company delete(String id);
}
