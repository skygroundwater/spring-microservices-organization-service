package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.model.Organization;

public interface OrganizationService {
    Organization findById(String organizationId);

    Organization create(Organization organization);

    void update(Organization organization);

    void delete(Organization organization);
}
