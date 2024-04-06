#!/bin/bash
#staging
mvn clean verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storestaging.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.chrome.ChromeDriver

mvn clean test -Dstar.acceptance.url=https://storestaging.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.firefox.FirefoxDriver

mvn clean test -Dstar.acceptance.url=https://storestaging.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.edge.EdgeDriver

#dev
mvn clean verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storedev.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.chrome.ChromeDriver

mvn clean test verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storedev.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.firefox.FirefoxDriver

mvn clean test verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storedev.startrekfleetcommand.com/ -Dstar.acceptance.driver=org.openqa.selenium.edge.EdgeDriver

#remote
mvn clean verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storedev.startrekfleetcommand.com/ -Dstar.acceptance.grid.url=http://10.245.8.170:4444/wd/hub/ -Dstar.acceptance.browser=chrome -Dstar.acceptance.version=96.0

mvn clean verify -Dparallel.tests.count=5 -Dstar.acceptance.url=https://storedev.startrekfleetcommand.com/ -Dstar.acceptance.grid.url=http://10.245.8.170:4444/wd/hub/ -Dstar.acceptance.browser=firefox -Dstar.acceptance.version=94.0