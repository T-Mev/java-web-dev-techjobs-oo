package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1, job2, job3, job4, job5, job6;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job5 = new Job("Ice cream taster", new Employer(""), new Location("Home"),
                new PositionType("UX"), new CoreCompetency("Taste"));
        job6 = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(job1.getId(), job2.getId());
        assertEquals(job1.getId() + 1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().toString());
        assertEquals("Desert", job3.getLocation().toString());
        assertEquals("Quality control", job3.getPositionType().toString());
        assertEquals("Persistence", job3.getCoreCompetency().toString());

        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(job3, job4);
    }

    @Test
    public void toStringBlankLineBeforeAndAfterObject() {
        int length = job3.toString().length();

        assertEquals("\n", job3.toString().substring(0, 1));
        assertEquals("\n", job3.toString().substring(length - 1, length));
    }

    @Test
    public void toStringWorksCorrectly() {
        assertEquals("\nID: " + job3.getId() +
                "\nName: " + job3.getName() +
                "\nEmployer: " + job3.getEmployer() +
                "\nLocation: " + job3.getLocation() +
                "\nPosition Type: " + job3.getPositionType() +
                "\nCore Competency: " + job3.getCoreCompetency() + "\n", job3.toString());
    }

    @Test
    public void toStringHasEmptyField() {
        assertEquals("Data not available", (!job5.getEmployer().getValue().equals("") ? job5.getEmployer():"Data not available"));
    }

    @Test
    public void toStringOnlyHasIdField() {
        assertEquals("OOPS! This job does not seem to exist.", job6.toString());
    }

}
