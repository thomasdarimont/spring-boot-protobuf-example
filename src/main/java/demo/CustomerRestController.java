package demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
class CustomerRestController {

  private final CustomerRepository customerRepository;

  /**
   * {@code curl -v http://localhost:8080/customers/1}
   */
  @GetMapping("/customers/{id}")
  CustomerProtos.Customer customer(@PathVariable Integer id) {
    return this.customerRepository.findById(id);
  }

  /**
   * {@code curl -v http://localhost:8080/customers}
   */
  @GetMapping("/customers")
  CustomerProtos.CustomerList findAll() {
    return this.customerRepository.findAll();
  }
}