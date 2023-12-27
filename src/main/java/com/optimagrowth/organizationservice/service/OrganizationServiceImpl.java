package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.events.model.ActionEnum;
import com.optimagrowth.organizationservice.events.source.SimpleSourceBean;
import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;

    private final SimpleSourceBean sourceBean;

    @Override
    public Organization findById(String organizationId) {
        Optional<Organization> optionalForOrganization = repository.findById(organizationId);
        return optionalForOrganization.orElse(null);
    }

    @Override
    public Organization create(Organization organization) {
        organization.setId(UUID.randomUUID().toString());
        organization = repository.save(organization);
        sourceBean.publicOrganizationChange(
                ActionEnum.CREATED.name(),
                organization.getId());
        return organization;
    }

    @Override
    public void update(Organization organization) {
        repository.save(organization);
    }

    @Override
    public void delete(Organization organization) {
        repository.deleteById(organization.getId());
    }
}