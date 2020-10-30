class ManagementCompany {
  String name;
  int taxId;
  double managementFee;
  final int MAX_PROPERTY = 5;
  int n_properties = 0;
  Property[] properties = new Property[MAX_PROPERTY];
  final double MGMT_WIDTH = 10;
  final double MGMT_DEPTH = 10;
  Plot plot;
  public ManagementCompany(){
    name = "";
    taxId = 0;
    managementFee = 0.0;
    plot = new Plot();
  }
  public int addProperty(Property p) {
    // Checking that the given property is not null
    if (p == null){
      return -2;
    }
    //Checking that the given property do not encompasses
    if (!plot.encompasses(p.getPlot())) {
      return -3;
    }
    //Checking that the given property do not overlaps
    for (int i = 0; i < n_properties; i++){
      if (plot.overlaps(properties[i].getPlot())){
        return -4;
      }
    }
    //Checking that the number of properties do not exceeds the maximum
    if (n_properties == MAX_PROPERTY)
      return -1;
    properties[n_properties] = p;
    n_properties += 1;
    return 0;
  }
  public void addProperty(String propertyName, String city, double rent, String ownerName) {
    //First addProperty method
      Property p = new Property(propertyName, city, rent, ownerName);
      addProperty(p);
  }
  public void addProperty(String propertyName, String city, double rent, String ownerName,                           int x, int y, int width, int depth){
    //Second addProperty method
      Property p = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
      addProperty(p);
  }
  public double totalRent (double rent){
    //Method that returns the total rent
    rent = 0.0;
    for (int i = 0; i < n_properties; i++) {
      rent += properties[i].getRentalAmount();
    }
    return rent;
  }
  private int maxRentPropertyIndex() {
    //This method returns the index of the property with the highest rent value
    double maxRent = 0.0;
    int index = 0;
    for (int i = 0; i < n_properties; i++) {
      if (properties[i].getRentalAmount() > maxRent) {
        maxRent = properties[i].getRentalAmount();
        index = i;
      }
    }
    return index;
  }
  public double maxRentProp() {
    //This method returns the highest rent amount
    int index = maxRentPropertyIndex();
    return properties[index].getRentalAmount();
  }
  public String toString(){
    String output = "List of the properties for " + name + ", taxID: " + taxId + "\n";
    for (int i = 0; i < n_properties; i++){
      output += properties[i].toString();  
    }
    output += "total management Fee: " + String.valueOf(managementFee * n_properties);
    return output;
  } 
}