import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import utils.CustomAsserts;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
public class MyAspects {
    @Around("execution(* *(..))")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Logger benchmarkLogger = Logger.getLogger("benchmarkLogger");
        Logger logger = Logger.getLogger("testExecutionLogger");
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        Method method = signature.getMethod();
        String methodName = method.getName();
        if (!(className.contains("AbstractBase")
                || className.contains("webServiceProxies")
                || (className.contains("RuntimeUtils"))
                || (className.contains("DriverUtils")))) {
            logger.info("Class: " + className + ", Method: " + methodName);
        }
        long startingTime = (new Date()).getTime();
        Object retVal = proceedingJoinPoint.proceed();
        long endTime = (new Date()).getTime();
        benchmarkLogger.info(signature.getDeclaringTypeName() + " || "
                + methodName + " || "
                + ((endTime - startingTime) / 1000) + " || ");
        return retVal;
    }

    @Around("execution(* *CustomAsserts.assert*(..))")
    public void forHardAssertSkipTheUpcomingTests(ProceedingJoinPoint proceedingjoinpoint) {
        Logger logger = Logger.getLogger("testExecutionLogger");
        MethodSignature signature = (MethodSignature) proceedingjoinpoint.getSignature();
        String className = signature.getDeclaringTypeName();
        Method method = signature.getMethod();
        String methodName = method.getName();
        if (System.getProperty("ASSERTION_ERROR") == null) {
            try {
                proceedingjoinpoint.proceed();
            } catch (AssertionError aEx) {
                logger.info("Class: " + className + ", Method: " + methodName);
                logger.info("\n Exception :" + aEx.toString());
                System.setProperty("ASSERTION_ERROR", "Assertion Found");
                throw aEx;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    @After("execution(* specs.bpp.application.*.*.*Test.*(..))")
    public void forSoftAssertMarkThemAsFailedInHTML(JoinPoint jointPoint) throws Exception {
        Logger logger = Logger.getLogger("testExecutionLogger");
        MethodSignature signature = (MethodSignature) jointPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        Method method = signature.getMethod();
        String methodName = method.getName();

        if (className.contains("spec") ) {
            logger.info("Class: " + className + ", Method: " + methodName);
            String verificationErrors = String.valueOf(CustomAsserts.getVerificationFailures());
            if(!(verificationErrors.equals("[]")))    {
                CustomAsserts.resetVerificationFailures();
                throw new Exception(verificationErrors);
            }
        }
    }
}
