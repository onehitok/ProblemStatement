package sg.edu.rp.c346.id20041194.L13ProblemStatement;

public class HospitalRecords {
    String institution; //institution_type
    String facility;
    String year;
    String facilityNo;
    String beds;


    public HospitalRecords(String institution, String facility, String year, String facilityNo, String beds) {
        this.institution = institution;
        this.facility = facility;
        this.year = year;
        this.facilityNo = facilityNo;
        this.beds = beds;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    @Override
    public String toString() {
        return "Hospital Records \n"
                + "Institution: " + institution + "\n"
                + "Facility Type: " + facility + "\n"
                + "No. of beds: /" + year + "\n"
                + "No. of facilities: " + facilityNo + "\n"
                + "Year: " + beds;
    }
}
