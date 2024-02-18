package com.chiacon.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.chiacon.annotations.FrameworkAnnotations;

import logMassage.Logs;
import reports.ExtendLogger;
import reports.ExtendReports;

public class TestListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Class<?> clazz = result.getTestClass().getRealClass();
		String methodName = result.getMethod().getMethodName();

		Logs.logMessage(clazz, methodName + " Started");

		ExtendReports.createTest(result.getMethod().getDescription());
		FrameworkAnnotations annotations = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class);

		ExtendReports.assignAuthor(annotations.author());
		ExtendReports.assignCategory(annotations.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Class<?> clazz = result.getTestClass().getRealClass();
		String methodName = result.getMethod().getMethodName();

		Logs.logMessage(clazz, methodName + " is passed");
		ExtendLogger.pass(methodName + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Class<?> clazz = result.getTestClass().getRealClass();
		String methodName = result.getMethod().getMethodName();

		Logs.logMessage(clazz, methodName + " is failed");
		ExtendLogger.fail(methodName + " is failed");

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			String exceptionMessage = "Exception: " + throwable.getMessage();
			Logs.logMessage(clazz, exceptionMessage);
			ExtendLogger.fail(exceptionMessage);

			String stackTrace = "Stack Trace: " + Arrays.toString(throwable.getStackTrace());
			ExtendLogger.fail(stackTrace);
		}
	}

	@Override
	public void onStart(ITestContext context) {
		ExtendReports.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtendReports.flushReport();
	}
}
