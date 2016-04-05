package action02;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Base {
	Set<User> set = new HashSet<>();
	public Base(){
		Calendar date1 = new GregorianCalendar(2016,02,23);
		Calendar date2 = new GregorianCalendar(2016,02,24);
		Calendar date3 = new GregorianCalendar(2016,02,25);
		set.add(new User("user1","1", date1));
		set.add(new User("user2","1", date2));
		set.add(new User("user3","1", date3));
	}
	public boolean auth(String login, String pass){
		for(User user:set){
			if(user.equals(new User(login,pass))) return true;
		}
		return false;
	}
}
