/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.PhenirainPlugin;

import org.opensearch.client.node.NodeClient;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.RestRequest;
import org.opensearch.rest.BytesRestResponse;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.opensearch.rest.RestRequest.Method.GET;


public class RestHelloWorldAction extends BaseRestHandler {

    @Override
    public String getName() {
        return "rest_handler_hello_world";
    }

    @Override
    public List routes() {
        return unmodifiableList(asList(
                new Route(GET, "/_plugins/hello_world")));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        String name = request.param("name", "");
        return channel -> {
            try {
//                first way
//                channel.sendResponse(RestTable.buildResponse(HelloWorldService.buildResponse(name), channel));
//                second way
                channel.sendResponse(HelloWorldService.buildResponse(name));
            } catch (final Exception e) {
                channel.sendResponse(new BytesRestResponse(channel, e));
            }
        };
    }
}

