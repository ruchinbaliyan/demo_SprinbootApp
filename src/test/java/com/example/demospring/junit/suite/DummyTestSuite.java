package com.example.demospring.junit.suite;

import com.example.demospring.junit.helper.ArraysCompareTest;
import com.example.demospring.junit.helper.StringHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ArraysCompareTest.class, StringHelperTest.class})
public class DummyTestSuite {

}
