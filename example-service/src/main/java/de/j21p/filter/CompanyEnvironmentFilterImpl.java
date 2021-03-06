package de.j21p.filter;

import de.j21p.model.Company;
import de.j21p.services.CompanyService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@CompanyEnvironmentFilter
@Priority(20)
public class CompanyEnvironmentFilterImpl implements ContainerRequestFilter {

  @Inject CompanyService companyService;

  private void validateCompanyEnvironmentRelation(
      ContainerRequestContext requestContext, String companyID) {

    String environment = requestContext.getUriInfo().getPathParameters().getFirst("environment");

    Company company = companyService.findByID(companyID);

    // Fake abort request
    requestContext.abortWith(Response.serverError().build());
  }

  /**
   * Filter method called before a request has been dispatched to a resource.
   *
   * <p>Filters in the filter chain are ordered according to their {@code javax.annotation.Priority}
   * class-level annotation value. If a request filter produces a response by calling {@link
   * ContainerRequestContext#abortWith} method, the execution of the (either pre-match or
   * post-match) request filter chain is stopped and the response is passed to the corresponding
   * response filter chain (either pre-match or post-match). For example, a pre-match caching filter
   * may produce a response in this way, which would effectively skip any post-match request filters
   * as well as post-match response filters. Note however that a responses produced in this manner
   * would still be processed by the pre-match response filter chain.
   *
   * @param requestContext request context.
   * @throws IOException if an I/O exception occurs.
   * @see PreMatching
   */
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    String companyID = requestContext.getUriInfo().getPathParameters().getFirst("companyID");
    validateCompanyEnvironmentRelation(requestContext, companyID);
  }
}
