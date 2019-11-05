import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	private String name;
	private int age;
	private int money;
	private int d;
	public void Setver(String N , int A , int M) {
		this.name = N;
		this.age = A;
		this.money = M;
	}
	public String  get() {
		return "Name: " + name +"\nAge: "+age+"\nMoney: " + money;
	}
	public void MakeAccount() {
		try {
		Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
		Statement Stmt = MyCon.createStatement();
		Stmt.executeUpdate("insert into account(Name,Age,Money) values ('"+ name +"','"+ age +"','" + money + "')");
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public int GetAge(String GetName) {
		try {
			Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
			Statement Stmt = MyCon.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM account WHERE Name='" + GetName + "'");
			rs.next();
			int e = rs.getInt("Age");
			this.d = e;
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		return d;
	}
	public int GetMoney(String GetM) {
		try {
			Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
			Statement Stmt = MyCon.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM account WHERE Name='" + GetM + "'");
			rs.next();
			int e = rs.getInt("Money");
			this.d = e;
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		return d;
	}
	public void DeleteAccount(String DN) {
		try {
			Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
			Statement Stmt = MyCon.createStatement();
			Stmt.executeUpdate("DELETE FROM account WHERE Name='" + DN + "'");
			System.out.println("Your Account has been Deleted");
			}
			catch(Exception e) {
				e.getStackTrace();
			}
	}
	public void AddMoney(String GM,int AM) {
		try {
			Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
			Statement Stmt = MyCon.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM account WHERE Name='" + GM + "'");
			rs.next();
			int e = rs.getInt("Money");
			int Total = e + AM;
			Stmt.executeUpdate("update account set Money="+Total+" where Name='"+GM+"'");
			}
			catch(Exception e) {
				e.getStackTrace();
			}
	}
	public void Withdraw(String GM,int AM) {
		try {
			Connection MyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","password");
			Statement Stmt = MyCon.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM account WHERE Name='" + GM + "'");
			rs.next();
			int e = rs.getInt("Money");
			int Total = e - AM;
			Stmt.executeUpdate("update account set Money="+Total+" where Name='"+GM+"'");
			}
			catch(Exception e) {
				e.getStackTrace();
			}
	}
}
