package de.j21p;

import de.j21p.filter.CompanyEnvironmentFilter;
import de.j21p.model.Company;
import de.j21p.services.CompanyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/{environment}/company")
public class CompanyResource {

  @Inject CompanyService companyService;

  @GET
  @Path("/{companyID}")
  @CompanyEnvironmentFilter // comment this line out native-build will work
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCompany(@PathParam("companyID") String id) {
    Company task = this.companyService.findByID(id);
    return Response.ok(task).build();
  }
}
