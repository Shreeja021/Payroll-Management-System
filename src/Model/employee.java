package Model;

public class employee {
    private int id;
    //encapsulation
    private String fname;
    private String lname;
    private String dateofbirth;
    private String hiredate;
    private String address;
    private String phoneno;
    // get - valuess can be accessed
    private String role;

    public int getId() {
        return id;
    }
    public String getFname()
    {
        return fname;
    }
    public String getLname()
    {
        return lname;
    }
    public String getDateofbirth()
    {
        return dateofbirth;
    }
    public String getHiredate()
    {
        return hiredate;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPhoneno()
    {
        return phoneno;
    }
    public String getRole()
    {
        return role;
    }


    public void setId(int id) {
        this.id = id;
    }
    // this - instance variable
    public void setFname(String fname)
    {
        this.fname= fname;
    }
    public void setLname(String lname)
    {
        this.lname=lname;
    }
    public void setDateofbirth(String dateofbirth)
    {
        this.dateofbirth=dateofbirth;
    }
    public void setHiredate(String hiredate)
    {
        this.hiredate=hiredate;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setPhoneno(String phoneno)
    {
        this.phoneno=phoneno;
    }

    public void setRole(String role)
    {
        this.role=role;
    }
}

