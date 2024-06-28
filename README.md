# HTML Web Page Analyzer

A web-application which allows the user to conduct some analysis of an html web page. It provides a
simple interface where user can enter a html page url and submit. The application processes the given html url
and returns the results of analysis in a simple tabular fashion.

## Getting Started

Follow the instructions below to setup and build the project in your local machine.

### Prerequisites

This project is build using the below tools. Please ensure you have the below prerequisites satisfied

```
1. JDK 17 or above
2. Maven 3.6.3 or above
```

### Open source libraries or plug-ins used

This project uses the below open source libraries, frameworks and plugins.

```
1. Spring Boot Maven plug-in 1.5.7.RELEASE
2. Jsoup 1.17.2
3. Guava:33.2.1-jre
4. Pagination.js 2.0.8
```


### Installing

Clone and run the project using below commands.
```
git clone https://github.com/weshare237/html-web-page-analyzer.git

```
If you are using a IDE for example Intellij then, import project and choose pom.xml file. For more information
you can check out the link https://spring.io/guides/gs/intellij-idea/

### Testing

Use the below command to run automated test suite

```
mvn test
```

### Running

Use the below command to build the project and run from the project root directory.
The project will build and run in a embedded tomcat instance.

```
mvn spring-boot:run
```

If the build is successful then you should see something like this in the console

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.1)

2024-06-28T18:16:15.624+01:00  INFO 28103 --- [           main] com.affinitysquare.WebPageAnalyzer       : Starting WebPageAnalyzer using Java 20.0.1 with PID 28103 (/home/fkd/Videos/demo/target/classes started by fkd in /home/fkd/Videos/demo)
2024-06-28T18:16:15.627+01:00  INFO 28103 --- [           main] com.affinitysquare.WebPageAnalyzer       : No active profile set, falling back to 1 default profile: "default"
2024-06-28T18:16:16.703+01:00  INFO 28103 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-06-28T18:16:16.720+01:00  INFO 28103 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-06-28T18:16:16.721+01:00  INFO 28103 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.25]
2024-06-28T18:16:16.764+01:00  INFO 28103 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-06-28T18:16:16.765+01:00  INFO 28103 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1067 ms
2024-06-28T18:16:16.868+01:00  INFO 28103 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page: class path resource [static/index.html]
2024-06-28T18:16:17.104+01:00  INFO 28103 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-06-28T18:16:17.113+01:00  INFO 28103 --- [           main] com.affinitysquare.WebPageAnalyzer       : Started WebPageAnalyzer in 1.996 seconds (process running for 2.613)
```


### How to use the application?

To check and ensure everything works as expected, open a browser window and hit the below url.

```
http://localhost:8080
```

You should see a page with a text box prompting for url to be entered. Enter the URL
and click 'Analyze' as shown below.

The results are shown in a simple tabular fashion which includes below items
1. HTML Version
2. Page title
3. If the page has a login form or not
4. Total number of different heading types
5. Total number of links categorized as internal and external links. Internal links are the links which contain the
   same domain as the url queried for and external links are ones which are pointing to a different domain.

6. Paginated information containing different links and if the links are reachable and a simple status message.
   For example, showing information on what went wrong (error message or http status code) while trying to access the link.

## Thank you!

If you appreciated this, feel free to follow me!

[![ITutorix-CS YouTube](https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@itutorix)
[![Duclair FOPA KUETE Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/duclair-fopa/)
[![Fopa Duclair Facebook](https://img.shields.io/badge/Facebook-0077B5?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/duclair.kuete.3)