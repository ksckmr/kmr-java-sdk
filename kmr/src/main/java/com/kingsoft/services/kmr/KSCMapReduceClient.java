/*
 * Copyright (c) 2015 KingSoft.com, Inc. All Rights Reserved
 *
 */

package com.kingsoft.services.kmr;

import java.util.ArrayList;
import java.util.List;

import com.kingsoft.services.http.HttpMethodName;
import com.kingsoft.services.http.IKSCHttpClient;
import com.kingsoft.services.kmr.handlers.JsonErrorResponseHandler;
import com.kingsoft.services.http.JsonResponseHandler;
import com.kingsoft.services.http.KSCHttpClient;
import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.JsonErrorUnmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kingsoft.services.KSCWebServiceClient;
import com.kingsoft.services.auth.KSCCredentials;
import com.kingsoft.services.ClientOptions;
import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.ResponseMessage;
import com.kingsoft.services.handlers.HttpResponseHandler;

import com.kingsoft.services.kmr.transform.*;

/**
 * KMR client
 */
public class KSCMapReduceClient extends KSCWebServiceClient
        implements KSCMapReduce {

    private KSCCredentials credentials;

    private static final Log log = LogFactory.getLog(KSCMapReduce.class);

    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();


    /**
     * 使用指定的endpoint、证书信息和默认配置构造一个新的{@link KSCMapReduceClient}实例
     * @param endpoint
     *          KMR服务endpoint
     * @param kscCredentials
     *          访问KMR服务的证书
     */
    public KSCMapReduceClient(String endpoint, KSCCredentials kscCredentials) {
        this(endpoint, kscCredentials, new ClientOptions());
    }

    /**
     * 使用指定的Endpoint、证书信息和配置构造一个新的{@link KSCMapReduceClient}实例
     * @param endpoint KMR服务的endpoint
     * @param credentials 访问KMR服务的证书
     * @param options 配置参数
     */
    public KSCMapReduceClient(String endpoint, KSCCredentials credentials,
                          ClientOptions options) {
        this(endpoint, credentials, options, new KSCHttpClient(options));
    }

    protected KSCMapReduceClient(String endpoint, KSCCredentials credentials,
                             ClientOptions options, IKSCHttpClient client) {
        super(endpoint, options, client);
        this.credentials = credentials;
    }

    private <X> ResponseMessage<X> invoke(
            RequestMessage<?> msg,
            HttpResponseHandler<ResponseMessage<X>> responseHandler) {
        msg.setEndpoint(endpoint);
        msg.setCredentials(this.credentials);
        msg.setHttpMethod(HttpMethodName.POST);
        //msg.setServiceName("com.kingsoft.services.KMR");
        msg.setServiceName("");


        //assert (msg.getResponseMeesageType() != null);
        assert (msg.getResourcePath() != null);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(
                jsonErrorUnmarshallers);
        return client.execute(msg, responseHandler, errorResponseHandler);


    }


    @Override
    public RunJobFlowResult runJobFlow(RunJobFlowRequest runJobFlowRequest) {

        RequestMessage<RunJobFlowRequest> request = null;
        ResponseMessage<RunJobFlowResult> response = null;



        request = new RunJobFlowRequestMarshaller()
                .marshall(runJobFlowRequest);

        JsonResponseHandler<RunJobFlowResult> responseHandler = new JsonResponseHandler<RunJobFlowResult>(
                new RunJobFlowResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = (ResponseMessage<RunJobFlowResult>) invoke(request, responseHandler);

        return response.getContent();
    }

    @Override
    public AddJobFlowStepsResult addJobFlowSteps(
            AddJobFlowStepsRequest addJobFlowStepsRequest) {

        RequestMessage<AddJobFlowStepsRequest> request = null;
        ResponseMessage<AddJobFlowStepsResult> response = null;


        request = new AddJobFlowStepsRequestMarshaller()
                .marshall(addJobFlowStepsRequest);


        JsonResponseHandler<AddJobFlowStepsResult> responseHandler = new JsonResponseHandler<AddJobFlowStepsResult>(
                new AddJobFlowStepsResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }


    @Override
    public DescribeClusterResult describeCluster(
            DescribeClusterRequest describeClusterRequest) {

        RequestMessage<DescribeClusterRequest> request = null;
        ResponseMessage<DescribeClusterResult> response = null;

        request = new DescribeClusterRequestMarshaller()
                .marshall(describeClusterRequest);

        JsonResponseHandler<DescribeClusterResult> responseHandler = new JsonResponseHandler<DescribeClusterResult>(
                new DescribeClusterResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }

    @Override
    public DescribeStepResult describeStep(
            DescribeStepRequest describeStepRequest) {

        RequestMessage<DescribeStepRequest> request = null;
        ResponseMessage<DescribeStepResult> response = null;

        request = new DescribeStepRequestMarshaller()
                .marshall(describeStepRequest);


        JsonResponseHandler<DescribeStepResult> responseHandler = new JsonResponseHandler<DescribeStepResult>(
                new DescribeStepResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }



    @Override
    public ListClustersResult listClusters(
            ListClustersRequest listClustersRequest) {

        RequestMessage<ListClustersRequest> request = null;
        ResponseMessage<ListClustersResult> response = null;

        request = new ListClustersRequestMarshaller()
                        .marshall(listClustersRequest);

        JsonResponseHandler<ListClustersResult> responseHandler = new JsonResponseHandler<ListClustersResult>(
                new ListClustersResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }

    @Override
    public ListClustersResult listClusters() {
        return listClusters(new ListClustersRequest());
    }

    @Override
    public ListInstanceGroupsResult listInstanceGroups(
            ListInstanceGroupsRequest listInstanceGroupsRequest) {

        RequestMessage<ListInstanceGroupsRequest> request = null;
        ResponseMessage<ListInstanceGroupsResult> response = null;


        request = new ListInstanceGroupsRequestMarshaller()
                        .marshall(listInstanceGroupsRequest);


        JsonResponseHandler<ListInstanceGroupsResult> responseHandler = new JsonResponseHandler<ListInstanceGroupsResult>(
                    new ListInstanceGroupsResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }


    @Override
    public ListInstancesResult listInstances(
            ListInstancesRequest listInstancesRequest) {

        RequestMessage<ListInstancesRequest> request = null;
        ResponseMessage<ListInstancesResult> response = null;


        request = new ListInstancesRequestMarshaller()
                .marshall(listInstancesRequest);


        JsonResponseHandler<ListInstancesResult> responseHandler = new JsonResponseHandler<ListInstancesResult>(
                new ListInstancesResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);

        return response.getContent();

    }

    @Override
    public ListStepsResult listSteps(ListStepsRequest listStepsRequest) {

        RequestMessage<ListStepsRequest> request = null;
        ResponseMessage<ListStepsResult> response = null;

        request = new ListStepsRequestMarshaller()
                        .marshall(listStepsRequest);

        JsonResponseHandler<ListStepsResult> responseHandler = new JsonResponseHandler<ListStepsResult>(
                    new ListStepsResultJsonUnmarshaller());
        responseHandler.setIsPayloadJson(true);
        response = invoke(request, responseHandler);
        return response.getContent();
    }

   @Override
    public void modifyInstanceGroups(
            ModifyInstanceGroupsRequest modifyInstanceGroupsRequest) {

        RequestMessage<ModifyInstanceGroupsRequest> request = null;
        ResponseMessage<Void> response = null;


       request = new ModifyInstanceGroupsRequestMarshaller()
                        .marshall(modifyInstanceGroupsRequest);


       JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(
                    null);
       responseHandler.setIsPayloadJson(true);
       invoke(request, responseHandler);

    }


   @Override
    public void setTerminationProtection(
            SetTerminationProtectionRequest setTerminationProtectionRequest) {

        RequestMessage<SetTerminationProtectionRequest> request = null;
        ResponseMessage<Void> response = null;


                request = new SetTerminationProtectionRequestMarshaller()
                        .marshall(setTerminationProtectionRequest);


            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(
                    null);
            responseHandler.setIsPayloadJson(true);
            invoke(request, responseHandler);

    }

    @Override
    public void terminateJobFlows(
            TerminateJobFlowsRequest terminateJobFlowsRequest) {

        RequestMessage<TerminateJobFlowsRequest> request = null;
        ResponseMessage<Void> response = null;

                request = new TerminateJobFlowsRequestMarshaller()
                        .marshall(terminateJobFlowsRequest);


            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(
                    null);
            responseHandler.setIsPayloadJson(true);
            invoke(request, responseHandler);


    }

}
