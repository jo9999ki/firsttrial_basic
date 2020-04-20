package de.jk.spring.firsttrial;

import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.jk.spring.firsttrial.entity.CustomerEntity;
import de.jk.spring.firsttrial.repository.CustomerRepository;

@SpringBootTest
class FirsttrialApplicationTests {

	 @Autowired
	 CustomerRepository repository;
	 
	//Test JPA Repository
	@Test
	public void test0testRepositoryFindById() {
			Optional<CustomerEntity> emp = repository.findById(2L);
			assertThat(emp.get().getId(), Matchers.equalTo(2L));
	}
	
	
}


