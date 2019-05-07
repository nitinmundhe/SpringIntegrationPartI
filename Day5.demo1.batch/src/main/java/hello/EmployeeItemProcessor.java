package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<Person, Employee> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public Employee process(final Person person) throws Exception {
		final String ename = person.getFirstName() + " " + person.getLastName().toUpperCase();		
		final Integer salary = (int)(Math.random()*((10000-5000)+1))+5000;;

		final Employee transformedPerson = new Employee(ename, salary);

		log.info("Converting (" + person + ") into (" + transformedPerson + ")");

		return transformedPerson;
	}

}
