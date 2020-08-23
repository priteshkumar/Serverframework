### Spring Core

> Spring is framework for creating enterprise applications/web applications 

> Provides inversion of control , leads to loosely coupled architecture.

> Works easily with tools like gradle/maven

> Follows POJO style , easily integrable/testable

> Layered architecure

### Spring IOC container

> Below packages are the basis for  Spring Framework’s IoC container:

1)org.springframework.beans 

2)org.springframework.context packages 


### ApplicationContext

> org.springframework.context.ApplicationContext interface represents the Spring IoC container 

> responsible for instantiating, configuring, and assembling the beans.

> The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata.

> The configuration metadata is represented in XML, Java annotations, or Java code.

>  ApplicationContext is the interface for an advanced factory capable of maintaining a registry of different beans and their dependencies.
  
  
 ### Bean Scopes
 
 > ApplicationContext ioc container maintains a registry of BeanDefinition instances.
 
 > BeanDefinition is a recipe for bean instantiation
 
 > It has fully qualified actual class of the bean, dependencies, configuration (scope , lifecycle callbacks etc)

 > Bean scopes are of below types:
 
 - SingleTon
 - Prototype
 - Request
 - Session
 - Application
 - Websocket
 



### Springboot controller method params:

> **@Controller** : spring bean handling http requests

> **@RestController** : @Controller + @ResponseBody , returns json objects in http response

> **@RequestParam("imageId")** Integer imageId : query parameters are annotated as given

> **@PathVariable("id")** Integer id : used for /image/{id} like urls

> **@RequestMapping(value = "/images/upload", method = RequestMethod.POST)** : annotation for controller method to handle a specific type of HTTP request.




### HTTP info

> Http Session : An HttpSession object can hold a conversational state across multiple requests from the same client

> Users get there unique session identifiers to differentiate between clients/users.

> Spring automatically passes the session object to the thymeleaf template just like the Model object. e.g. ${session.loggeduser.profile.fullName}
