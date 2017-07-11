package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson;		// First Person object in the list

	public PersonList( ) {
		this.firstPerson = null;
	}
	
	// finds Person object in this list with given name
	// if none exists, returns null.  Runs in O(number of persons in this list) 

	public Person lookup(String name){
		Person temporary = firstPerson;
		
		while(temporary != null)
		{
			if(temporary.name.equals(name))
			{ 
				// Person is in list so it returns a reference to a object of the person being looked up.
				return temporary;
			}
			temporary = temporary.nextPerson;
		}
		// Not in list;
		return null;
	}
	
	// creates a new Person object with name and adds it to the list of Persons
	// Runs in O(1)

	public Person addPerson(String name)
	{
		// Create new Person object who's next value is the first person of the PersonList.
		Person newPerson = new Person(name,firstPerson);
		firstPerson =newPerson;
		
		return newPerson;
	}
}
