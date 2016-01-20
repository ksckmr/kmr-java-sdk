
package com.kingsoft.services.kmr;

import com.kingsoft.services.auth.KSCCredentials;
import com.kingsoft.services.handlers.AsyncHandler;
import com.kingsoft.services.kmr.model.*;


public class KSCMapReduceAsyncClient extends
        KSCMapReduceClient implements KSCMapReduceAsync {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    private final java.util.concurrent.ExecutorService executorService;


    public KSCMapReduceAsyncClient(String endpoint, KSCCredentials credentials,
            com.kingsoft.services.ClientOptions clientConfiguration) {
        this(endpoint, credentials,
                clientConfiguration, java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }


    public KSCMapReduceAsyncClient(String endpoint, KSCCredentials credentials) {
        this(endpoint,credentials, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    public KSCMapReduceAsyncClient(String endpoint, KSCCredentials credentials,
            java.util.concurrent.ExecutorService executorService) {

        this(endpoint, credentials, new com.kingsoft.services.ClientOptions(),
                executorService);
    }

    public KSCMapReduceAsyncClient(
            String endpoint, KSCCredentials credentials,
            com.kingsoft.services.ClientOptions clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(endpoint, credentials, clientConfiguration);
        this.executorService = executorService;
    }



    @Override
    public java.util.concurrent.Future<AddJobFlowStepsResult> addJobFlowStepsAsync(
            AddJobFlowStepsRequest request) {

        return addJobFlowStepsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AddJobFlowStepsResult> addJobFlowStepsAsync(
            final AddJobFlowStepsRequest request,
            final AsyncHandler<AddJobFlowStepsRequest, AddJobFlowStepsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<AddJobFlowStepsResult>() {
                    @Override
                    public AddJobFlowStepsResult call() throws Exception {
                        AddJobFlowStepsResult result;

                        try {
                            result = addJobFlowSteps(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeClusterResult> describeClusterAsync(
            DescribeClusterRequest request) {

        return describeClusterAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeClusterResult> describeClusterAsync(
            final DescribeClusterRequest request,
            final AsyncHandler<DescribeClusterRequest, DescribeClusterResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeClusterResult>() {
                    @Override
                    public DescribeClusterResult call() throws Exception {
                        DescribeClusterResult result;

                        try {
                            result = describeCluster(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }



    @Override
    public java.util.concurrent.Future<DescribeStepResult> describeStepAsync(
            DescribeStepRequest request) {

        return describeStepAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeStepResult> describeStepAsync(
            final DescribeStepRequest request,
            final AsyncHandler<DescribeStepRequest, DescribeStepResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeStepResult>() {
                    @Override
                    public DescribeStepResult call() throws Exception {
                        DescribeStepResult result;

                        try {
                            result = describeStep(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }


    @Override
    public java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            ListClustersRequest request) {

        return listClustersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            final ListClustersRequest request,
            final AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListClustersResult>() {
                    @Override
                    public ListClustersResult call() throws Exception {
                        ListClustersResult result;

                        try {
                            result = listClusters(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }


    @Override
    public java.util.concurrent.Future<ListClustersResult> listClustersAsync() {

        return listClustersAsync(new ListClustersRequest());
    }


    public java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler) {

        return listClustersAsync(new ListClustersRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListInstanceGroupsResult> listInstanceGroupsAsync(
            ListInstanceGroupsRequest request) {

        return listInstanceGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListInstanceGroupsResult> listInstanceGroupsAsync(
            final ListInstanceGroupsRequest request,
            final AsyncHandler<ListInstanceGroupsRequest, ListInstanceGroupsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListInstanceGroupsResult>() {
                    @Override
                    public ListInstanceGroupsResult call() throws Exception {
                        ListInstanceGroupsResult result;

                        try {
                            result = listInstanceGroups(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ListInstancesResult> listInstancesAsync(
            ListInstancesRequest request) {

        return listInstancesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListInstancesResult> listInstancesAsync(
            final ListInstancesRequest request,
            final AsyncHandler<ListInstancesRequest, ListInstancesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListInstancesResult>() {
                    @Override
                    public ListInstancesResult call() throws Exception {
                        ListInstancesResult result;

                        try {
                            result = listInstances(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ListStepsResult> listStepsAsync(
            ListStepsRequest request) {

        return listStepsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListStepsResult> listStepsAsync(
            final ListStepsRequest request,
            final AsyncHandler<ListStepsRequest, ListStepsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListStepsResult>() {
                    @Override
                    public ListStepsResult call() throws Exception {
                        ListStepsResult result;

                        try {
                            result = listSteps(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<Void> modifyInstanceGroupsAsync(
            ModifyInstanceGroupsRequest request) {

        return modifyInstanceGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Void> modifyInstanceGroupsAsync(
            final ModifyInstanceGroupsRequest request,
            final AsyncHandler<ModifyInstanceGroupsRequest, Void> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        Void result;

                        try {
                            modifyInstanceGroups(request);
                            result = null;
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }


    public java.util.concurrent.Future<Void> modifyInstanceGroupsAsync(
            AsyncHandler<ModifyInstanceGroupsRequest, Void> asyncHandler) {

        return modifyInstanceGroupsAsync(new ModifyInstanceGroupsRequest(),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<RunJobFlowResult> runJobFlowAsync(
            RunJobFlowRequest request) {

        return runJobFlowAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<RunJobFlowResult> runJobFlowAsync(
            final RunJobFlowRequest request,
            final AsyncHandler<RunJobFlowRequest, RunJobFlowResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<RunJobFlowResult>() {
                    @Override
                    public RunJobFlowResult call() throws Exception {
                        RunJobFlowResult result;

                        try {
                            result = runJobFlow(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<Void> setTerminationProtectionAsync(
            SetTerminationProtectionRequest request) {

        return setTerminationProtectionAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Void> setTerminationProtectionAsync(
            final SetTerminationProtectionRequest request,
            final AsyncHandler<SetTerminationProtectionRequest, Void> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        Void result;

                        try {
                            setTerminationProtection(request);
                            result = null;
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }


    @Override
    public java.util.concurrent.Future<Void> terminateJobFlowsAsync(
            TerminateJobFlowsRequest request) {

        return terminateJobFlowsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Void> terminateJobFlowsAsync(
            final TerminateJobFlowsRequest request,
            final AsyncHandler<TerminateJobFlowsRequest, Void> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        Void result;

                        try {
                            terminateJobFlows(request);
                            result = null;
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call {@code getExecutorService().shutdown()} followed by
     * {@code getExecutorService().awaitTermination()} prior to calling this
     * method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
}
