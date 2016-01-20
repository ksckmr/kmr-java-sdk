/*
 * Copyright (c) 2015 KingSoft.com, Inc. All Rights Reserved
 *
 */

package com.kingsoft.services.kmr;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.exception.KSCServiceException;

/**
 * KMR 接口.
 */

public interface KSCMapReduce {
    /**
     * 添加新的steps到一个正在运行的job flow.
     */
    AddJobFlowStepsResult addJobFlowSteps(
            AddJobFlowStepsRequest addJobFlowStepsRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 提供cluster的详细信息
     */
    DescribeClusterResult describeCluster(
            DescribeClusterRequest describeClusterRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 提供step的详细信息.
     */
    DescribeStepResult describeStep(DescribeStepRequest describeStepRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 列出当前账户可见的所有clusters,可配置筛选条件只列出符合条件的clusters
     * Todo:分页,一次只展示50 marker
     */
    ListClustersResult listClusters(ListClustersRequest listClustersRequest)
            throws KSCServiceException, KSCClientException;

    ListClustersResult listClusters()
            throws KSCServiceException, KSCClientException;

    /**
     * 列出cluster中所有instancegroups的详细信息
     */
    ListInstanceGroupsResult listInstanceGroups(
            ListInstanceGroupsRequest listInstanceGroupsRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 列出cluster中的instance信息
     */
    ListInstancesResult listInstances(ListInstancesRequest listInstancesRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 列出cluster中的steps信息
     */
    ListStepsResult listSteps(ListStepsRequest listStepsRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 修改instancegroups的大小,可增加或减少node数量.
     * request参数中包含group id以及修改后该group中instance的个数
     */
    void modifyInstanceGroups(
            ModifyInstanceGroupsRequest modifyInstanceGroupsRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 创建cluster,如果requst参数中有设置需要执行的job flow,则会在创建完cluster后运行job flow.
     * KeepJobFlowAliveWhenNoSteps参数设置为True,则cluster执行完job flow后不会被销毁.
     * TerminationProtected参数设置为True,则该cluster不能被销毁,除非重新设置该cluster的TerminationProtected为False.
     */
      RunJobFlowResult runJobFlow(RunJobFlowRequest runJobFlowRequest)
              throws KSCServiceException, KSCClientException;

    /**
     * 可通过该接口设置TerminationProtected参数
     */
    void setTerminationProtection(
            SetTerminationProtectionRequest setTerminationProtectionRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 停止job flow的运行,销毁cluster,将日志传送到KS3
     */
    void terminateJobFlows(TerminateJobFlowsRequest terminateJobFlowsRequest)
            throws KSCServiceException, KSCClientException;

    /**
     * 关闭client对象,释放资源.关闭后不能再   执行任何操作.
     */
    void shutdown();
}
