package io.github.rstraub.codekatas.mastermind.v1

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(strict = true, plugin = ["pretty", "html:output"])
class RunCucumberTest
