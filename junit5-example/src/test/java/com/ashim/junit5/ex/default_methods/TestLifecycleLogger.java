package com.ashim.junit5.ex.default_methods;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface TestLifecycleLogger {

	Logger logger = Logger.getLogger(TestLifecycleLogger.class.getName());

	@BeforeAll
	default void beforeAllTests() {
		logger.info("Before all tests");
	}

	@AfterAll
	default void afterAllTests() {
		logger.info("After all tests");
	}

	@BeforeEach
	default void beforeEachTest(TestInfo testInfo) {
		logger.info(() -> String.format("About to execute [%s]",
				testInfo.getDisplayName()));
	}

	@AfterEach
	default void afterEachTest(TestInfo testInfo) {
		logger.info(() -> String.format("Finished executing [%s]",
				testInfo.getDisplayName()));
	}

}