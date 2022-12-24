package com.emse.spring.faircorp.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;

/**
 * RESTful API for greeting a user by name.
 */
@RestController
@RequestMapping("/api/hello")
@Transactional
public class HelloController {

    /**
     * Retrieves a greeting message that includes the user's name.
     *
     * @param name name of the user
     * @return message DTO with greeting message
     */
    @GetMapping("/{name}")
    public MessageDto welcome(@PathVariable String name) {
        return new MessageDto("Hello " + name);
    }

    /**
     * Data transfer object for a message.
     */
    static class MessageDto {
        /**
         * The message.
         */
        private String message;

        /**
         * Constructs a new message DTO with the given message.
         *
         * @param message the message
         */
        public MessageDto(String message) {
            this.message = message;
        }

        /**
         * Returns the message.
         *
         * @return the message
         */
        public String getMessage() {
            return message;
        }
    }
}
