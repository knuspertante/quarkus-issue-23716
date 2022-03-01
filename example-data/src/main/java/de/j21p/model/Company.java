package de.j21p.model;

import java.time.Instant;

public interface Company {

  String getId();

  void setId(String id);

  String getAddress();

  void setAddress(String address);

  String getName();

  void setName(String name);

  CompanyType getType();

  void setType(CompanyType type);

  String getTypname();

  Instant getUpdatedAt();

  Instant getCreatedAt();

  enum CompanyType {
    INSURANCE,
    BROKER
  }
}
