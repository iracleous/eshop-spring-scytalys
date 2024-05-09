package com.scytalys.eshop.http;

import com.scytalys.eshop.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.RestClientResponseException;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello World");
    }


    @Test
    public void testAddEmployee_V2_FailsWhen_IncorrectId() {
        try {
            this.restTemplate.getForObject("/employees/v2/101", EmployeeDto.class);
        } catch (RestClientResponseException ex) {

            ProblemDetail pd = ex.getResponseBodyAs(ProblemDetail.class);
            assertEquals("Employee id '101' does no exist", pd.getDetail());
            assertEquals(404, pd.getStatus());
            assertEquals("Record Not Found", pd.getTitle());
            assertEquals(URI.create("http://my-app-host.com/errors/not-found"), pd.getType());
            assertEquals("localhost", pd.getProperties().get("hostname"));
        }
    }
}