
package com.kingsoft.services.kmr.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingsoft.services.kmr.model.HadoopJarStepConfig;

/**
 * Class that makes it easy to define Hadoop Streaming steps.
 * <pre class="brush: java">
 * KSCCredentials credentials = new BasicKSCCredentials(accessKey, secretKey);
 * KSCMapReduceClient kmr = new KSCMapReduceClient(endpoint, credentials);
 *
 * HadoopJarStepConfig config = new HiveStep()
 *     .withInputs("ks3://kmrhkbj/kmr-test/job/wordcount-input")
 *     .withOutput("ks3://kmrhkbj/zy_step_output_1420")
 *     .withNumMapTasks(1)
 *     .withNumReduceTasks(1)
 *     .withScript("ks3://kmrhkbj/kmr-test/job/binaries/pig_example.pig")
 *     .toHadoopJarStepConfig();
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
public class HiveStep {
  private List<String> inputs = new ArrayList<String>();
  private String output;
  private String script;
  private String numMapTasks;
  private String numReduceTasks;
  private Map<String, String> hadoopConfig = new HashMap<String, String>();



  /**
   * Creates a new default HiveStep.
   */
  public HiveStep() {
  }


  /**
   * Get list of step input paths.
   * @return List of step inputs
   */
  public List<String> getInputs() {
    return inputs;
  }

  /**
   * Set the list of step input paths.
   * @param inputs List of step inputs.
   */
  public void setInputs(Collection<String> inputs) {
    List<String> newInputs = new ArrayList<String>();
    if (inputs != null) {
      newInputs.addAll(inputs);
    }
    this.inputs = newInputs;
  }

  /**
   * Add more input paths to this step.
   * @param inputs A list of inputs to this step.
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withInputs(String ... inputs) {
    for (String input : inputs) {
      this.inputs.add(input);
    }
    return this;
  }


  /**
   * Get output path.
   * @return Output path.
   */
  public String getOutput() {
    return output;
  }

  /**
   * Set the output path for this step.
   * @param output Output path.
   */
  public void setOutput(String output) {
    this.output = output;
  }

  /**
   * Set the output path for this step.
   * @param output Output path
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withOutput(String output) {
    this.output = output;
    return this;
  }


  /**
   * Get the script.
   * @return script.
   */
  public String getScript() {
    return script;
  }

  /**
   * Set the script.
   * @param  script
   */
  public void setScript(String script) {
    this.script = script;
  }

  /**
   * Set the script
   * @param script
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withScript(String script) {
    this.script = script;
    return this;
  }


  /**
   * Get the numMapTasks
   * @return numMapTasks
   */
  public String getNumMapTasks() {
    return numMapTasks;
  }

  /**
   * Set the numMapTasks
   * @param numMapTasks
   */
  public void setNumMapTasks(String numMapTasks) {
    this.numMapTasks = numMapTasks;
  }

  /**
   * Set the numMapTasks
   * @param numMapTasks
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withNumMapTasks(String numMapTasks) {
    this.numMapTasks = numMapTasks;
    return this;
  }


  /**
   * Get the numReduceTasks
   * @return numReduceTasks
   */
  public String getNumReduceTasks() {
    return numReduceTasks;
  }

  /**
   * Set the numReduceTasks
   * @param numReduceTasks
   */
  public void setNumReduceTasks(String numReduceTasks) {
    this.numReduceTasks = numReduceTasks;
  }

  /**
   * Set the numReduceTasks
   * @param numReduceTasks
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withNumReduceTasks(String numReduceTasks) {
    this.numReduceTasks = numReduceTasks;
    return this;
  }

  /**
   * Get the Hadoop config overrides (-D values).
   * @return Hadoop config.
   */
  public Map<String, String> getHadoopConfig() {
    return hadoopConfig;
  }

  /**
   * Set the Hadoop config overrides (-D values).
   * @param hadoopConfig Hadoop config.
   */
  public void setHadoopConfig(Map<String, String> hadoopConfig) {
    this.hadoopConfig = hadoopConfig;
  }

  /**
   * Add a Hadoop config override (-D value).
   * @param key Hadoop configuration key.
   * @param value Configuration value.
   * @return A reference to this updated object so that method calls can be chained
   *         together.
   */
  public HiveStep withHadoopConfig(String key, String value) {
    hadoopConfig.put(key, value);
    return this;
  }


  /**
   * Creates the final HadoopJarStepConfig once you are done configuring the step. You can use
   * this as you would any other HadoopJarStepConfig.
   * @return HadoopJarStepConfig representing this streaming step.
   */
  public HadoopJarStepConfig toHadoopJarStepConfig() {
    List<String> args = new ArrayList<String>();

    for (Map.Entry<String, String> entry : hadoopConfig.entrySet()) {
      args.add("-D");
      args.add(entry.getKey() + "=" + entry.getValue());
    }

    for (String input : inputs) {
      args.add("-input");
      args.add(input);
    }

    if (output != null) {
      args.add("-output");
      args.add(output);
    }

    if (script != null) {
      args.add("-script");
      args.add(script);
    }

    if (numMapTasks != null) {
      args.add("-numMapTasks");
      args.add(numMapTasks);
    }

    if (numReduceTasks != null) {
      args.add("-numReduceTasks");
      args.add(numReduceTasks);
    }

    return new HadoopJarStepConfig()
      .withJar("ks3://kmr/libs/hive-common.jar")
      .withArgs(args);
  }
}

