package com.optimagrowth.organizationservice.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrganizationChangeModel {

    private String type;

    private String action;

    private String organizationId;

    private String correlationId;

}
