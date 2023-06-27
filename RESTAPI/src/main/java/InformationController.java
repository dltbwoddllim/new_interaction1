import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class InformationController<InformationRequest> {

    @PostMapping
    public HttpStatus updateInformation(@RequestBody InformationRequest request) {
        // Process the request and update information
        // You may need to define an InformationRequest class

        // Example logic to process the request and return appropriate response
        if (isValidRequest(request)) {
            // Perform the necessary operations to update information
            return HttpStatus.OK;
        } else {
            // Return an appropriate HTTP status code indicating a bad request
            return HttpStatus.BAD_REQUEST;
        }
    }

    private boolean isValidRequest(InformationRequest request) {
        // Implement your validation logic here
        // For example, check if required fields are present and validate their values
        // Return true if the request is valid, false otherwise
        return (request.getNickname() != null && request.getMajor() != null &&
                request.getMbti() != null && request.getHobbies() != null);
    }
}