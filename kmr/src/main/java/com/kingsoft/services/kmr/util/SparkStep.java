
package com.kingsoft.services.kmr.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingsoft.services.kmr.model.Additional;
import com.kingsoft.services.kmr.model.HadoopJarStepConfig;

/**
 * Class that makes it easy to define Hadoop Streaming steps.
 * <pre class="brush: java">
 * KSCCredentials credentials = new BasicKSCCredentials(accessKey, secretKey);
 * KSCMapReduceClient kmr = new KSCMapReduceClient(endpoint, credentials);
 *
 * HadoopJarStepConfig config = new SparkStep()
 *     .withSubmitArgs("--executor-memory","521m","--num-executors","1")
 *     .toHadoopJarStepConfig()
 *     .withArgs("ks3://kmrhkbj/kmr-test/spark/wordcount/input",
 *               "ks3://kmrhkbj/kmr-test/spark/wordcount/output")
 *     .withMainJar("ks3://kmrhkbj/kmr-test/job/binaries/spark_wordcount_2.10-1.0.jar")
 *     .withMainClass("org.ksc.WordCount");
 *
 * StepConfig wordCount = new StepConfig()
 *     .withName("WordCount")
 *     .withActionOnFailure("TERMINATE_JOB_FLOW")
 *     .withHadoopJarStep(config);
 *
 * RunJobFlowRequest request = new RunJobFlowRequest()
 *     .withName("WordCount")
 *     .withSteps(wordCount)
 *     .withLogUri("ks3://kmrhkbj/kmr-test/log")
 *     .withInstances(new JobFlowInstancesConfig()
 *           .withKeepJobFlowAliveWhenNoSteps(true)
 *           .withInstanceGroups(
 *               new InstanceGroupConfig()
 *                   .withInstanceRole("MASTER")
 *                   .withInstanceCount(1)
 *                  .withInstanceType("kmr.general"),
 *              new InstanceGroupConfig()
 *                  .withInstanceType("kmr.general")
 *                  .withInstanceCount(5)
 *                  .withInstanceRole("CORE")
 *          ));
 *
 * RunJobFlowResult result = kmr.runJobFlow(request);
 * </pre>
 */
public class SparkStep {

  private List<String> submitArgs;

  /**
   * Creates a new default SparkStep.
   */
  public SparkStep() {
  }

  public java.util.List<String> getSubmitArgs() {
    if (submitArgs == null) {
      submitArgs = new ArrayList<String>();
    }
    return submitArgs;
  }

  public void setSubmitArgs(java.util.Collection<String> args) {
    if (args == null) {
      this.submitArgs = null;
      return;
    }

    this.submitArgs = new ArrayList<String>(args);
  }

  public SparkStep withSubmitArgs(String... args) {
    if (this.submitArgs == null) {
      setSubmitArgs(new ArrayList<String>(
              args.length));
    }
    for (String ele : args) {
      this.submitArgs.add(ele);
    }
    return this;
  }

  /**
   * Creates the final HadoopJarStepConfig once you are done configuring the step. You can use
   * this as you would any other HadoopJarStepConfig.
   * @return HadoopJarStepConfig representing this streaming step.
   */
  public HadoopJarStepConfig toHadoopJarStepConfig() {

    Additional additional = new Additional()
            .withArgs(this.submitArgs);

    return new HadoopJarStepConfig()
      .withJar("ks3://kmr/libs/spark.jar")
      .withAdditional(additional);
  }
}

