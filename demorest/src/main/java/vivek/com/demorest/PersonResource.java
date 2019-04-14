package vivek.com.demorest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persons")
public class PersonResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons() {
		System.out.println("get Persons called ...");
		PersonRepository pr = new PersonRepository();
		return pr.getPersons();
	}
}
