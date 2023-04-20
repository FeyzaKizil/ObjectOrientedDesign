package Zoo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Date;


public class ZooApplication extends JFrame implements ActionListener{
	
	private JTextField nameField, speciesField, breedField, dobField, weightField, habitatField, allergicField, staffNameField, positionField, responsibleForAnimalsField;
    private JButton searchAnimal, login;
    
    private Animal animal;
    private Staff staff;
    
    public ZooApplication(){
    	setTitle("Zoo Allergy Control Application");
    	setSize(400, 300);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
    	//Staff
    	login = new JButton("Login");
    	login.addActionListener(this);
		panel.add(login);
    
        panel.add(new JLabel("Login User:"));
        staffNameField = new JTextField(20);
        panel.add(staffNameField);

        panel.add(new JLabel("Position:"));
        positionField = new JTextField(20);
        panel.add(positionField);
        
        panel.add(new JLabel("List of responsible animals: "));
        responsibleForAnimalsField = new JTextField(20);
        panel.add(responsibleForAnimalsField);
    	
        //Animal
    	JLabel animalNameLabel = new JLabel("Animal Name:");
        panel.add(animalNameLabel);
        nameField = new JTextField();
        panel.add(nameField);
        
        searchAnimal = new JButton("Search Animal");
        searchAnimal.addActionListener(this);
		panel.add(searchAnimal);
		
		panel.add(new JLabel("Species:"));
        speciesField = new JTextField(20);
        panel.add(speciesField);
        
        panel.add(new JLabel("Breed:"));
        breedField = new JTextField(20);
        panel.add(breedField);

        panel.add(new JLabel("Date of Birth :"));
        dobField = new JTextField(20);
        panel.add(dobField);

        panel.add(new JLabel("Weight:"));
        weightField = new JTextField(20);
        panel.add(weightField);

        panel.add(new JLabel("Allergic:"));
        allergicField = new JTextField(20);
        panel.add(allergicField);

        panel.add(new JLabel("Habitat:"));
        habitatField = new JTextField(20);
        panel.add(habitatField);
             
		add(panel);
		setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Search Animal")) {
			
			if(nameField.getText().toLowerCase().equals(String.valueOf(animal.getName()).toLowerCase()))
			{
				speciesField.setText(String.valueOf(animal.getSpecies()));
				breedField.setText(String.valueOf(animal.getBreed()));
				dobField.setText(String.valueOf(animal.getDateOfBirth()));
				weightField.setText(String.valueOf(animal.getWeight()));
				allergicField.setText(String.valueOf(animal.getAllergic()));
				habitatField.setText(String.valueOf(animal.getHabitat()));
				
			}
			else
			{
				speciesField.setText("The Animal name not registered.");
				breedField.setText("-");
				dobField.setText("-");
				weightField.setText("-");
				allergicField.setText("-");
				habitatField.setText("-");
				
			}			
		}
		else if(action.equals("Login")) {
			staffNameField.setText(String.valueOf(staff.getName()));
			positionField.setText(String.valueOf(staff.getPosition()));
			responsibleForAnimalsField.setText(String.valueOf(staff.getResponsibleForAnimals()));
		}
	}

	public static void main(String[] args) {
		
		ZooApplication app = new ZooApplication();
		app.animal = new Animal("MöMö","Cow","No","Barn",LocalDate.now(),90.5,"Hazelnut, Strawwbery");
		app.staff = new Staff(1,"Feyza Kızıl","505 555 55 55","Ataşehir","Zoo Curator","507 777 77 77",LocalDate.now(),"Mömö, Gıdak");
	}
	
}
class Animal {
	private String name;
    private String species;
    private String breed;
    private String habitat;
    private LocalDate dateOfBirth;
    private double weight;
    private String allergic;
    
    public Animal(String name, String species, String breed, String habitat,LocalDate dateOfBirth, double weight,String allergic) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.habitat = habitat;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.allergic = allergic;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }  
    
    public String getAllergic() {
        return allergic;
    }
    
    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }
    
    
    public String toString() {
        return "Name: " + name + "\n" +
               "Species: " + species + "\n" +
               "Breed: " + breed + "\n" +
               "Habitat: " + habitat + "\n" +
               "Date of Birth: " + dateOfBirth.toString() + "\n" +
               "Weight: " + weight + " kg"+ "\n" +
        	   "Allergic to: " + allergic ;
    }
}

class Staff {
	private int userId;
	private String name;
	private String phoneNumber;
	private String address;
    private String position;
    private String emergencyContactNumber;
    private LocalDate jobStartDate;
    private String responsibleForAnimals;
    
    public Staff(int userId, String name, String phoneNumber,String address, String position, String emergencyContactNumber, LocalDate jobStartDate,String responsibleForAnimals) {
    	this.userId = userId;
    	this.name = name;
    	this.phoneNumber = phoneNumber;
    	this.address = address;
        this.position = position;
        this.emergencyContactNumber = emergencyContactNumber;
        this.jobStartDate = jobStartDate;
        this.responsibleForAnimals= responsibleForAnimals;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public LocalDate getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(LocalDate jobStartDate) {
        this.jobStartDate = jobStartDate;
    }
    
    public String getResponsibleForAnimals() {
        return responsibleForAnimals;
    }

    public void setResponsibleForAnimals(String responsibleForAnimals) {
        this.responsibleForAnimals = responsibleForAnimals;
    }
    
    public String toString() {
        return "Staff{" +
        		"userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", jobStartDate=" + jobStartDate +
                '}';
    }
}
