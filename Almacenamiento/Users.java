package tec;

public class Users{

	public User  root;
	public int largo;

	public Users(){
		root = null;
		largo=0;
	}

	public void add(String name){
		User user = new User ();
		user.setName(name);
		if(root==null){
			root=user;
			largo++;
		}
		else{
			User current = root;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(user);
			largo++;
		}
	}
	public void print2 () {
        String data = "[";
        User  current = root;
        while (current != null) {
        	data += current.getName();
        	if (current.getNext() != null)
        		data += ", ";
            current = current.getNext();
        }
        data += "]";
        System.out.println(data);
    }
	public User user (String name){
		User user = root;
		while (!(user.getName().equals(name))){
			if (user.getNext()==null){
				user=null;
				break;
			}
			user = user.getNext();
		}
		return user;
	}
}
