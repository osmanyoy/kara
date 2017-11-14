package com.training.core.tst;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.training.core.tst.management.CalculatorOperationManagerTest;

@RunWith(Categories.class)
@SuiteClasses({ CalculatorOperationManagerTest.class })
@IncludeCategory({ IFailCategory.class })
public class RunFailCategory {

}
