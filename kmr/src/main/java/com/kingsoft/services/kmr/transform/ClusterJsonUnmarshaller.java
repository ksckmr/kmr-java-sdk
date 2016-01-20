package com.kingsoft.services.kmr.transform;

import com.kingsoft.services.kmr.model.*;
import com.kingsoft.services.transform.SimpleTypeJsonUnmarshallers.*;
import com.kingsoft.services.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * Cluster JSON Unmarshaller
 */
public class ClusterJsonUnmarshaller implements
        Unmarshaller<Cluster, JsonUnmarshallerContext> {

    public Cluster unmarshall(JsonUnmarshallerContext context) throws Exception {
        Cluster cluster = new Cluster();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL)
            return null;

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("Id", targetDepth)) {
                    context.nextToken();
                    cluster.setId(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Name", targetDepth)) {
                    context.nextToken();
                    cluster.setName(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("HadoopVersion", targetDepth)) {
                    context.nextToken();
                    cluster.setHadoopVersion(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("Status", targetDepth)) {
                    context.nextToken();
                    cluster.setStatus(ClusterStatusJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                /*
                if (context
                        .testExpression("InstanceAttributes", targetDepth)) {
                    context.nextToken();
                    cluster.setInstanceAttributes(InstanceAttributesJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                */
                if (context.testExpression("LogUri", targetDepth)) {
                    context.nextToken();
                    cluster.setLogUri(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }

                if (context.testExpression("AutoTerminate", targetDepth)) {
                    context.nextToken();
                    cluster.setAutoTerminate(BooleanJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("TerminationProtection", targetDepth)) {
                    context.nextToken();
                    cluster.setTerminationProtected(BooleanJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }

                if (context.testExpression("Applications", targetDepth)) {
                    context.nextToken();
                    cluster.setApplications(new ListUnmarshaller<String>(
                            StringJsonUnmarshaller.getInstance())
                            .unmarshall(context));
                }

                if (context.testExpression("ServiceRole", targetDepth)) {
                    context.nextToken();
                    cluster.setServiceRole(StringJsonUnmarshaller.getInstance()
                            .unmarshall(context));
                }
                if (context.testExpression("MasterPublicDnsName", targetDepth)) {
                    context.nextToken();
                    cluster.setMasterPublicDnsName(StringJsonUnmarshaller
                            .getInstance().unmarshall(context));
                }
                if (context.testExpression("NormalizedInstanceMins",
                        targetDepth)) {
                    context.nextToken();
                    cluster.setNormalizedInstanceMins(FloatJsonUnmarshaller
                            .getInstance().unmarshall(context).intValue());
                }


            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null
                        || context.getLastParsedParentElement().equals(
                                currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return cluster;
    }

    private static ClusterJsonUnmarshaller instance;

    public static ClusterJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ClusterJsonUnmarshaller();
        return instance;
    }
}
