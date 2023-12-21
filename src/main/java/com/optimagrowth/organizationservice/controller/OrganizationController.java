package com.optimagrowth.organizationservice.controller;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "v1/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService service;


    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
    @RolesAllowed({"ADMIN","USER"})
    public void updateOrganization(@PathVariable("organizationId") String id,
                                   @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RolesAllowed({"ADMIN"})
    public void deleteOrganization(@PathVariable("organizationId") String id,
                                   @RequestBody Organization organization) {
        service.delete(organization);
    }

}
