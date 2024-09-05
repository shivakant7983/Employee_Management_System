package model.Exceptions;

public class DuplicatedException extends Exception {

	@Override
	 public String toString() {
		  return "This id is already Prresent in the Database";
	  }
	  @Override
	  public String getMessage() {
		  return "Duplicate Id So it Can't be inserted";
	  }
	  public DuplicatedException(String msg) {
		  super(msg);
	  }
}
