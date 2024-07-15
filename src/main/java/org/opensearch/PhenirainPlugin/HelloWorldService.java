/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.PhenirainPlugin;

import org.opensearch.common.Table;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestResponse;

import java.util.Locale;

public class HelloWorldService {

//    first way
//    public static Table buildResponse(String name) {
//        final Table table = new Table();
//        final String message = name.isEmpty() ? "Hello world!" : String.format(Locale.US, "Hello, %s!", name);
//        table.startHeaders();
//        table.addCell("test", "desc:test");
//        table.endHeaders();
//        table.startRow();
//        table.addCell(message);
//        table.endRow();
//        return table;
//    }

//    second way
    public static RestResponse buildResponse(String name) {
        final String message = name.isEmpty() ? "Hello world!" : String.format(Locale.US, "Hello, %s!", name);
        return new BytesRestResponse(RestStatus.OK, message);
    }
}
