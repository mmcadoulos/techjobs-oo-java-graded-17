package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();

        Assert.assertNotEquals(firstJob, secondJob);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public  void  testJobsForEquality () {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(firstJob.equals(secondJob), false);
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        // why are they trying to teach TDD with methods that are completely unfamiliar to us? We can't know how to test a method we don't know through a test we don't know
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // doesn't work and doesn't show a difference without Assert.
        Assert.assertEquals((job.toString().charAt(0)), System.lineSeparator());
        Assert.assertEquals(job.toString().charAt(job.toString().length() - 1), System.lineSeparator());

            // this works
//        assertTrue(job.toString().endsWith(System.lineSeparator()));
//        assertTrue(job.toString().startsWith(System.lineSeparator()));
//
        // this works
//    String toString = System.lineSeparator() +"Job Info"+ System.lineSeparator();
//    assertEquals(job.toString(), toString);

//        String firstChar = String.valueOf(job.toString().charAt(0));
//        String lastChar = String.valueOf(job.toString().charAt(job.toString().length()-1));
//        Assert.assertEquals(firstChar, System.lineSeparator());
//        Assert.assertEquals(lastChar, System.lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
// no idea what to do....maybe break the string into an arraylist through "\n" delimiters and then checking things through ":" delimiters?
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Assert.assertEquals("""
            ID: 4
            Name: Product tester
            Employer: ACME
            Location: Desert
            Position Type: Quality control
            Core Competency: Persistence""", job.toString().trim());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        Assert.assertEquals("""
            ID: 3
            Name: Data not available
            Employer: Data not available
            Location: Data not available
            Position Type: Data not available
            Core Competency: Data not available""", job.toString().trim());
    }

    @Test
    public void testToStringHandlesOnlyId(){
        Job job = new Job();
        Assert.assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }
}
