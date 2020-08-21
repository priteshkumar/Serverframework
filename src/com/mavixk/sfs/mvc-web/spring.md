### Springboot controller method params:

> **@Controller** : spring bean handling http requests

> **@RestController** : @Controller + @ResponseBody , returns json objects in http response

> **@RequestParam("imageId")** Integer imageId : query parameters are annotated as given

> **@PathVariable("id")** Integer id : used for /image/{id} like urls

> **@RequestMapping(value = "/images/upload", method = RequestMethod.POST)** : annotation for controller method to handle a specific type of HTTP request.




### HTTP info

> Http Session : An HttpSession object can hold a conversational state across multiple requests from the same client

> Users get there unique session identifiers to differentiate between clients/users.


