package dk.statsbiblioteket.medieplatform.newspaper;

import dk.statsbiblioteket.medieplatform.autonomous.ResultCollector;
import dk.statsbiblioteket.util.Strings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchematronValidatorTest {
    @Test
    public void testValidateValid()
            throws
            Exception {
        String jpylizerFile = Strings.flush(Thread.currentThread().getContextClassLoader()
                                         .getResourceAsStream(
                                                 "valid.xml"));
        SchematronValidator validator = new SchematronValidator("sb-jp2.sch", null);
        ResultCollector results = new ResultCollector("test", "0.1");
        validator.validate("valid.xml",jpylizerFile,results);
        System.out.println(results.toReport());
        Assert.assertTrue(results.isSuccess());


    }


    @Test
    public void testValidateInvalid()
            throws
            Exception {
        String jpylizerFile = Strings.flush(Thread.currentThread().getContextClassLoader()
                                                  .getResourceAsStream("invalid.xml"));
        SchematronValidator validator = new SchematronValidator("sb-jp2.sch", null);
        ResultCollector results = new ResultCollector("test", "0.1");
        validator.validate("invalid.xml",jpylizerFile,results);
        System.out.println(results.toReport());
        Assert.assertFalse(results.isSuccess());


    }

}
