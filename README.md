### Project for testing the https://

##### The software
<ul>
    <li>Java v1.8.0_251</li>
    <li>Maven v3.8.3</li>
    <li>browser drivers - all the latest versions</li>
</ul>
For running this project choose in <code>pom.xml</code> file class path and write <code>mvn clean verify -Dstar.acceptance.url=https:// -Dstar.acceptance.driver=org.openqa.selenium.chrome.ChromeDriver</code> in terminal. If you wont to run by another browser, then change <code>star.acceptance.driver</code>.
<br>
For running this project for parallel mode write <code>mvn clean verify -Dparallel.tests.count=10 -Dstar.acceptance.url=https:// -Dstar.acceptance.driver=org.openqa.selenium.chrome.ChromeDriver</code> in terminal. If you wont to run by another count, then change <code>parallel.test.count</code>.
<br>
After running test report is generated in <code>target</code> folder with name <code>cucumber-jvm-reports</code>, if test fails the screen shot of related page appears in report.
<br>
