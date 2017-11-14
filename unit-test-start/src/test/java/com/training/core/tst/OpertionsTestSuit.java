package com.training.core.tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.training.core.tst.operations.AddOperationTest;
import com.training.core.tst.operations.MultiplyOperationTest;

@RunWith(Suite.class)
@SuiteClasses({ AddOperationTest.class,
                MultiplyOperationTest.class })
public class OpertionsTestSuit {

}
