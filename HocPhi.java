import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name; 
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {return id;}
    public String getName() {return name;}
}

class Subject {
    private String name;
    private int credits;

    public Subject(String code, String name, int credits){
        this.name = name;
        this.credits = credits;
    }
    public String getName() {return name;}
    public int getCredits() {return credits;}
}

class Rule{
    private String ruleId;
    private double feePerCredit;

    public Rule(String ruleId, String ruleName, double feePerCredit){
        this.ruleId = ruleId;
        this.feePerCredit = feePerCredit;
    }
    public String getRuleId() {return ruleId;}
    public double getFeePerCredit() {return feePerCredit;}
}

class Invoice {
    private Student student;
    private List<Subject> subjects;
    private Rule rule;
    private double totalFee;

    public Invoice(Student student, List<Subject> subjects, Rule rule){
        this.student = student;
        this.subjects = subjects;
        this.rule = rule;

        int totalCredits = 0;
        for (Subject s : subjects){
            totalCredits += s.getCredits();
        }
        this.totalFee = totalCredits * rule.getFeePerCredit();
    }
    public Student getStudent() {return student;}
    public List<Subject> getSubjects() {return subjects;}
    public double getTotalFee() {return totalFee;}
    public Rule getRule() {return rule;}
}

class PaymentController {
    public Invoice getInvoice(){
        Scanner sc = new Scanner(System.in);

        String studentId = sc.nextLine().trim();
        String studentName = sc.nextLine().trim();
        Student student = new Student(studentId, studentName);
    
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i<n;i++ ){
            String code = sc.nextLine().trim();
            String subjectName = sc.nextLine().trim();
            int credits = Integer.parseInt(sc.nextLine().trim());
            subjects.add(new Subject(code, subjectName, credits));
        }        
        String ruleId = sc.nextLine().trim();        
        String ruleName = sc.nextLine().trim();
        double feePerCredit = Double.parseDouble(sc.nextLine().trim());
        Rule rule = new Rule(ruleId, ruleName, feePerCredit);

        Invoice invoice = new Invoice(student, subjects, rule);
        
        
        sc.close();
        return invoice;
    }
}
class InvoiceView {
    public static void show(Invoice invoice) {
        System.out.println("Mã sinh viên: " + invoice.getStudent().getId());
        System.out.println("Họ tên: " + invoice.getStudent().getName());
        System.out.println("Các môn học:");
        for (Subject s : invoice.getSubjects()) {
            System.out.println(s.getName());
        }
        System.out.println("Học phí phải nộp là: " + invoice.getTotalFee());
        System.out.println("Theo QĐ: " + invoice.getRule().getRuleId());
    }
}

public class HocPhi {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}