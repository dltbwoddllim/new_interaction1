import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conversation/partner")
public class ConversationController {

    @PostMapping
    public List<PartnerResponse> findPartners(@RequestBody PartnerRequest request) {
        // Process the request and return a list of partners
        // You may need to define a PartnerResponse class
    }
}
