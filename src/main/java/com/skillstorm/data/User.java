package com.skillstorm.data;

public class User 
{
	//private int UserId;
	private String Userame;
	private String Password;
	
	public User() 
	{
		super();		
	}

	public User(String userame, String password) 
	{
		super();		
		Userame = userame;
		Password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Userame == null) ? 0 : Userame.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Userame == null) {
			if (other.Userame != null)
				return false;
		} else if (!Userame.equals(other.Userame))
			return false;
		return true;
	}

	public String getUserame() {
		return Userame;
	}

	public void setUserame(String userame) {
		Userame = userame;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [Userame=" + Userame + ", Password=" + Password + "]";
	}
	
}
