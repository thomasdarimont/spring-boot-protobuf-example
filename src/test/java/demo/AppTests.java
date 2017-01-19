package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void contextLoaded() {

    ResponseEntity<CustomerProtos.Customer> customerResponse = restTemplate.getForEntity(
      "/customers/2", CustomerProtos.Customer.class);

    System.out.println("customer retrieved: " + customerResponse.toString());
    assertThat(customerResponse.getBody().getFirstName()).isEqualTo("Josh");
  }
}
