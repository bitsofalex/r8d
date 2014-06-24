package com.bits.alex.couch;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alexl on 17/06/2014.
 */
public class CouchWithEktorp {

    public static void main(String[] args) {
        final HttpClient httpClient = new StdHttpClient.Builder().build();
        final CouchDbInstance couchDbInstance = new StdCouchDbInstance(httpClient);
        final CouchDbConnector db = couchDbInstance.createConnector("store_group", true);

//        createStores(db);
        queryStores(db);
    }

    private static void queryStores(final CouchDbConnector db) {
        final List<String> attributes = new ArrayList<String>();
        attributes.add("a");
        final ViewQuery query = new ViewQuery()
                .designDocId("_design/store")
                .viewName("by_attributes")
                .key(new String[]{"a", "c"});
        ViewResult results = db.queryView(query);
        for (ViewResult.Row row : results.getRows()) {
            System.out.println(row.getId() + " : " + row.getKey());
        }
    }

    private static void createStores(final CouchDbConnector db) {
        createStoreWithAttributes(db, "melboure");
        createStoreWithAttributes(db, "adelaide", "a");
        createStoreWithAttributes(db, "sydney", "a", "b");
        createStoreWithAttributes(db, "brisbane", "a", "c");
        createStoreWithAttributes(db, "perth", "a", "b", "c");
    }

    private static void createStoreWithAttributes(final CouchDbConnector db, final String name, final String... attributes) {
        final Map<String, Object> store = new HashMap<String, Object>();
        final List<String> storeAttributes = new ArrayList<String>();
        for (String attribute : attributes) {
            storeAttributes.add(attribute);
        }
        store.put("name", name);
        store.put("SA", storeAttributes);

        db.create(store);
    }

}
