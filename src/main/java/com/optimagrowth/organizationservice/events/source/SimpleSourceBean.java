package com.optimagrowth.organizationservice.events.source;

import com.optimagrowth.organizationservice.events.model.OrganizationChangeModel;
import com.optimagrowth.organizationservice.utils.usercontext.UserContext;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimpleSourceBean {

    private final CustomChannels source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);
    
    public void publicOrganizationChange(String action, String organizationId) {
        source.outboundOrg().send(
                MessageBuilder
                        .withPayload(
                                //_____________________
                                OrganizationChangeModel
                                        .builder()
                                        .type(OrganizationChangeModel.class.getTypeName())
                                        .action(action)
                                        .organizationId(organizationId)
                                        .correlationId(UserContext.getCorrelationId())
                                        .build())
                        //_____________________________
                        .build());

        logger.debug("Sending Kafka message {} for Organization Id: {}", action, organizationId);
    }

}
