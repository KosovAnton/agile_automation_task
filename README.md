# agile_automation_task
Run:
- default runner: src\test\java\CucumberRunner.java (specify tags to run, @FullRegression setted by default). You can run any tag specified in feature files.
- also there is an ability to run with maven, execute 'mvn clean verify', by default @FullRegression will run. Also you can specify number of parallel threads and exact tags to run: mvn clean -Dcucumber.options="--tags @FullRegression" -Dfork.count=2 verify.
html report will be generated in target\cucumber-report-html\cucumber-html-reports
