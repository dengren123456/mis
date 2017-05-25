package model;

public enum Type { 

  ACOUSTIC, ELECTRIC;

  public String toString() {
    switch(this) {
      case ACOUSTIC: return "acoustic";
      case ELECTRIC: return "electric";
      default:       return "unspecified";
    }
  }
  public static Type fromString(String name) {
		for (Type e : Type.values()) {
			if (e.toString().equals(name)) {
				return e;
			}
		}
		return null;
	}
}
