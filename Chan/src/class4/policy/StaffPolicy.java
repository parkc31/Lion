package class4.policy;

public class StaffPolicy implements AssignmentPolicy{
    @Override
    public boolean Submit(){
        return false;
    }
}
