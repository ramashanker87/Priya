package Custom;

public class FinallyCode_ToCallContractor {
    public static void main(String[] args) {
        FinallyCode_ToCallContractor test = new FinallyCode_ToCallContractor();
        try {
            test.validateAge(18);
        } catch (Agevalidation e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("completed");
        }
    }

    public void validateAge(int age) throws Agevalidation {
        if (age < 20) {
            throw new Agevalidation("Age must be 20 or older.");
        }
    }
}
