package friends;

public class Person {
	String name;		// the person's name
	Friend firstFriend; // the first friend in the list of this
					  	// person's friends
	Person nextPerson;  // the next person in the list of people
	
	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
		}

	// A string representing the list of friends of this person.  
	// O(number of friends in the list)
	
	public String friendString()
	{
		String friendList = "";
		Friend friendPointer = this.firstFriend;
 
		while(friendPointer != null)
		{
			// Concatenates the String with the names of friends and puts spaces between each name 
			friendList += friendPointer.who.name + " ";
			friendPointer = friendPointer.nextFriend;
		}
		
		return friendList; 
	
	}
	
	// add friend as a friend of this person
	// O(1)

	public void addFriend(Person friend)
	{
		// Adds a friend to the Friend LinkedList, at the front 
		Friend temp = new Friend(friend, this.firstFriend);
		this.firstFriend = temp;
	}
	
	// remove Person friend as a friend of this person
	// O(number of friends of this person)
	public void removeFriend(Person friend)
	{
		
		Friend previous, friendPointer = this.firstFriend;
		previous = friendPointer;
		
		if(friendPointer == null)
		{
			return; 
		}
		while(friendPointer != null)
		{
			if(friendPointer.who.name.equals(friend.name))
			{
				if(friendPointer == this.firstFriend)
				{
					this.firstFriend = friendPointer.nextFriend;
				}
				previous.nextFriend = friendPointer.nextFriend;

				return;
			}
			else
			{
				// Continues to search for the friend to remove.
				previous = friendPointer;
				friendPointer = friendPointer.nextFriend;
			}
		}
	}
}
