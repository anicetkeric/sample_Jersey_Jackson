# sample_Jersey_Jackson

How to integrate Jersey with Jackson to develop RESTful JAX-RS services


We will learn how to integrate Jersey REST Client and Jackson to build a RESTful Web service which produces and consumes JSON Type. We use Jackson for convert Java Object to JSON  and vice-versa in a JAX-RS Web Service.

    Java: https://www.java.com/fr/download/
    Eclipse for Java EE Developpers: http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1
    Apache Tomcat: http://tomcat.apache.org/
    RESTClient

# Project structure
![prj structure](https://github.com/anicetkeric/sample_Jersey_Jackson/blob/master/WebContent/screenshots/structure.PNG)

# Jackson Dependencies
```xml
    <dependency>
        <groupId>com.sun.jersey</groupId>
        <artifactId>jersey-server</artifactId>
        <version>1.9</version>
    </dependency>
    
    <dependency>
        <groupId>com.sun.jersey</groupId>
        <artifactId>jersey-json</artifactId>
        <version>1.9</version>
    </dependency>
 ```  
 
 
#### Web.xml (Contents)
```xml
        <servlet>
            <servlet-name>RestServer-serlvet</servlet-name>
            <servlet-class>
                com.sun.jersey.spi.container.servlet.ServletContainer
            </servlet-class>
            <init-param>
                <param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
                <param-value>true</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>RestServer-serlvet</servlet-name>
            <url-pattern>/api/*</url-pattern>
        </servlet-mapping>
    ```    

    
    
## Example UserService.class


    import java.util.ArrayList;
    import java.util.List;

    import javax.ws.rs.GET;
    import javax.ws.rs.POST;
    import javax.ws.rs.Path;
    import javax.ws.rs.PathParam;
    import javax.ws.rs.Produces;
    import javax.ws.rs.core.MediaType;

    import com.rest.service.entities.User;

    @Path("/users")
    public class UserService {

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public User getUser( @PathParam("id") int id ) {
            User user = new User(id, "Anicet", 18);
            return user;
        }    


          @POST
            @Path("/{id}")
            @Produces(MediaType.APPLICATION_JSON)
            public User postUser( @PathParam("id") int id ) {
                User user = new User(id, "Eric", 25);
                return user;
            }    

            @POST
            @Path("/listUsers")
            @Produces(MediaType.APPLICATION_JSON)
            public List<User> listUs() {

                List<User> us = new ArrayList<User>();
                us.add(new User(1, "Aek", 18));
                us.add(new User(2, "Keric", 20));
                us.add(new User(3, "Anicet", 25));

                return us;
            }    

    }
  
## Demo

    http://localhost:8088/RestfullJerseyJackson/api/users/listUsers
    
    Output
    
  ![Output]( https://github.com/anicetkeric/sample_Jersey_Jackson/blob/master/WebContent/screenshots/restclient.PNG)
   
    
