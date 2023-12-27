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
@RequestMapping("v1/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService service;

    @GetMapping(value = "/{organizationId}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @PutMapping(value = "/{organizationId}")
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

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RolesAllowed({"ADMIN"})
    public void deleteOrganization(@PathVariable("organizationId") String id,
                                   @RequestBody Organization organization) {
        service.delete(organization);
    }

}
