
package com.kingsoft.services.kmr;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.handlers.AsyncHandler;

public interface KSCMapReduceAsync extends KSCMapReduce {



    java.util.concurrent.Future<AddJobFlowStepsResult> addJobFlowStepsAsync(
            AddJobFlowStepsRequest addJobFlowStepsRequest);


    java.util.concurrent.Future<AddJobFlowStepsResult> addJobFlowStepsAsync(
            AddJobFlowStepsRequest addJobFlowStepsRequest,
            com.kingsoft.services.handlers.AsyncHandler<AddJobFlowStepsRequest, AddJobFlowStepsResult> asyncHandler);


    java.util.concurrent.Future<DescribeClusterResult> describeClusterAsync(
            DescribeClusterRequest describeClusterRequest);


    java.util.concurrent.Future<DescribeClusterResult> describeClusterAsync(
            DescribeClusterRequest describeClusterRequest,
            AsyncHandler<DescribeClusterRequest, DescribeClusterResult> asyncHandler);

    java.util.concurrent.Future<DescribeStepResult> describeStepAsync(
            DescribeStepRequest describeStepRequest);


    java.util.concurrent.Future<DescribeStepResult> describeStepAsync(
            DescribeStepRequest describeStepRequest,
            AsyncHandler<DescribeStepRequest, DescribeStepResult> asyncHandler);


    java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            ListClustersRequest listClustersRequest);


    java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            ListClustersRequest listClustersRequest,
            AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler);


    java.util.concurrent.Future<ListClustersResult> listClustersAsync();


    java.util.concurrent.Future<ListClustersResult> listClustersAsync(
            AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler);


    java.util.concurrent.Future<ListInstanceGroupsResult> listInstanceGroupsAsync(
            ListInstanceGroupsRequest listInstanceGroupsRequest);

    java.util.concurrent.Future<ListInstanceGroupsResult> listInstanceGroupsAsync(
            ListInstanceGroupsRequest listInstanceGroupsRequest,
            AsyncHandler<ListInstanceGroupsRequest, ListInstanceGroupsResult> asyncHandler);


    java.util.concurrent.Future<ListInstancesResult> listInstancesAsync(
            ListInstancesRequest listInstancesRequest);

    java.util.concurrent.Future<ListInstancesResult> listInstancesAsync(
            ListInstancesRequest listInstancesRequest,
            AsyncHandler<ListInstancesRequest, ListInstancesResult> asyncHandler);

    java.util.concurrent.Future<ListStepsResult> listStepsAsync(
            ListStepsRequest listStepsRequest);

    java.util.concurrent.Future<ListStepsResult> listStepsAsync(
            ListStepsRequest listStepsRequest,
            AsyncHandler<ListStepsRequest, ListStepsResult> asyncHandler);

    java.util.concurrent.Future<Void> modifyInstanceGroupsAsync(
            ModifyInstanceGroupsRequest modifyInstanceGroupsRequest);

    java.util.concurrent.Future<Void> modifyInstanceGroupsAsync(
            ModifyInstanceGroupsRequest modifyInstanceGroupsRequest,
            AsyncHandler<ModifyInstanceGroupsRequest, Void> asyncHandler);


    java.util.concurrent.Future<RunJobFlowResult> runJobFlowAsync(
            RunJobFlowRequest runJobFlowRequest);

    java.util.concurrent.Future<RunJobFlowResult> runJobFlowAsync(
            RunJobFlowRequest runJobFlowRequest,
            AsyncHandler<RunJobFlowRequest, RunJobFlowResult> asyncHandler);

    java.util.concurrent.Future<Void> setTerminationProtectionAsync(
            SetTerminationProtectionRequest setTerminationProtectionRequest);

    java.util.concurrent.Future<Void> setTerminationProtectionAsync(
            SetTerminationProtectionRequest setTerminationProtectionRequest,
            AsyncHandler<SetTerminationProtectionRequest, Void> asyncHandler);

    java.util.concurrent.Future<Void> terminateJobFlowsAsync(
            TerminateJobFlowsRequest terminateJobFlowsRequest);


    java.util.concurrent.Future<Void> terminateJobFlowsAsync(
            TerminateJobFlowsRequest terminateJobFlowsRequest,
            AsyncHandler<TerminateJobFlowsRequest, Void> asyncHandler);

}
