import java.util.ArrayList;
import java.util.List;

public class UniversityYear {
    private String yearId;
    private List<Specialty> specialties;

    public UniversityYear(String yearId) {
        this.yearId = yearId;
        this.specialties = new ArrayList<>();
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String year) {
        this.yearId = year;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }

    public void removeSpecialty(Specialty specialty) {
        specialties.remove(specialty);
    }
    
}
