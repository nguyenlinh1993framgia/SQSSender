package com.framgia.sqssender.resource;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.QueueAttributeName;
import com.framgia.sqssender.dto.BaseDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {
    @POST
    @Path("/create-message")
    public Response createMessage() {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setMessage("Test API");
        baseDTO.setStatus(true);

        //Create queue message
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        final CreateQueueRequest createQueueRequest = new CreateQueueRequest()
                .withQueueName("DemoSQS")
                .addAttributesEntry(QueueAttributeName.ReceiveMessageWaitTimeSeconds
                        .toString(), "Demo SQS Message");

        try {
            sqs.createQueue(createQueueRequest);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }

        return Response.ok(baseDTO).build();
    }
}
