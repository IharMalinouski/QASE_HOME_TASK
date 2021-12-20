package adapters;

import io.restassured.response.ResponseBody;
import objects.TestSuite;

public class SuiteAdapter extends BaseAdapter {

    private static final String SUITE_URI = "/suite/%s";
    private static final String DELETE_SUITE_URI = "/suite/%s/%s";

    public int create(String projectCode, TestSuite testSuite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public ResponseBody createDemo(String projectCode, TestSuite testSuite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(testSuite))
                .body();
    }

    public ResponseBody delete(String projectCode, String identifier, TestSuite testSuite) {
        return delete(String.format(DELETE_SUITE_URI, projectCode, identifier), converter.toJson(testSuite)).body();
    }
}
