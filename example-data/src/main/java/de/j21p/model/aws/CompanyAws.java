package de.j21p.model.aws;

import de.j21p.model.Company;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Objects;

@DynamoDbBean
public class CompanyAws extends GenericRecord implements Company {

  private String id = "";
  private String address = "";
  private String name = "";
  private CompanyType type = CompanyType.BROKER;

  public CompanyAws() {
    super();
    setTypname("Company");
  }

  @Override
  @DynamoDbPartitionKey
  public String getId() {
    return this.id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getAddress() {
    return this.address;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public CompanyType getType() {
    return this.type;
  }

  @Override
  public void setType(CompanyType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyAws)) return false;
    if (!super.equals(o)) return false;
    CompanyAws that = (CompanyAws) o;
    return Objects.equals(getId(), that.getId())
        && Objects.equals(getAddress(), that.getAddress())
        && Objects.equals(getName(), that.getName())
        && getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getId(), getAddress(), getName(), getType());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CompanyAws{");
    sb.append("id='").append(id).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", type=").append(type);
    sb.append('}');
    return sb + " " + super.toString();
  }
}
