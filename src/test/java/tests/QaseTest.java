package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void getProjectsTest() {
        new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .code("IHAR")
                .title("MALINOUSKI")
                .description("Test project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void createSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke test")
                .description("This is the smoke test suite")
                .preconditions("This is preconditions")
                .build();
        new SuiteAdapter().create("IHAR", testSuite);
    }

    @Test
    public void createSecondSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke testing forrrr")
                .description("This is the smoke test suite")
                .preconditions("This is preconditions")
                .build();
        boolean status = new SuiteAdapter().createDemo("IHAR", testSuite).path("status");
        Assert.assertTrue(status);
    }

    @Test
    public void deleteSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .destinationId(12)
                .build();
        boolean status = new SuiteAdapter().delete("IHAR", "12", testSuite).path("status");
        Assert.assertTrue(status);
    }
}
