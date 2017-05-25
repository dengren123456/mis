package model;


public enum Builder { 

  FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

  public String toString() {
    switch(this) {
      case FENDER:   return "Fender";
      case MARTIN:   return "Martin";
      case GIBSON:   return "Gibson";
      case COLLINGS: return "Collings";
      case OLSON:    return "Olson";
      case RYAN:     return "Ryan";
      case PRS :     return "PRS";
      default:       return "Unspecified";
    }
  }
  public static Builder fromString(String name) {
	    for (Builder e : Builder.values()) {
	        if (e.toString().equals(name)) {
	            return e;
	        }
	    }
	    return null;
}
}
