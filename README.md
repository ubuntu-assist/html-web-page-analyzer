# HTML Web Page Analyzer

A web application designed for users to analyze HTML web pages. It features a user-friendly interface where users can input an HTML page URL and submit it. The application then processes the URL and presents the analysis results in a clear, tabular format.

## Getting Started

Follow these steps to set up and build the project on your local machine.

### Prerequisites

This project is built using the following tools. Please make sure you meet the prerequisites listed below.

```
1. JDK 17 or above
2. Maven 3.6.3 or above
```

### Open source libraries or plug-ins used

This project utilizes the following open-source libraries, frameworks, and plugins.

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
If you are using an IDE such as IntelliJ, import the project and select the `pom.xml` file. For further details, you can visit [this guide](https://spring.io/guides/gs/intellij-idea/).

### Testing

Use the following command to execute the automated test suite.

```
mvn test
```

### Running

Use the following command to build the project and run it from the project's root directory. The project will be built and executed in an embedded Tomcat instance.

```
mvn spring-boot:run
```

If the build is successful, you will see something similar to this in the console:

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

To verify that everything is functioning correctly, open a web browser and visit the following URL:

```
http://localhost:8080
```

You will encounter a page with a text box where you can enter a URL. Input the URL and click 'Analyze' as depicted below.

The results are displayed in a straightforward table format, including the following details:

1. HTML Version
2. Page title
3. Presence of a login form
4. Total number of different heading types
5. Total number of links categorized as internal and external. Internal links are those within the same domain as the queried URL, while external links point to different domains.
6. Paginated information listing various links, their reachability status, and any accompanying status messages such as error messages or HTTP status codes encountered during access attempts.

### Run the application using Docker
Pull the docker image from Docker Hub

```
docker pull fkd2000/html-web-page-analyzer
```
Run a container form the Image
```
docker run --name <name> -d -p <port>:8080 fkd2000/html-web-page-analyzer
```

## Assumptions

Following are some of the assumptions made during the development.
1. All the urls will be submitted with http:// or https:// as a prefix.
2. Latest version of modern browsers are to be supported. Behaviour of the application is
   undefined when old version of browser is used.

## Design decision

1. Decided to use simple html, css and javascript to render the results in the browser.
   Client-side code is only rendering the screens and all the core business logic is served
   by the server side.
2. Spring boot framework is one of the most modern framework which offers a lot of out
   of the box features such as support for REST framework, embedded tomcat-server with
   minimal set of configuration and annotations and hence this is probably the first
   choice for server side development.
3. JSoup is a simple yet powerful library to parse html in java and hence I had no second
   thoughts using this.
4. For domain name matching in the url, I found Guava:33.2.1-jre library quite simple and
   fits the purpose.
5. For client side pagination I used a simple pagination.js plugin, its quite simple and easy
   to use.
6. For the optional part, I decided to perform pagination of links since performance is
   quite relevant for this part.
7. Pagination.js is a simple plug-in that can be used to implement pagination in the client
   side using jQuery.

## Thank you!

If you appreciated this, feel free to follow me!

[![ITutorix-CS YouTube](https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@itutorix)
[![Duclair FOPA KUETE Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/duclair-fopa/)
[![Fopa Duclair Facebook](https://img.shields.io/badge/Facebook-0077B5?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/duclair.kuete.3)